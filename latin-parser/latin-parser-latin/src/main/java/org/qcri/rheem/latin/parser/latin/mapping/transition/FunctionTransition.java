package org.qcri.rheem.latin.parser.latin.mapping.transition;

import org.qcri.rheem.latin.parser.latin.exception.ParserLatinException;
import org.qcri.rheem.latin.parser.latin.mapping.FunctionMapping;
import org.qcri.rheem.latin.parser.latin.mapping.MappingFinal;
import org.qcri.rheem.latin.parser.latin.mapping.enums.FunctionType;

import java.lang.reflect.Method;
import java.util.List;

public class FunctionTransition implements MappingTransform{

    private String name;
    private String type;
    private String type_return;
    private String class_name;
    private int nparam;
    private List<String> parameters;
    private String method;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType_return() {
        return type_return;
    }

    public void setType_return(String type_return) {
        this.type_return = type_return;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getNparam() {
        return nparam;
    }

    public void setNparam(int nparam) {
        this.nparam = nparam;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public MappingFinal transform() {
        try {
            //TODO: terminar
            Class clazz = Class.forName(this.class_name);
            Class[] parameters_real = new Class[this.parameters.size()];
            for(int i = 0; i < parameters_real.length; i++){
                parameters_real[i] = Class.forName(this.parameters.get(i));
            }
            Method method_real = clazz.getMethod(this.method, parameters_real);

            return new FunctionMapping(
                    this.name,
                    FunctionType.find(this.type),
                    Class.forName(this.type_return),
                    clazz,
                    method_real,
                    this.nparam,
                    parameters_real
            );
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new ParserLatinException(e);
        }
    }
}
