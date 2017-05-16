package org.qcri.rheem.latin.reflexion.rheem;

import org.qcri.rheem.core.plan.rheemplan.Operator;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by bertty on 12-04-17.
 */
public class ReflexRheem {

    private String name = null;

    private String namePackage = null;

    private String nameClass   = null;

    private Map<String, ObjectOperatorRheem> objects = null;

    public ReflexRheem(String name, String namePackage, String nameClass){
        this.name        = name;
        this.namePackage = namePackage;
        this.nameClass   = nameClass;
        this.objects     = new HashMap<>();
    }

    public int size() {
        return this.objects.size();
    }

    public boolean containsKey(String key) {
        return this.objects.containsKey(key);
    }

    public boolean containsValue(ObjectOperatorRheem value) {
        return this.objects.containsValue(value);
    }

    public ObjectOperatorRheem get(String key) {
        return this.objects.get(key);
    }

    public ObjectOperatorRheem put(String key, ObjectOperatorRheem value) {
        return this.objects.put(key, value);
    }

    public Set<Map.Entry<String, ObjectOperatorRheem>> entrySet() {
        return this.objects.entrySet();
    }

    public Operator createOperator(String name, Object ... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Operator) this.objects.get(name).newIntance(params);
    }

    public String[] getParameters(String name){
        return this.objects.get(name).getParameters();
    }


}
