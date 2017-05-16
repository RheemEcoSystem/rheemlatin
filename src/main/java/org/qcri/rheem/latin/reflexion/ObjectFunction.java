package org.qcri.rheem.latin.reflexion;

import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.Method;

/**
 * Created by bertty on 09-04-17.
 */
public class ObjectFunction implements ObjectConf {
    private String  package_function = null;
    private Class   class_function = null;
    private String  name = null;
    private Class   type_return = null;
    private Method  method = null;
    private int     nparam  = 0;
    private Class[] paramters = null;

    private String  type = null;



    public ObjectFunction(){}

    public String getPackage_function() {
        return package_function;
    }

    public void setPackage_function(String package_function) {
        this.package_function = package_function;
    }

    public Class getClass_function() {
        return class_function;
    }

    public void setClass_function(String class_function) throws ClassNotFoundException {
        this.class_function = ClassUtils.getClass(class_function);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getType_return() {
        return type_return;
    }

    public void setType_return(String type_return) throws ClassNotFoundException {
        this.type_return = ClassUtils.getClass(type_return);
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(String name_method) throws NoSuchMethodException {
        this.method = this.class_function.getMethod(name_method, this.getParamters());
    }

    public int getNparam() {
        return nparam;
    }

    public void setNparam(int nparam) {
        this.nparam = nparam;
    }

    public Class[] getParamters() {
        return paramters;
    }

    public void setParamters(Class[] paramters) {
        this.paramters = paramters;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
