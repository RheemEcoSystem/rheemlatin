package org.qcri.rheem.latin.parser.latin.mapping;


import org.qcri.rheem.latin.parser.latin.mapping.enums.FunctionType;

import java.lang.reflect.Method;
import java.util.List;

public class FunctionMapping implements MappingFinal {
    private String name;
    private FunctionType type;
    private Class type_return;
    private Class class_name;
    private Method method;
    private int nparam;
    private Class[] parameters;

    public FunctionMapping(String name, FunctionType type, Class type_return, Class class_name, Method method, int nparam, Class[] parameters) {
        this.name = name;
        this.type = type;
        this.type_return = type_return;
        this.class_name = class_name;
        this.method = method;
        this.nparam = nparam;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public FunctionType getType() {
        return type;
    }

    public Class getType_return() {
        return type_return;
    }

    public Class getClass_name() {
        return class_name;
    }

    public Method getMethod() {
        return method;
    }

    public int getNparam() {
        return nparam;
    }

    public Class[] getParameters() {
        return parameters;
    }

    @Override
    public Object clone() {
        return new FunctionMapping(
            this.name,
            this.type,
            this.type_return,
            this.class_name,
            this.method,
            this.nparam,
            this.parameters
        );
    }
}