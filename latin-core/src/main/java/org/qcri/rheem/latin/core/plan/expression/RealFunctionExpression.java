package org.qcri.rheem.latin.core.plan.expression;

import org.qcri.rheem.latin.core.Exception.LatinCoreException;
import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.enviroment.ClassEnviroment;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.qcri.rheem.latin.udf.broadcast.FunctionBroadcast;

public class RealFunctionExpression extends LatinExpression{

    private ClassEnviroment class_reference;
    private String name_method;

    private Class type_return;



    public RealFunctionExpression(String name) {
        super(name);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }

    public  RealFunctionExpression(String name, ClassEnviroment class_reference, String name_method ){
        this(name);
        this.class_reference = class_reference;
        validate(class_reference, name_method);
        this.name_method = name_method;
    }

    //TODO generate the get of the method with reflextion MOVER AL TRANSLATOR;
    /*
    public Object getImplementation(String broadcast_name){
        if(broadcast_name == null)
            return class_reference.getMethod(this.name_method);

        return new UDFunctionBroadcast(broadcast_name, (FunctionBroadcast) class_reference.getMethod(this.name_method));
    }*/

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public boolean hasMoreChildren() {
        return false;
    }

    @Override
    public LatinExpression nextChildren() {
        return null;
    }

    @Override
    public void goFirstChildren() {
        return;
    }

    @Override
    public int countChildren() {
        return 0;
    }

    @Override
    public boolean isImplemented(){
        return true;
    }

    //TODO: mejorar la forma en la que se implemento
    private void validate(ClassEnviroment class_reference, String method_name){
        if( ! class_reference.existMethod(method_name) ){
            throw new LatinCoreException(
                String.format(
                    "The method %s not exist in the class %s in the path %s",
                    method_name,
                    class_reference.getName(),
                    class_reference.getPath()
                )
            );
        }
        Method method = class_reference.getRealMethod(method_name);

        Type type = method.getGenericReturnType();

        Class returnClass = method.getReturnType();

        if(type.getClass() == Class.class){
            this.type_return = returnClass;
            return;
        }

        if(! (type instanceof ParameterizedType) ){
            throw new LatinCoreException(
                String.format(
                    "the return of your method %s is not posible that process",
                    method_name
                )
            );
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;

        int position = -1;
        if( Function.class.isAssignableFrom( returnClass ) ){
            position = 1;
        }else if( Predicate.class.isAssignableFrom(returnClass ) ){
            position = 0;
        }else if( BiFunction.class.isAssignableFrom(returnClass ) ){
            position = 2;
        }else if( Consumer.class.isAssignableFrom( returnClass) ){
            position = 0;
        }else if( FunctionBroadcast.class.isAssignableFrom(returnClass)){
            position = 1;
        }

        if(position == -1){
            throw new LatinCoreException(
                String.format(
                    "the return of your method %s is not posible that process, becouse is not lambda expression",
                    method_name
                )
            );
        }


        this.type_return = (Class) parameterizedType.getActualTypeArguments()[position];

    }

    public ClassEnviroment getClass_reference() {
        return class_reference;
    }

    public String getName_method() {
        return name_method;
    }

    public Class getType_return() {
        return type_return;
    }
}
