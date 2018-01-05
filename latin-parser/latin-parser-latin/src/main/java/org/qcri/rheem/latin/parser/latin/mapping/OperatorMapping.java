package org.qcri.rheem.latin.parser.latin.mapping;

import org.qcri.rheem.latin.parser.latin.mapping.enums.LambdaType;
import org.qcri.rheem.latin.parser.latin.mapping.enums.OperatorType;

public class OperatorMapping implements MappingFinal {

    private String name;
    private int nfunction;
    private OperatorType type;
    private LambdaType lambda;
    private Class output;

    public OperatorMapping(String name, int nfunction, OperatorType type, LambdaType lambda, Class output) {
        this.name = name;
        this.nfunction = nfunction;
        this.type = type;
        this.lambda = lambda;
        this.output = output;
    }

    public String getName() {
        return name;
    }

    public int getNfunction() {
        return nfunction;
    }

    public OperatorType getType() {
        return type;
    }

    public LambdaType getLambda() {
        return lambda;
    }

    public Class getOutput() {
        return output;
    }
}
