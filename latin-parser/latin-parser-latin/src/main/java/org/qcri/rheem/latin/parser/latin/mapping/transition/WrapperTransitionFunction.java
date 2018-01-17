package org.qcri.rheem.latin.parser.latin.mapping.transition;

import org.qcri.rheem.latin.parser.latin.mapping.MappingFinal;

public class WrapperTransitionFunction implements MappingTransform {

    private String function_name;
    private String class_name;
    private String method_name;
    private String lambda;
    private int position;
    private boolean udf;

    @Override
    public MappingFinal transform() {
        return null;
    }

    public String getFunction_name() {
        return function_name;
    }

    public void setFunction_name(String function_name) {
        this.function_name = function_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getMethod_name() {
        return method_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }

    public String getLambda() {
        return lambda;
    }

    public void setLambda(String lambda) {
        this.lambda = lambda;
    }

    public boolean isUdf() {
        return udf;
    }

    public void setUdf(boolean UDF) {
        this.udf = UDF;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "WrapperTransitionFunction{" +
                "function_name='" + function_name + '\'' +
                ", class_name='" + class_name + '\'' +
                ", method_name='" + method_name + '\'' +
                ", lambda='" + lambda + '\'' +
                ", position=" + position +
                ", udf=" + udf +
                '}';
    }
}
