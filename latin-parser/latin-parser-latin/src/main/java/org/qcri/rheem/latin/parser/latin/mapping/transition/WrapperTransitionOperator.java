package org.qcri.rheem.latin.parser.latin.mapping.transition;

import org.qcri.rheem.latin.parser.latin.mapping.MappingFinal;

import java.util.List;

public class WrapperTransitionOperator implements MappingTransform {

    private String operator_name;
    private String operator_alias;
    private List<String> inputs_alias;
    private List<String> functions_alias;

    @Override
    public MappingFinal transform() {
        return null;
    }



    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }

    public String getOperator_alias() {
        return operator_alias;
    }

    public void setOperator_alias(String operator_alias) {
        this.operator_alias = operator_alias;
    }

    public List<String> getInputs_alias() {
        return inputs_alias;
    }

    public void setInputs_alias(List<String> inputs_alias) {
        this.inputs_alias = inputs_alias;
    }

    public List<String> getFunctions_alias() {
        return functions_alias;
    }

    public void setFunctions_alias(List<String> functions_alias) {
        this.functions_alias = functions_alias;
    }

    @Override
    public String toString() {
        return "WrapperTransitionOperator{" +
                "operator_name='" + operator_name + '\'' +
                ", operator_alias='" + operator_alias + '\'' +
                ", inputs_alias=" + inputs_alias +
                ", functions_alias=" + functions_alias +
                '}';
    }
}
