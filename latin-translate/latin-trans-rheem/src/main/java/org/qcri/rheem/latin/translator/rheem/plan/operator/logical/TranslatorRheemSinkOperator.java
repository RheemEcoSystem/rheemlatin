package org.qcri.rheem.latin.translator.rheem.plan.operator.logical;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;
import org.qcri.rheem.latin.core.plan.operator.logical.SinkOperator;
import org.qcri.rheem.latin.translator.rheem.exception.TranslatorRheemException;
import org.qcri.rheem.latin.translator.rheem.mapping.ParameterType;
import org.qcri.rheem.latin.translator.rheem.plan.operator.TranslatorRheemOperator;

public class TranslatorRheemSinkOperator extends TranslatorRheemOperator {
    private String path_source;

    public TranslatorRheemSinkOperator(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {
        super.selfCopy(element);
        if( !(element instanceof SinkOperator)){
            throw new TranslatorRheemException(
                String.format(
                    "the class \"%s\" of the [%s]is not extension of the %s",
                    element.getClass(),
                    element,
                    LatinOperator.class
                )
            );
        }
        SinkOperator operator = (SinkOperator) element;
        this.path_source = operator.getPath_source();
    }

    @Override
    public Object[] getParams() {
        Object[] obj = super.getParams();
        int class_count = 0;
        for(int i = 0; i < params.length; i++){
            if(params[i] == ParameterType.STRING){
                obj[i] = this.path_source;
            }
            if(params[i] == ParameterType.CLASS){
                if(class_count < this.inputs.getSize()) {
                    obj[i] = this.inputs.getType(class_count);
                    class_count++;
                }else{
                    obj[i] = this.outputs.getType(0);
                }
            }
        }
        return obj;
    }


}
