package org.qcri.rheem.latin.parser.latin.mapping.transition;

import org.qcri.rheem.latin.parser.latin.context.LoadMockupClass;
import org.qcri.rheem.latin.parser.latin.context.ParserLatinContext;
import org.qcri.rheem.latin.parser.latin.exception.ParserLatinException;
import org.qcri.rheem.latin.parser.latin.mapping.MappingFinal;
import org.qcri.rheem.latin.parser.latin.mapping.OperatorMapping;
import org.qcri.rheem.latin.parser.latin.mapping.WrapperOperatorMapping;
import org.qcri.rheem.latin.parser.latin.mapping.enums.LambdaType;
import org.qcri.rheem.latin.parser.latin.mapping.enums.OperatorType;


import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WrapperTransition implements MappingTransform {

    private String name;
    private int nfunction;
    private String type;
    private List<WrapperTransitionFunction> functions;
    private List<String> alias_inputs;
    private List<String> alias_outputs;
    private List<WrapperTransitionOperator> operadores;


    @Override
    public MappingFinal transform() {
        LoadMockupClass operators_real = ParserLatinContext.getLoaderClass();
        Map<String, OperatorMapping> operatorMapping = new HashMap<>();
        Map<String, WrapperOperatorMapping.WrapperFunctionMapping> functionMapping = new HashMap<>();


        for(WrapperTransitionOperator wop: this.operadores){
            OperatorMapping mop = (OperatorMapping)  operators_real.getOperatorMapping(wop.getOperator_name()).clone();
            operatorMapping.put(wop.getOperator_alias(), mop);
            mop.setAlias(wop.getOperator_alias());
            mop.setFunction_alias(wop.getFunctions_alias());
            mop.setInputs_alias(wop.getInputs_alias());
        }

        for(WrapperTransitionFunction tmp_fun: this.functions){
            Class clazz = null;
            Method method = null;
            if(!tmp_fun.isUdf()) {
                try {
                    clazz = Class.forName(tmp_fun.getClass_name());
                    method = Arrays
                            .stream(clazz.getMethods())
                            .filter(
                                    method1 -> method1.getName().compareTo(tmp_fun.getMethod_name()) == 0
                            ).findFirst()
                            .orElse(null);
                } catch (ClassNotFoundException e) {
                    throw new ParserLatinException(e);
                }
            }

            WrapperOperatorMapping.WrapperFunctionMapping fun = new WrapperOperatorMapping.WrapperFunctionMapping(
                    tmp_fun.getFunction_name(),
                    LambdaType.find(tmp_fun.getLambda()),
                    clazz,
                    method,
                    tmp_fun.isUdf(),
                    tmp_fun.getPosition()
            );
            functionMapping.put(fun.getFunction_name(), fun);
        }

        return new WrapperOperatorMapping(
            this.name,
            this.alias_inputs.size(),
            this.alias_outputs.size(),
            OperatorType.WRAPPER,
            this.alias_inputs,
            this.alias_outputs,
            operatorMapping,
            functionMapping
        );
    }


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<WrapperTransitionFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(List<WrapperTransitionFunction> functions) {
        this.functions = functions;
    }

    public List<String> getAlias_inputs() {
        return alias_inputs;
    }

    public void setAlias_inputs(List<String> alias_inputs) {
        this.alias_inputs = alias_inputs;
    }

    public List<String> getAlias_outputs() {
        return alias_outputs;
    }

    public void setAlias_outputs(List<String> alias_outputs) {
        this.alias_outputs = alias_outputs;
    }

    public List<WrapperTransitionOperator> getOperadores() {
        return operadores;
    }

    public void setOperadores(List<WrapperTransitionOperator> operadores) {
        this.operadores = operadores;
    }

    @Override
    public String toString() {
        return "WrapperTransition{" +
                "name='" + name + '\'' +
                ", nfunction=" + nfunction +
                ", type='" + type + '\'' +
                ", functions=" + functions +
                ", alias_inputs=" + alias_inputs +
                ", alias_outputs=" + alias_outputs +
                ", operadores=" + operadores +
                '}';
    }
}

