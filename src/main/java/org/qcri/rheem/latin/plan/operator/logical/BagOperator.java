package org.qcri.rheem.latin.plan.operator.logical;

import org.qcri.rheem.basic.data.Tuple2;
import org.qcri.rheem.core.function.FunctionDescriptor;
import org.qcri.rheem.latin.UDF.UDFFunction;
import org.qcri.rheem.latin.plan.operator.LatinExpression;
import org.qcri.rheem.latin.plan.operator.LatinOperator;
import org.qcri.rheem.latin.plan.operator.OperatorInput;
import org.qcri.rheem.latin.translator.expression.BuilderExpression;
import org.qcri.rheem.latin.translator.expression.Expression;
import org.qcri.rheem.latin.util.LatinException;

import java.util.function.Function;

public class BagOperator extends LatinOperator implements OperatorInput{

    private LatinExpression   expressionInput = null;
    private Class             classInput      = null;
    private String            aliasInput      = null;
    private LatinOperator     operatorInput   = null;
    private int               ninputs         = 1;


    public BagOperator(String name) {
        super(name);
    }

    //TODO: this mapping that send to the file configuration
    @Override
    public String getName(){
        return "MAP";
    }

    //TODO: valid de implemetnation of the methods
    @Override
    public Class[] getClassInput() {
        return new Class[0];
    }

    @Override
    public Class getClassInput(int index) {
        if(index != 0){
            //TODO: EXCEPTION
            throw new LatinException("error");
        }
        return this.classInput;
    }

    @Override
    public void setClassInput(Class[] classInput) {

    }

    @Override
    public void setClassInput(int index, Class classInput) {
        if(index != 0){
            //TODO: EXCEPTION
            throw new LatinException("error");
        }
        this.classInput = classInput;
    }

    @Override
    public String[] getAliasInput() {
        return new String[0];
    }

    @Override
    public String getAliasInput(int index) {
        if(index != 0){
            //TODO: EXCEPTION
            throw new LatinException("error");
        }
        return this.aliasInput;
    }

    @Override
    public void setAliasInput(String[] aliasInput) {

    }

    @Override
    public void setAliasInput(int index, String aliasInput) {
        if(index != 0){
            //TODO: EXCEPTION
            throw new LatinException("error");
        }
        this.aliasInput = aliasInput;
    }

    @Override
    public int getNinputs() {
        return 1;
    }

    @Override
    public LatinOperator[] getOperatorInput() {
        return new LatinOperator[0];
    }

    @Override
    public LatinOperator getOperatorInput(int index) {
        return null;
    }

    @Override
    public void setOperatorInput(int index, LatinOperator operatorInput) {

    }

    @Override
    public boolean isValid() throws Exception {
        return false;
    }

    @Override
    public LatinExpression[] getExpressionInput() {
        return new LatinExpression[0];
    }

    @Override
    public LatinExpression getExpressionInput(int Index) {
        return null;
    }

    @Override
    public void setExpressionInput(int index, LatinExpression expressionInput) {

    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("\t inputs: {");
        for(int i= 0; i < this.ninputs; i++){
            builder.append("[ ");
            builder.append(i);
            builder.append(" , ");
            builder.append(this.getAliasInput(i));
            builder.append(" , ");
            builder.append(this.getClassInput(i));
            builder.append(" ]");
        }
        builder.append("} ");

        return builder.toString();
    }

    @Override
    public Object[] getParams(String[] params){
        Object[] obj = super.getParams(params);
        obj[0] =(UDFFunction) a -> {
            return new Tuple2<Integer, Integer>(1,2);
        };

        obj[1] = this.classInput;
        obj[2] = this.classOutput;


        return obj;
        /*
        Object[] obj = super.getParams(params);
        int class_index = 0;
        int expre_index = 0;
        for(int i = 0; i < params.length; i++){
            if( params[i].equals("function") || params[i].equals("predicate") ) {
                if(this.expressionInput[expre_index].isImplemented()){

                    Object fun = this.expressionInput[expre_index].getImplementation(this.broadcast);
                    if( fun == null ){
                        //TODO: create a exception with good message
                        throw new LatinException("We have a problem with the implementaion");
                    }
                    /*if (params[i].equals("function")) {
                        obj[i] = (FunctionDescriptor.SerializableFunction) fun;
                    }
                    if (params[i].equals("predicate")) {
                        obj[i] = (FunctionDescriptor.SerializablePredicate) fun;
                    }
                    obj[i] = fun;
                    continue;
                }


                if (params[i].equals("function")) {
                    Expression expr = BuilderExpression.builderExpression(this.expressionInput[expre_index]);
                    obj[i] = (FunctionDescriptor.SerializableFunction) a -> expr.evaluate(a);
                    expre_index++;
                }
                if (params[i].equals("predicate")) {
                    Expression expr = BuilderExpression.builderExpression(this.expressionInput[expre_index]);
                    obj[i] = (FunctionDescriptor.SerializablePredicate) a -> (Boolean) expr.evaluate(a);
                    expre_index++;
                }
            }
            if(params[i].equals("class")){
                if(class_index < this.classInput.length) {
                    obj[i] = this.classInput[class_index];
                    class_index++;
                }else{
                    obj[i] = this.classOutput;
                }
            }
        }

        return obj;*/
    }
}
