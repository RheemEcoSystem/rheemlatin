package org.qcri.rheem.latin.plan;

/**
 * Created by bertty on 06-04-17.
 */
public abstract class LatinElement {
    protected String name = null;

    protected LatinElement(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}
