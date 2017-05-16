package org.qcri.rheem.latin.plan.operator;

/**
 * Created by bertty on 06-04-17.
 */
public abstract class LatinExpression extends LatinElement {

    protected String real_operator = null;

    protected String type          = null;

    protected LatinExpression(String name) {
        super(name);
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
}
