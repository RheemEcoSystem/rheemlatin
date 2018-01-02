package org.qcri.rheem.latin.plan.addons.enviroment;

import org.qcri.rheem.latin.plan.addons.enviroment.LatinEnviroment;
import org.qcri.rheem.latin.reflexion.ReflexImportClass;
import org.qcri.rheem.latin.util.LatinException;

import java.net.URI;

public class LatinImportClass extends LatinEnviroment {

    private static ReflexImportClass IMPORTS;
    static {
        IMPORTS = new ReflexImportClass();
    }

    private URI path;
    private String[] methods;


    public  LatinImportClass(String name) {
        super(name);
    }

    public LatinImportClass(String name, String path){
        this(name, URI.create(path));
    }

    public LatinImportClass(String name, URI path){
        this(name);
        this.path = path;
        validate();
        importMethods();
    }

    @Override
    public boolean validate() throws LatinException {
        return IMPORTS.loadClass(this.name, this.path);
    }

    private void importMethods(){
        this.methods = IMPORTS.getMethods(this.name);
    }

    public boolean existMethod(String method_name){
        for(int i = 0; i < this.methods.length; i++){
            if(method_name.compareTo(this.methods[i]) == 0){
                return true;
            }
        }
        return false;
    }

    public Object getMethod(String method_name){
        return IMPORTS.getLambda(this.name, method_name);
    }

}
