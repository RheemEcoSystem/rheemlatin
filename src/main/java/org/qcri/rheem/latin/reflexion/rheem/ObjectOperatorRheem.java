package org.qcri.rheem.latin.reflexion.rheem;

import org.qcri.rheem.core.plan.rheemplan.Operator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bertty on 13-04-17.
 */
public class ObjectOperatorRheem {


    private static Map<String, Class> lambdas = null;

    public static void load(){
        try {
            lambdas = new HashMap<String, Class>();
            lambdas.put("predicate", Class.forName("org.qcri.rheem.core.function.FunctionDescriptor$SerializablePredicate"));
            lambdas.put("function", Class.forName("org.qcri.rheem.core.function.FunctionDescriptor$SerializableFunction"));
            lambdas.put("class", Class.class);
            lambdas.put("string", String.class);
            lambdas.put("string[]", String[].class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String name = null;
    private Class  baseRheem = null;
    private Constructor constructor = null;
    private String[]    parameters = null;

    public ObjectOperatorRheem(String name, Class classRheem) {
        this.name = name;
        this.baseRheem = classRheem;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(String ... params) throws NoSuchMethodException {
        Class[] paramsConvert = new Class[params.length];

        for( int i = 0; i < params.length; i++ ){
            paramsConvert[i] = lambdas.get(params[i]);
        }
        this.parameters  = params;
        this.constructor = baseRheem.getConstructor(paramsConvert);
    }

    public Operator newIntance(Object ... params) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Operator) this.constructor.newInstance(params);
    }

    public String[] getParameters(){
        return this.parameters;
    }

    public void printMethod(){
        System.out.println(this.constructor.getName());
        Parameter[] params = this.constructor.getParameters();
        for(int i =0; i < this.constructor.getParameterCount(); i++){
            System.out.println("   "+params[i].getType()+"  "+params[i].getName());
        }

    }
}
