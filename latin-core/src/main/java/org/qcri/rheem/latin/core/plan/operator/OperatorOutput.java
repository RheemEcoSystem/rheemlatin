package org.qcri.rheem.latin.core.plan.operator;

import org.qcri.rheem.latin.core.plan.expression.LatinExpression;

public interface OperatorOutput {

    Class getTypeOutput(int index);

    Class[] getTypesOutput();

    String getAliasOutput(int index);

    String[] getAllAliasOutput();

    LatinOperator getOperatorOutput(int index);

    LatinOperator getOperatorOutput(String name);

    LatinOperator[] getOperatorsOutput();

    LatinExpression getExpressionOutput(int index);

    LatinExpression[] getExpressionsOutput();

    void setTypeOutput(int index, Class clazz);

    void setOperatorOutput(int index, LatinOperator operator);

    void setAliasOutput(int index, String alias);

    void setExpressionOutput(int index, LatinExpression expression);

    int getSizeOutput();
}
