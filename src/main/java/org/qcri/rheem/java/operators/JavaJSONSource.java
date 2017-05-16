package org.qcri.rheem.java.operators;

import org.qcri.rheem.basic.data.RecordDinamic;
import org.qcri.rheem.basic.operators.JSONSource;
import org.qcri.rheem.core.optimizer.OptimizationContext;
import org.qcri.rheem.core.plan.rheemplan.ExecutionOperator;
import org.qcri.rheem.core.platform.ChannelDescriptor;
import org.qcri.rheem.core.platform.ChannelInstance;
import org.qcri.rheem.core.platform.lineage.ExecutionLineageNode;
import org.qcri.rheem.core.util.JSONParser;
import org.qcri.rheem.core.util.Tuple;
import org.qcri.rheem.java.channels.StreamChannel;
import org.qcri.rheem.java.execution.JavaExecutor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by bertty on 16-04-17.
 */
public class JavaJSONSource extends JSONSource implements JavaExecutionOperator{

    JavaTextFileSource file_source = null;

    public JavaJSONSource(String inputUrl) {
        super(inputUrl);
        this.file_source = new JavaTextFileSource(inputUrl);
    }

    public JavaJSONSource(String inputUrl, String encoding) {
        super(inputUrl, encoding);
        this.file_source = new JavaTextFileSource(inputUrl);
    }

    public JavaJSONSource(JSONSource that) {
        super(that);
        this.file_source = new JavaTextFileSource(that.getFile());
    }

    public JavaJSONSource(String inputUrl, String[] words){
        super(inputUrl, words);
        this.file_source = new JavaTextFileSource(inputUrl);
    }

    public Tuple<Collection<ExecutionLineageNode>, Collection<ChannelInstance>> evaluate(ChannelInstance[] inputs, ChannelInstance[] outputs, JavaExecutor javaExecutor, OptimizationContext.OperatorContext operatorContext) {
        //carga la configuracion de lectura
        this.file_source.evaluate(inputs, outputs, javaExecutor, operatorContext);
        //se obtiene el stream original, para aplicar el nuevo filtro
        Stream<String> stream = ((StreamChannel.Instance) outputs[0]).provideStream();
        //se establece el filtro nuevo sobre el stream
        Stream<RecordDinamic> record = stream.map(line -> {return JSONParser.execute(line, this.getWords_tokens());});
        //se asigna el nuevo stream en la zona correspondiente
        ((StreamChannel.Instance) outputs[0]).accept(record);
        //se efectua la carga de los parametros para la posterior ejecucion
        return ExecutionOperator.modelLazyExecution(inputs, outputs, operatorContext);
    }

    @Override
    public Collection<String> getLoadProfileEstimatorConfigurationKeys() {
        return Arrays.asList("rheem.java.textfilesource.load.prepare", "rheem.java.textfilesource.load.main");
    }

    public JavaJSONSource copy() {
        return new JavaJSONSource(this);
    }

    public List<ChannelDescriptor> getSupportedInputChannels(int index) {
        throw new UnsupportedOperationException(String.format("%s does not have input channels.", new Object[]{this}));
    }

    public List<ChannelDescriptor> getSupportedOutputChannels(int index) {
        assert index <= this.getNumOutputs() || index == 0 && this.getNumOutputs() == 0;

        return Collections.singletonList(StreamChannel.DESCRIPTOR);
    }


}
