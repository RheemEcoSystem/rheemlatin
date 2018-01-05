package org.qcri.rheem.latin.translator.rheem.plan.operator.logical;

import org.qcri.rheem.core.function.FunctionDescriptor;
import org.qcri.rheem.latin.core.Exception.LatinException;
import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.expression.RealFunctionExpression;
import org.qcri.rheem.latin.translator.rheem.exception.TranslatorRheemException;
import org.qcri.rheem.latin.translator.rheem.expression.BuilderExpression;
import org.qcri.rheem.latin.translator.rheem.expression.Expression;
import org.qcri.rheem.latin.translator.rheem.mapping.ParameterType;
import org.qcri.rheem.latin.translator.rheem.plan.operator.TranslatorRheemOperator;
import org.qcri.rheem.latin.udf.broadcast.FunctionBroadcast;
import org.qcri.rheem.latin.udf.broadcast.UDFunctionBroadcast;

import java.lang.reflect.Method;

public class TranslatorRheemManyOperator extends TranslatorRheemOperator {

    public TranslatorRheemManyOperator(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {
        super.selfCopy(element);
    }

    @Override
    public Object[] getParams() {
        Object[] obj = super.getParams();
        int class_index = 0;
        int expre_index = 0;
        for(int i = 0; i < this.params.length; i++){
            if( params[i] == ParameterType.FUNCTION || params[i] == ParameterType.PREDICATE) {

                if(this.inputs.getExpression(expre_index).isImplemented()){
                    RealFunctionExpression expre = (RealFunctionExpression) this.inputs.getExpression(expre_index);
                    Object[] parameters = expre.getParameters_method();
                    Object fun = TranslatorRheemOperator.getLambda(expre.getClass_reference().getName(), expre.getName_method(), parameters);

                    if( fun == null ){
                        //TODO: create a exception with good message
                        throw new TranslatorRheemException("We have a problem with the implementation");
                    }
                    //TODO: crear la funcion para mas parametricas para soportar mas de un broadcast

                    if(this.broadcast_name.size() > 0){
                        if(fun instanceof FunctionBroadcast && this.broadcast_name.size() == 1){
                            fun = new UDFunctionBroadcast(this.broadcast_name.get(0), (FunctionBroadcast) fun);
                        }else{
                            //TODO: create a exception with good message
                            throw new TranslatorRheemException("We have a problem with the implementation");
                        }
                    }

                    obj[i] = fun;
                    continue;
                }


                if (params[i] == ParameterType.FUNCTION) {
                    Expression expr = BuilderExpression.builderExpression(this.inputs.getExpression(expre_index));
                    obj[i] = (FunctionDescriptor.SerializableFunction) a -> expr.evaluate(a);
                    expre_index++;
                }
                if (params[i] == ParameterType.PREDICATE) {
                    Expression expr = BuilderExpression.builderExpression(this.inputs.getExpression(expre_index));
                    obj[i] = (FunctionDescriptor.SerializablePredicate) a -> (Boolean) expr.evaluate(a);
                    expre_index++;
                }
            }
            if(params[i] == ParameterType.CLASS){
                if(class_index < this.inputs.getSize()) {
                    obj[i] = this.inputs.getType(class_index);
                    class_index++;
                }else{
                    obj[i] = this.outputs.getType(0);
                }
            }
        }

        return obj;
    }
}
