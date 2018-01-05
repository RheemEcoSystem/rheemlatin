package org.qcri.rheem.latin.core.plan.expression;

import org.qcri.rheem.latin.core.plan.LatinElement;

import java.util.List;

public abstract class LatinExpression extends LatinElement{

    protected String real_operator = null;
    protected String type          = null;


    public LatinExpression(String name) {
        super(name);
    }

    public LatinExpression(LatinExpression element) {
        super(element);
    }

    public String getReal_operator() {
        return real_operator;
    }

    public void setReal_operator(String real_operator) {
        this.real_operator = real_operator;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return "Expression: >"+ this.name +"<\n";
    }

    public abstract boolean hasChildren();

    public abstract boolean hasMoreChildren();

    public abstract LatinExpression nextChildren();

    public abstract void goFirstChildren();

    public abstract int countChildren();

    public boolean isImplemented(){
        return false;
    }

    /** is implemented for the element that can have function implemented */
    public Object getImplementation(){
        return getImplementation(null);
    }

    public Object getImplementation(List<String> broadcast_name){
        return null;
    }
}
