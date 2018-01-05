package org.qcri.rheem.latin.parser.latin.plan.enviroment;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.enviroment.ClassEnviroment;
import org.qcri.rheem.latin.core.context.ParserImportClass;
import org.qcri.rheem.latin.parser.latin.context.ParserLatinContext;
import org.qcri.rheem.latin.parser.latin.exception.ParserLatinException;

import java.net.URI;

public class ParserLatinClassEnviroment extends ClassEnviroment {

    static ParserImportClass IMPORTS;
    static {
        IMPORTS = ParserLatinContext.getImportClass();
    }

    public ParserLatinClassEnviroment(String name, String path) {
        this(name, URI.create(path));
    }

    public ParserLatinClassEnviroment(String name, URI path) {
        super(name, path);
    }

    @Override
    public boolean validate() {
        return IMPORTS.loadClass(this.name, this.path);
    }
    @Override
    protected void importMethods(){
        this.methods = IMPORTS.getMethods(this.name);
    }

    @Override
    public boolean existMethod(String method_name){
        for(int i = 0; i < this.methods.length; i++){
            if(method_name.compareTo(this.methods[i]) == 0){
                return true;
            }
        }
        return false;
    }
    @Override
    public Object getMethod(String method_name){
        return null;
    }

    @Override
    protected void selfCopy(LatinElement element) {
        if( !(element instanceof ClassEnviroment)){
            throw new ParserLatinException(
                String.format(
                    "the class \"%s\" of the [%s]is not extension of the %s",
                    element.getClass(),
                    element,
                    ClassEnviroment.class
                )
            );
        }
        ClassEnviroment enviroment = (ClassEnviroment) element;
        this.path = enviroment.getPath();
        this.name = enviroment.getName();
        importMethods();
        enviroment.setMethods(this.methods);
        this.path_str = enviroment.getPath_str();
    }

}
