package org.qcri.rheem.latin.core.plan.operator.logical;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.expression.LatinExpression;
import org.qcri.rheem.latin.core.plan.expression.RealFunctionExpression;
import org.qcri.rheem.latin.core.plan.operator.LatinComponents;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;
import org.qcri.rheem.latin.core.plan.operator.OperatorInput;
import org.qcri.rheem.latin.core.plan.operator.OperatorOutput;

public class BagOperator extends LatinOperator implements OperatorInput, OperatorOutput{

    public BagOperator(String name, int inputs, int outputs){
        super(name);
        this.inputs = new LatinComponents(inputs);
        this.outputs = new LatinComponents(outputs);
    }
    @Override
    protected void selfCopy(LatinElement element) {

    }

    @Override
    public Class getTypeInput(int index) {
        return this.inputs.getType(index);
    }

    @Override
    public Class[] getTypesInput() {
        return this.inputs.getTypes();
    }

    @Override
    public String getAliasInput(int index) {
        return this.inputs.getAlias(index);
    }

    @Override
    public String[] getAllAliasInput() {
        return this.inputs.getAllAlias();
    }

    @Override
    public LatinOperator getOperatorInput(int index) {
        return this.inputs.getOperator(index);
    }

    @Override
    public LatinOperator getOperatorInput(String name) {
        return this.inputs.getOperator(name);
    }

    @Override
    public LatinOperator[] getOperatorsInput() {
        return this.inputs.getOperators();
    }

    @Override
    public LatinExpression getExpressionInput(int index) {
        return this.inputs.getExpression(index);
    }

    @Override
    public LatinExpression[] getExpressionsInput() {
        return this.inputs.getExpressions();
    }

    @Override
    public void setTypeInput(int index, Class clazz) {
        this.inputs.setType(index, clazz);
    }

    @Override
    public void setOperatorInput(int index, LatinOperator operator) {
        this.inputs.setOperator(index, operator);
    }

    @Override
    public void setAliasInput(int index, String alias) {
        this.inputs.setAlias(index, alias);
    }

    @Override
    public void setExpressionInput(int index, LatinExpression expression) {
        this.inputs.setExpression(index, expression);
    }

    @Override
    public int getSizeInput() {
        return this.inputs.getSize();
    }

    @Override
    public Class getTypeOutput(int index) {
        return this.outputs.getType(index);
    }

    @Override
    public Class[] getTypesOutput() {
        return this.outputs.getTypes();
    }

    @Override
    public String getAliasOutput(int index) {
        return this.outputs.getAlias(index);
    }

    @Override
    public String[] getAllAliasOutput() {
        return this.outputs.getAllAlias();
    }

    @Override
    public LatinOperator getOperatorOutput(int index) {
        return this.outputs.getOperator(index);
    }

    @Override
    public LatinOperator getOperatorOutput(String name) {
        return this.outputs.getOperator(name);
    }

    @Override
    public LatinOperator[] getOperatorsOutput() {
        return this.outputs.getOperators();
    }

    @Override
    public LatinExpression getExpressionOutput(int index) {
        return this.outputs.getExpression(index);
    }

    @Override
    public LatinExpression[] getExpressionsOutput() {
        return this.outputs.getExpressions();
    }

    @Override
    public void setTypeOutput(int index, Class clazz) {
        this.outputs.setType(index, clazz);
    }

    @Override
    public void setOperatorOutput(int index, LatinOperator operator) {
        this.outputs.setOperator(index, operator);
    }

    @Override
    public void setAliasOutput(int index, String alias) {
        this.outputs.setAlias(index, alias);
    }

    @Override
    public void setExpressionOutput(int index, LatinExpression expression) {
        this.outputs.setExpression(index, expression);
    }

    @Override
    public int getSizeOutput() {
        return this.outputs.getSize();
    }

    @Override
    public void changeTypes() {
        //TODO es el mismo caso que para ManyOperator
        for(int j = 0; j < this.getSizeInput(); j++){
            if(this.getExpressionInput(j) instanceof RealFunctionExpression){
                RealFunctionExpression real_func = (RealFunctionExpression)this.getExpressionInput(j);
                this.setTypeOutput(0, real_func.getType_return());
            }
        }
    }
}
