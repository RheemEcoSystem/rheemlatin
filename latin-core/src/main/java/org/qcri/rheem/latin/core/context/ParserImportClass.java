package org.qcri.rheem.latin.core.context;

import org.qcri.rheem.latin.core.exception.LatinCoreException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ParserImportClass extends ClassLoader{
    private static Map<String, Class> imports = new HashMap<>();

    public ParserImportClass(){
        this(ParserImportClass.class.getClassLoader());
    }

    public ParserImportClass(ClassLoader parent) {
        super(parent);
    }

    public boolean loadClass(String alias, URI path){
        if(imports.containsKey(alias)){
            return true;
        }
        try {
            Class clazz = _loadClass(alias, path);
            imports.put(alias, clazz);
            return true;
        }catch (ClassNotFoundException e){
            throw new LatinCoreException(e);
        }finally {
            return false;
        }
    }

    public boolean loadClass(String alias, Class clazz){
        if(imports.containsKey(alias)){
            return true;
        }
        imports.put(alias, clazz);
        return true;
    }

    private Class _loadClass(String name, URI path) throws ClassNotFoundException {
        try {
            URL myUrl = new URL(path.toString());
            URLConnection connection = myUrl.openConnection();
            InputStream input = connection.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();

            while(data != -1){
                buffer.write(data);
                data = input.read();
            }

            input.close();

            byte[] classData = buffer.toByteArray();
            return defineClass(null, classData, 0, classData.length);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] getMethods(String alias){
        Class clazz = valid(alias);

        return methodCanUse(clazz).map(
                element -> {
                    return element.getName();
                }
        ).toArray(String[]::new);
    }

    public Method getMethod(String alias, String name_method){
        Class clazz = valid(alias);

        return methodCanUse(clazz).filter(
                element -> {
                    return name_method.compareToIgnoreCase(element.getName()) == 0;
                }

        ).findFirst().orElse(null);

    }

    private Class valid(String alias){
        if(! imports.containsKey(alias)){
            //TODO create a great message for this exception;
            throw new LatinCoreException("get Method is imposible that execute");
        }
        return imports.get(alias);
    }

    private Stream<Method> methodCanUse(Class clazz){
        Method[] methods = clazz.getDeclaredMethods();
        return Arrays.stream(methods).filter(
                element -> {
                    return ( !element.isSynthetic() ) && Modifier.isPublic(element.getModifiers());
                }
        );
    }

    public Object getLambda(String class_name, String method_name, Object[] parameters){
        Method method = getMethod(class_name, method_name);

        try {
            if(parameters == null){
                return method.invoke(null);
            }
            return method.invoke(null, parameters);
        } catch (IllegalAccessException |InvocationTargetException e) {
            System.err.println(e.getCause());
            throw new LatinCoreException(e);
        }
    }

}
