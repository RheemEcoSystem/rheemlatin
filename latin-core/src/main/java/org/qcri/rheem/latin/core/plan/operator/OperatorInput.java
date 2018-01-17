package org.qcri.rheem.latin.core.plan.operator;


import org.qcri.rheem.latin.core.plan.expression.LatinExpression;

public interface OperatorInput {

    Class getTypeInput(int index);

    Class[] getTypesInput();

    String getAliasInput(int index);

    String[] getAllAliasInput();

    LatinOperator getOperatorInput(int index);

    LatinOperator getOperatorInput(String name);

    LatinOperator[] getOperatorsInput();

    LatinExpression getExpressionInput(int index);

    LatinExpression[] getExpressionsInput();

    String[] getExpressionsAliasInput();

    String getExpressionAliasInput(int index);

    void setTypeInput(int index, Class clazz);

    void setOperatorInput(int index, LatinOperator operator);

    void setAliasInput(int index, String alias);

    void setExpressionInput(int index, LatinExpression expression);

    void setExpressionAliasInput(int index, String alias_expression);

    int getSizeInput();
}
