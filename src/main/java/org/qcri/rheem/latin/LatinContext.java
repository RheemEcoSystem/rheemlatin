package org.qcri.rheem.latin;


import org.qcri.rheem.latin.reflexion.ReflexBuilder;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * Created by bertty on 06-04-17.
 */
public class LatinContext {
    private static final String     path_prop  = "latin.configuration";
    private static       Properties properties = null;


    private static URI conf_operator = null;
    private static URI conf_mapping  = null;

    public static void loadContext() throws Exception {
        System.err.println("Loading Context");
        properties = new Properties();
        System.out.println(System.getProperty("latin.configuration"));


        InputStream inputstream = new FileInputStream(createURI(System.getProperty("latin.configuration")).getPath());
    //    InputStream inputstream = LatinContext.class.getClassLoader().getResourceAsStream("latin.configuration");

        if( inputstream == null ){
            throw new Exception("Problem with file of the properties");
        }

        properties.load(inputstream);

        System.out.println(properties);


        conf_operator = createURI(properties.getProperty("latin.conf.operator"));
        conf_mapping  = createURI(properties.getProperty("latin.conf.mapping"));


        ReflexBuilder.loadReflex();

        System.err.println("Context loaded");

    }

    public static URI createURI(String resourcePath){
        try{
            return new URI(resourcePath);
        }catch(URISyntaxException e){
            throw new IllegalArgumentException("Ilegal Uri"+e);
        }
    }

    public static URI getConf_mapping() {
        return conf_mapping;
    }

    public static void setConf_mapping(URI conf_mapping) {
        conf_mapping = conf_mapping;
    }

    public static URI getConf_operator() {
        return conf_operator;
    }

    public static void setConf_operator(URI conf_operator) {
        conf_operator = conf_operator;
    }
}
