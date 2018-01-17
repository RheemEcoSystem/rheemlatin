package org.qcri.rheem.latin.translator.rheem.mapping.transition;

import org.qcri.rheem.latin.translator.rheem.exception.TranslatorRheemException;
import org.qcri.rheem.latin.translator.rheem.mapping.ParameterType;
import org.qcri.rheem.latin.translator.rheem.mapping.RheemClassMapping;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.*;

public class RheemContextTransition {

    private String package_rheem;
    private String extend_rheem;
    private List<RheemClassTransition> class_reflex;
    private Map<String, List<RheemClassTransition>> map_reflex;
    private List<RheemClassTransition> other_package;

    public String getPackage_rheem() {
        return package_rheem;
    }

    public void setPackage_rheem(String package_rheem) {
        this.package_rheem = package_rheem;
    }

    public String getExtend_rheem() {
        return extend_rheem;
    }

    public void setExtend_rheem(String extend_rheem) {
        this.extend_rheem = extend_rheem;
    }

    public List<RheemClassTransition> getClass_reflex() {
        return class_reflex;
    }

    public void setClass_reflex(List<RheemClassTransition> class_reflex) {
        this.class_reflex = class_reflex;
        this.map_reflex = new HashMap<>();
        this.other_package = new ArrayList<>();
        for(RheemClassTransition _tmp: this.class_reflex){
            List<RheemClassTransition> list_value = this.map_reflex.get(_tmp.getName_rheem());
            if( list_value == null ){
                list_value = new ArrayList();
                this.map_reflex.put(_tmp.getName_rheem(), list_value);
            }
            list_value.add(_tmp);

            if(_tmp.getPackage_name() != null){
                this.other_package.add(_tmp);
            }
        }
    }

    public List<RheemClassMapping> transform() {
        ArrayList<RheemClassMapping> rheemMappings = new ArrayList<>();
        try {

            Map<RheemClassTransition, Class> class_process = getPackageClass();

            for (Map.Entry<RheemClassTransition, Class> reg : class_process.entrySet()) {

                RheemClassTransition class_info = reg.getKey();
                Class class_obj = reg.getValue();

                ParameterType[] parameterTypes = class_info.parameterConvert();
                Class[] parametersClass = new Class[parameterTypes.length];
                for (int i = 0; i < parametersClass.length; i++) {
                    parametersClass[i] = parameterTypes[i].getType();
                }

                Constructor constructor = class_obj.getConstructor(parametersClass);

                rheemMappings.add(
                    new RheemClassMapping(
                            class_info.getName_latin(),
                            constructor,
                            class_obj,
                            parameterTypes
                    )
                );
            }

        } catch (NoSuchMethodException e) {
            throw new TranslatorRheemException(e);
        }

        return rheemMappings;
    }

    private Map<RheemClassTransition, Class> getPackageClass(){
        Reflections reflex = new Reflections(package_rheem);
        Map<RheemClassTransition, Class> map = new HashMap<>();
        try{
            Set<Class<?>> obj_extends = (Set<Class<?>>) reflex.getSubTypesOf( Class.forName(extend_rheem) );

            for(Class clazz: obj_extends){
                if(this.map_reflex.containsKey(clazz.getSimpleName())){
                    List<RheemClassTransition> values =  this.map_reflex.get(clazz.getSimpleName());
                    for(RheemClassTransition value: values){
                        map.put( value, clazz );
                    }
                }
            }

            for(RheemClassTransition _tmp: this.other_package){
                map.put(
                    _tmp,
                    Class.forName(
                        _tmp.getPackage_name()+"."+_tmp.getName_rheem()
                    )
                );
            }

        } catch (ClassNotFoundException e) {
            throw new TranslatorRheemException(e);
        }
        return map;
    }


}
