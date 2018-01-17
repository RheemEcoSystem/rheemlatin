package org.qcri.rheem.latin.core.context;

import org.qcri.rheem.latin.core.exception.LatinCoreException;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public abstract class LatinContext {
    protected static Map<String, Object> configuration;

    static{
        configuration = new HashMap<>();
    }

    protected URI location_configuration;

    public LatinContext(URI location_configuration){
        this.location_configuration = location_configuration;
        this.initVariables();
    }

    protected abstract void initVariables();

    public abstract void loadContext();

    public static void putConfiguration(String key, Object value){
        configuration.put(key, value);
    }

    public static Object getConfiguration(String key){
        if(! configuration.containsKey(key)){
            //TODO create a good message
            throw new LatinCoreException(
                    String.format( "Not exist \"%s\"  in the configuration of %s", key, LatinContext.class )
            );
        }
        return configuration.get(key);
    }

}
