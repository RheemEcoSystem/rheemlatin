package org.qcri.rheem.latin.translator.rheem.plan.operator.logical;

import org.qcri.rheem.basic.data.Tuple2;
import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.expression.RealFunctionExpression;
import org.qcri.rheem.latin.core.plan.operator.logical.BagOperator;
import org.qcri.rheem.latin.translator.rheem.exception.TranslatorRheemException;
import org.qcri.rheem.latin.translator.rheem.plan.operator.TranslatorRheemOperator;
import org.qcri.rheem.latin.udf.broadcast.FunctionBroadcast;
import org.qcri.rheem.latin.udf.broadcast.UDFunctionBroadcast;
import org.qcri.rheem.latin.udf.normal.UDFFunction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TranslatorRheemBagOperator extends TranslatorRheemOperator {

    private Object method_parameters;
    public TranslatorRheemBagOperator(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {
        super.selfCopy(element);
        if( !(element instanceof BagOperator)){
            //TODO colocar un mensaje mas descriptivo
            throw new TranslatorRheemException("no es de la clase que corresponde");
        }
        this.method_parameters = method_parameters;
    }

    @Override
    public Object[] getParams() {
        Object[] obj = super.getParams();
        RealFunctionExpression expre = (RealFunctionExpression) this.inputs.getExpression(0);
        Object[] parameters = expre.getParameters_method();
        obj[0] = TranslatorRheemOperator.getLambda(expre.getClass_reference().getName(), expre.getName_method(), parameters);

        obj[1] = this.inputs.getType(0);
        obj[2] = this.outputs.getType(0);


        return obj;
    }

}
