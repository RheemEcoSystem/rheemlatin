package org.qcri.rheem.latin.plan.operator.logical;

import org.qcri.rheem.core.function.FunctionDescriptor;
import org.qcri.rheem.latin.plan.operator.LatinExpression;
import org.qcri.rheem.latin.plan.operator.LatinOperator;
import org.qcri.rheem.latin.plan.operator.OperatorInput;
import org.qcri.rheem.latin.translator.expression.BuilderExpression;
import org.qcri.rheem.latin.translator.expression.Expression;
import org.qcri.rheem.latin.util.LatinException;

/**
 * Created by bertty on 06-04-17.
 */
public class ManyOperator extends LatinOperator implements OperatorInput {
    private LatinExpression[] expressionInput = null;
    private Class[]           classInput      = null;
    private String[]          aliasInput      = null;
    private LatinOperator[]   operatorInput   = null;
    private int               ninputs         = 0;

    public ManyOperator(String name, int ninputs) {
        super(name);
        // recuperar configuracion del operador atravez de alguna clase
        this.ninputs = ninputs;
        this.expressionInput = new LatinExpression[this.ninputs];
        this.classInput      = new Class[this.ninputs];
        this.aliasInput      = new String[this.ninputs];
        this.operatorInput   = new LatinOperator[this.getNinputs()];
    }

    public LatinExpression[] getExpressionInput() {
        return expressionInput;
    }

    public LatinExpression getExpressionInput(int index){
        return this.expressionInput[index];
    }

    public void setExpressionInput(LatinExpression[] expressionInput) {
        this.expressionInput = expressionInput;
    }

    public void setExpressionInput(int index, LatinExpression expressionInput){
        this.expressionInput[index] = expressionInput;
    }


    public Class[] getClassInput() {
        return classInput;
    }

    public Class getClassInput(int index) {
        return classInput[index];
    }

    public void setClassInput(Class[] classInput) {
        this.classInput = classInput;
    }

    public void setClassInput(int index, Class classInput) {
        this.classInput[index] = classInput;
    }

    public String[] getAliasInput() {
        return aliasInput;
    }

    public String getAliasInput(int index) {
        return aliasInput[index];
    }

    public void setAliasInput(String[] aliasInput) {
        this.aliasInput = aliasInput;
    }

    public void setAliasInput(int index, String aliasInput) {
        this.aliasInput[index] = aliasInput;
    }

    public int getNinputs() {
        return ninputs;
    }


    public LatinOperator[] getOperatorInput() {
        return operatorInput;
    }

    public LatinOperator getOperatorInput(int index) {
        return operatorInput[index];
    }


    public void setOperatorInput(int index, LatinOperator operatorInput) {
        this.operatorInput[index] = operatorInput;
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

    public boolean isValid() throws Exception {
        if (this.classOutput == null) {
            if (this.ninputs == 1) {
                this.classOutput = this.getClassInput(0);
            } else {
                throw new Exception("Error Class Output invalid for " + this.alias);
            }
        }
        return true;
    }

    public Object[] getParams(String[] params){
        Object[] obj = super.getParams(params);
        int class_index = 0;
        int expre_index = 0;
        for(int i = 0; i < params.length; i++){
            if( params[i].equals("function") || params[i].equals("predicate") ) {
                if(this.expressionInput[expre_index].isImplemented()){
                    Object fun = this.expressionInput[expre_index].getImplementation();
                    if( fun == null ){
                        //TODO: create a exception with good message
                        throw new LatinException("We have a problem with the implementaion");
                    }
                    if (params[i].equals("function")) {
                        obj[i] = (FunctionDescriptor.SerializableFunction) fun;
                    }
                    if (params[i].equals("predicate")) {
                        obj[i] = (FunctionDescriptor.SerializablePredicate) fun;
                    }
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

        return obj;
    }

}
