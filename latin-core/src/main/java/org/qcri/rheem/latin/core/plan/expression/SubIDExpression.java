package org.qcri.rheem.latin.core.plan.expression;

import org.qcri.rheem.latin.core.plan.LatinElement;

public class SubIDExpression extends LatinExpression{

    private String value;

    public SubIDExpression(String name) {
        super(name);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }

    public SubIDExpression(String name, String value) {
        super(name);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean hasChildren() {
        return true;
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
        return 1;
    }


    //TODO: crear de forma generica para todas las opciones disponibles
    public String getReference(){
        return value.split("\\.")[0];
    }

    public String getComponente(){
        return value.split("\\.")[1];
    }
}
