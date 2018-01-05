package org.qcri.rheem.latin.translator.rheem.plan.operator;

import org.qcri.rheem.latin.core.context.LatinContext;
import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;
import org.qcri.rheem.latin.core.context.ParserImportClass;
import org.qcri.rheem.latin.translator.rheem.exception.TranslatorRheemException;
import org.qcri.rheem.latin.translator.rheem.mapping.ParameterType;
import org.qcri.rheem.latin.udf.broadcast.FunctionBroadcast;
import org.qcri.rheem.latin.udf.broadcast.UDFunctionBroadcast;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class TranslatorRheemOperator extends LatinOperator {

    protected ParameterType[] params = null;


    private static ParserImportClass IMPORTS;
    static{
        IMPORTS = (ParserImportClass) LatinContext.getConfiguration("imports");
    }

    public TranslatorRheemOperator(String name) {
        super(name);
    }

    public TranslatorRheemOperator(LatinElement element) {
        super(element);
    }

    public TranslatorRheemOperator setParams(ParameterType[] params){
        this.params = params;
        return this;
    }

    @Override
    protected void selfCopy(LatinElement element) {
        if( !(element instanceof LatinOperator)){
            throw new TranslatorRheemException(
                String.format(
                    "the class \"%s\" of the [%s]is not extension of the %s",
                    element.getClass(),
                    element,
                    LatinOperator.class
                )
            );
        }
        LatinOperator operator = (LatinOperator) element;
        this.name = operator.getName();
        this.alias = operator.getAlias();
        this.platform = operator.getPlatform();
        this.broadcast = operator.getBroadcast();
        this.broadcast_name = operator.getBroadcastName();
        this.lambdas = operator.getLambdas();
        this.structure_info = operator.getStructure_info();
        this.inputs  = operator.getInputs();
        this.outputs = operator.getOutputs();
    }

    public Object[] getParams(){
        if(this.params == null){
            throw new TranslatorRheemException("the paramaterType[] is not initialized");
        }
        return new Object[this.params.length];
    }


    public static Object getLambda(String name, String method_name){
        return IMPORTS.getLambda(name, method_name);
    }

    public static Object getImplementation(Object method, String broadcast){
        try {
            if (broadcast == null)
                return ((Method) method).invoke(null);

            return new UDFunctionBroadcast(broadcast, (FunctionBroadcast) ((Method) method).invoke(null));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new TranslatorRheemException(e);
        }
    }


}
