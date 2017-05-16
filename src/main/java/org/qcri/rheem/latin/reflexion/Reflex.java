package org.qcri.rheem.latin.reflexion;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by bertty on 06-04-17.
 */
public class Reflex {

    private String name = null;

    private String namePackage = null;

    private String nameClass   = null;

    private Reflections reflections = null;

    private Map<String, ObjectConf> objects = null;

    public Reflex(String name, String namePackage, String nameClass){
        this.name        = name;
        this.namePackage = namePackage;
        this.nameClass   = nameClass;
        this.objects     = new HashMap<String, ObjectConf>();
    }

    public void addObject(String name, ObjectConf obj){
        objects.put(name, obj);
    }

    public Set getKeys(){
        return objects.keySet();
    }

    public ObjectConf getObject(String key){
        return objects.get(key);
    }


}
