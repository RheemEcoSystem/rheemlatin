package org.qcri.rheem.latin.translator.rheem.context;

import org.qcri.rheem.core.plan.rheemplan.Operator;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;
import org.qcri.rheem.latin.core.plan.operator.logical.BagOperator;
import org.qcri.rheem.latin.core.plan.operator.logical.ManyOperator;
import org.qcri.rheem.latin.core.plan.operator.logical.SinkOperator;
import org.qcri.rheem.latin.core.plan.operator.logical.SourceOperator;
import org.qcri.rheem.latin.translator.rheem.exception.TranslatorRheemException;
import org.qcri.rheem.latin.translator.rheem.mapping.RheemClassMapping;
import org.qcri.rheem.latin.translator.rheem.plan.operator.TranslatorRheemOperator;
import org.qcri.rheem.latin.translator.rheem.plan.operator.logical.TranslatorRheemBagOperator;
import org.qcri.rheem.latin.translator.rheem.plan.operator.logical.TranslatorRheemManyOperator;
import org.qcri.rheem.latin.translator.rheem.plan.operator.logical.TranslatorRheemSinkOperator;
import org.qcri.rheem.latin.translator.rheem.plan.operator.logical.TranslatorRheemSourceOperator;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;

public class TranslatorRheemReflexion {
    private HashMap<String, RheemClassMapping> rheemMapping = null;

    public TranslatorRheemReflexion(){
        this.rheemMapping = new HashMap<>();
    }


    public void put(String key, RheemClassMapping value){
        rheemMapping.put(key, value);
    }

    public Operator getReflexion(LatinOperator operator){
        TranslatorRheemOperator traslator = null;
        RheemClassMapping reflex = rheemMapping.get(operator.getName());
        if(operator instanceof ManyOperator){
            traslator = new TranslatorRheemManyOperator(operator)
                    .setParams(reflex.getParameterTypes());
        }
        if(operator instanceof SinkOperator){
            traslator = new TranslatorRheemSinkOperator(operator)
                    .setParams(reflex.getParameterTypes());
        }
        if(operator instanceof SourceOperator){
            traslator = new TranslatorRheemSourceOperator(operator)
                    .setParams(reflex.getParameterTypes());
        }
        if(operator instanceof BagOperator){
            traslator = new TranslatorRheemBagOperator(operator)
                    .setParams(reflex.getParameterTypes());
        }
        if(traslator == null){
            throw new TranslatorRheemException("the operator not have a mapping");
        }
        Object[] params_real = traslator.getParams();
        Operator rheem_operator = null;
        try {
            rheem_operator = (Operator) reflex.getConstructor().newInstance(params_real);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new TranslatorRheemException(e);
        }

        return rheem_operator;
    }
}
