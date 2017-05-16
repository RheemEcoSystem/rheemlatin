package org.qcri.rheem.latin.plan.operator.logical;

import org.qcri.rheem.latin.plan.operator.LatinOperator;

/**
 * Created by bertty on 06-04-17.
 */
public class SourceOperator extends LatinOperator {
    private String path_source = null;

    private String[] name_var;

    private String[] type_var;
    public SourceOperator(String name) {
        super(name);
    }

    public String getPath_source() {
        return path_source;
    }

    public void setPath_source(String path_source) {
        this.path_source = path_source;
    }

    public String[] getName_var() {
        return name_var;
    }

    public void setName_var(String[] name_var) {
        this.name_var = name_var;
    }

    public String[] getType_var() {
        return type_var;
    }

    public void setType_var(String[] type_var) {
        this.type_var = type_var;
    }

    public Object[] getParams(String[] params){
        Object[] obj = super.getParams(params);
        int class_count = 0;
        for(int i = 0; i < params.length; i++){
            if(params[i].equalsIgnoreCase("string")){
                obj[i] = this.path_source;
            }
            if(params[i].equalsIgnoreCase("string[]")){
               obj[i] = this.name_var;
            }
        }
        return obj;
    }
}
