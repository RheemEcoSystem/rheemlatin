package org.qcri.rheem.latin.plan.operator.logical;

import org.qcri.rheem.latin.plan.operator.LatinExpression;
import org.qcri.rheem.latin.plan.operator.LatinOperator;
import org.qcri.rheem.latin.plan.operator.OperatorInput;

/**
 * Created by bertty on 06-04-17.
 */
public class SinkOperator extends LatinOperator implements OperatorInput{

    private LatinOperator[]    operatorInput = null;
    private Class[]            classInput    = null;
    private String[]           aliasInput    = null;
    private int                ninputs        = 0;

    private String            path_source    = null;


    public SinkOperator(String name, int nInput) {
        super(name);
        this.ninputs = nInput;
        this.classInput      = new Class[this.ninputs];
        this.aliasInput      = new String[this.ninputs];
        this.operatorInput   = new LatinOperator[this.getNinputs()];

    }


    public String getPath_source() {
        return path_source;
    }

    public void setPath_source(String path_source) {
        this.path_source = path_source;
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

    public void setAliasInput(String alias){
        for(int i = 0; i < this.ninputs; i++){
            if(this.aliasInput[i] == null){
                this.aliasInput[i] = alias;
                return;
            }
        }
    }

    public boolean isValid(){
        return true;
    }

    @Override
    public LatinExpression[] getExpressionInput() {
        return null;
    }

    @Override
    public LatinExpression getExpressionInput(int Index) {
        return null;
    }

    @Override
    public void setExpressionInput(int index, LatinExpression expressionInput) {

    }

    public Object[] getParams(String[] params){
        Object[] obj = super.getParams(params);
        int class_count = 0;
        for(int i = 0; i < params.length; i++){
            if(params[i].equalsIgnoreCase("string")){
                obj[i] = this.path_source;
            }
            if(params[i].equals("class")){
                if(class_count < this.classInput.length) {
                    obj[i] = this.classInput[class_count];
                    class_count++;
                }else{
                    obj[i] = this.classOutput;
                }
            }
        }
        return obj;
    }
}
