package org.qcri.rheem.latin.reflexion;

/**
 * Created by bertty on 09-04-17.
 */
public class ObjectOperator implements ObjectConf {

    private String name      = null;

    private String type      = null;

    private int    nfunction = 0;

    private Class  output    = null;

    private ParametersTypes lamdba = null;


    public ObjectOperator(){}

    public ObjectOperator(String name, String type, int nfunction) {
        this.name = name;
        this.type = type;
        this.nfunction = nfunction;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public int getNfunction() {
        return this.nfunction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNfunction(int nfunction) {
        this.nfunction = nfunction;
    }

    public Class getOutput() {
        return output;
    }

    public void setOutput(String output) {
        try {
            this.output = Class.forName(output);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(-103);
        }
    }

    public void setLamdba(String name){
        this.lamdba = ReflexBuilder.getLambdaName(name);
    }

    public ParametersTypes getLamdba(){
        return this.lamdba;
    }
}
