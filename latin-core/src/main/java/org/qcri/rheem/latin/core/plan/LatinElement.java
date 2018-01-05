package org.qcri.rheem.latin.core.plan;

public abstract class LatinElement {
    protected String name;

    public LatinElement(String name){
        this.name = name;
    }

    public LatinElement(LatinElement element){
        selfCopy(element);
    }

    protected abstract void selfCopy(LatinElement element);

    public String getName(){
        return this.name;
    }
}
