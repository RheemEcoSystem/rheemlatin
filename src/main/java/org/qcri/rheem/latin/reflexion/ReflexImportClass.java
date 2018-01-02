package org.qcri.rheem.latin.reflexion;

import org.qcri.rheem.latin.util.LatinException;

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
import java.util.function.Function;
import java.util.stream.Stream;

public class ReflexImportClass extends ClassLoader{

    private static Map<String, Class> imports = new HashMap<>();

    //TODO: remove this method becoause is for test?
    public static  void main(String ... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ReflexImportClass _import = new ReflexImportClass();

        _import.loadClass("lala", URI.create("file:///Users/bertty/Qatar/external/target/classes/org/qcri/external/MyImport.class"));

        Class lala = imports.get("lala");


        System.out.println( "Name: "+lala.getName() );
        System.out.println( "SimpleName: "+lala.getSimpleName() );
        /*Method[] methods = lala.getDeclaredMethods();
        for(int i = 0; i < methods.length; i++){
            System.out.println( "method("+i+") "+methods[i].getName());
            System.out.println( "method("+i+") "+methods[i].isSynthetic());
        }*/
        String[] methods = _import.getMethods("lala");
        for(int i = 0; i < methods.length; i++) {
            System.out.println("method("+i+") "+methods[i]);
        }

        _import.getMethod("lala", "print").invoke(null);
        Function fun = (Function) lala.getMethod("getConvert").invoke(null);
        System.out.println( fun.apply("1") );
    }


    public ReflexImportClass(){
        this(ReflexImportClass.class.getClassLoader());
    }

    public ReflexImportClass(ClassLoader parent) {
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
            throw new LatinException(e);
        }finally {
            return false;
        }
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
                System.out.println(element.getName()+"  "+name_method);
                return name_method.compareToIgnoreCase(element.getName()) == 0;
            }

        ).findFirst().orElse(null);

    }

    private Class valid(String alias){
        if(! imports.containsKey(alias)){
            //TODO create a great message for this exception;
            throw new LatinException("get Method is imposible that execute");
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

    public Object getLambda(String class_name, String method_name){
        Method method = getMethod(class_name, method_name);
        try {
            return method.invoke(null);
        } catch (IllegalAccessException e) {
            throw new LatinException(e);
        } catch (InvocationTargetException e) {
            throw new LatinException(e);
        }
    }
}
