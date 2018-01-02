package org.qcri.rheem.latin.plan.operator.expression;

import org.qcri.rheem.latin.plan.addons.enviroment.LatinImportClass;
import org.qcri.rheem.latin.plan.operator.LatinExpression;
import org.qcri.rheem.latin.util.LatinException;

public class RealFunctionExpression extends LatinExpression {


    private LatinImportClass class_reference;
    private String name_method;

    private String type_return;



    public RealFunctionExpression(String name) {
        super(name);
    }

    public  RealFunctionExpression(String name, LatinImportClass class_reference, String name_method ){
        this(name);
        this.class_reference = class_reference;
        validate(class_reference, name_method);
        this.name_method = name_method;

    }

    //TODO generate the get of the method with reflextion;
    public Object getImplementation(){
        return class_reference.getMethod(this.name_method);
    }

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

    private void validate(LatinImportClass class_reference, String method_name){
        if( ! class_reference.existMethod(method_name) ){
            //TODO: create a good message for the exection
            throw new LatinException("method not exits");
        }
    }

}
