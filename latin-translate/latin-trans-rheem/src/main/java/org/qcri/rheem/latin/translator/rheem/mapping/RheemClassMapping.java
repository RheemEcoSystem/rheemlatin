package org.qcri.rheem.latin.translator.rheem.mapping;

import org.qcri.rheem.core.plan.rheemplan.Operator;
import org.qcri.rheem.latin.translator.rheem.exception.TranslatorRheemException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class RheemClassMapping {

    private String latinOperator;

    private Constructor constructor;

    private Class rheemClass;

    private ParameterType[] parameterTypes;

    public RheemClassMapping(String latinOperator, Constructor constructor, Class rheemClass, ParameterType[] parameterTypes) {
        this.latinOperator = latinOperator;
        this.constructor = constructor;
        this.rheemClass = rheemClass;
        this.parameterTypes = parameterTypes;
    }

    public String getLatinOperator() {
        return latinOperator;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public Class getRheemClass() {
        return rheemClass;
    }

    public ParameterType[] getParameterTypes() {
        return parameterTypes;
    }

    public Operator getRheemOperator(Object[] params){
        try {
            return (Operator) this.constructor.newInstance(params);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new TranslatorRheemException(e);
        }
    }

    @Override
    public String toString() {
        return "RheemClassMapping{" +
                "latinOperator='" + latinOperator + '\'' +
                ", constructor=" + constructor +
                ", rheemClass=" + rheemClass +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                '}';
    }
}
