package org.qcri.rheem.latin.plan.operator;

/**
 * Created by bertty on 12-04-17.
 */
public interface OperatorInput {


    public Class[] getClassInput();

    public Class getClassInput(int index);

    public void setClassInput(Class[] classInput);

    public void setClassInput(int index, Class classInput);

    public String[] getAliasInput();

    public String getAliasInput(int index);

    public void setAliasInput(String[] aliasInput);

    public void setAliasInput(int index, String aliasInput);

    public int getNinputs();

    public LatinOperator[] getOperatorInput();

    public LatinOperator getOperatorInput(int index);

    public void setOperatorInput(int index, LatinOperator operatorInput);

    public boolean isValid() throws Exception;

    public LatinExpression[] getExpressionInput();

    public LatinExpression getExpressionInput(int Index);

    public void setExpressionInput(int index, LatinExpression expressionInput);


}
