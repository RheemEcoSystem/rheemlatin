package org.qcri.rheem.latin.core.plan.operator.logical;

import org.qcri.rheem.latin.core.exception.LatinCoreException;
import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.expression.LatinExpression;
import org.qcri.rheem.latin.core.plan.operator.LatinComponents;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;
import org.qcri.rheem.latin.core.plan.operator.OperatorOutput;

public class SourceOperator extends LatinOperator implements OperatorOutput {

    private String path_source;

    private String[] name_var;

    private String[] type_var;

    public SourceOperator(String name, int inputs, int outputs){
        super(name);
        if(inputs != 0){
            throw new LatinCoreException(
                    String.format("the operator(%s) is a sinkOperator can't have a output")
            );
        }
        this.inputs = new LatinComponents(inputs);
        this.outputs = new LatinComponents(outputs);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }

    @Override
    public String[] getExpressionsAliasOutput() {
        return this.outputs.getExpressions_alias();
    }

    @Override
    public String getExpressionAliasOutput(int index) {
        return this.outputs.getExpression_alias(index);
    }

    @Override
    public void setExpressionAliasOutput(int index, String alias_expression) {
        this.outputs.setExpression_alias(index, alias_expression);
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

    }

    public String getPath_source() {
        return path_source;
    }

    public void setPath_source(String path_source) {
        this.path_source = path_source;
    }

    public String[] getName_var() {
        return name_var;
    }

    public void setName_var(String[] name_var) {
        this.name_var = name_var;
    }

    public String[] getType_var() {
        return type_var;
    }

    public void setType_var(String[] type_var) {
        this.type_var = type_var;
    }
}
