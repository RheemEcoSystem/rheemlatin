package org.qcri.rheem.latin.parser.latin.mapping.transition;

import org.qcri.rheem.latin.parser.latin.mapping.transition.ExpressionTransition;
import org.qcri.rheem.latin.parser.latin.mapping.transition.FunctionTransition;
import org.qcri.rheem.latin.parser.latin.mapping.transition.OperatorTransition;

import java.util.List;

public class ParserLatinTransition {

    private List<ExpressionTransition> expression_mapping;
    private List<FunctionTransition> function_mapping;
    private List<OperatorTransition> operator_mapping;
    private List<WrapperTransition>  wrapper_mapping;

    public List<ExpressionTransition> getExpression_mapping() {
        return expression_mapping;
    }

    public void setExpression_mapping(List<ExpressionTransition> expression_mapping) {
        this.expression_mapping = expression_mapping;
    }

    public List<FunctionTransition> getFunction_mapping() {
        return function_mapping;
    }

    public void setFunction_mapping(List<FunctionTransition> function_mapping) {
        this.function_mapping = function_mapping;
    }

    public List<OperatorTransition> getOperator_mapping() {
        return operator_mapping;
    }

    public void setOperator_mapping(List<OperatorTransition> operator_mapping) {
        this.operator_mapping = operator_mapping;
    }

    public List<WrapperTransition> getWrapper_mapping() {
        return wrapper_mapping;
    }

    public void setWrapper_mapping(List<WrapperTransition> wrapper_mapping) {
        this.wrapper_mapping = wrapper_mapping;
    }
}
