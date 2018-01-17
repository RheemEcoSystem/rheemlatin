package org.qcri.rheem.latin.parser.latin.mapping;

import org.qcri.rheem.latin.parser.latin.exception.ParserLatinException;
import org.qcri.rheem.latin.parser.latin.mapping.enums.LambdaType;
import org.qcri.rheem.latin.parser.latin.mapping.enums.OperatorType;

import java.util.ArrayList;
import java.util.List;

public class OperatorMapping implements MappingFinal {

    private String name;
    private int nfunction;
    private OperatorType type;
    private LambdaType lambda;
    private Class output;
    private String alias;
    private List<String> function_alias;
    private List<String> inputs_alias;

    public OperatorMapping(String name, int nfunction, OperatorType type, LambdaType lambda, Class output) {
        this.name = name;
        this.nfunction = nfunction;
        this.type = type;
        this.lambda = lambda;
        this.output = output;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNfunction() {
        return nfunction;
    }

    public void setNfunction(int nfunction) {
        this.nfunction = nfunction;
    }

    public OperatorType getType() {
        return type;
    }

    public void setType(OperatorType type) {
        this.type = type;
    }

    public LambdaType getLambda() {
        return lambda;
    }

    public void setLambda(LambdaType lambda) {
        this.lambda = lambda;
    }

    public Class getOutput() {
        return output;
    }

    public void setOutput(Class output) {
        this.output = output;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<String> getFunction_alias() {
        return function_alias;
    }

    public void setFunction_alias(List<String> function_alias) {
        this.function_alias = function_alias;
    }

    public void addFunction_alias(String function_alias){
        if(this.function_alias == null){
            this.function_alias = new ArrayList<>();
        }
        this.function_alias.add(function_alias);
    }

    public List<String> getInputs_alias() {
        return inputs_alias;
    }

    public void setInputs_alias(List<String> inputs_alias) {
        this.inputs_alias = inputs_alias;
    }

    public void addInputs_alias(String input_alias){
        if(this.inputs_alias == null){
            this.inputs_alias = new ArrayList<>();
        }
        this.inputs_alias.add(input_alias);
    }

    @Override
    public Object clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            throw new ParserLatinException(e);
        }
        return new OperatorMapping(this.name, this.nfunction, this.type, this.lambda, this.output);
    }

    @Override
    public String toString() {
        return "OperatorMapping{" +
                "name='" + name + '\'' +
                ", nfunction=" + nfunction +
                ", type=" + type +
                ", lambda=" + lambda +
                ", output=" + output +
                ", alias='" + alias + '\'' +
                ", function_alias=" + function_alias +
                ", inputs_alias=" + inputs_alias +
                '}';
    }
}

