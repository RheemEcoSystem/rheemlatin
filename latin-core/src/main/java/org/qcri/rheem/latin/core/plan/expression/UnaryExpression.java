package org.qcri.rheem.latin.core.plan.expression;

import org.qcri.rheem.latin.core.plan.LatinElement;

public class UnaryExpression extends LatinExpression{

    private LatinExpression branch = null;



    public UnaryExpression(String name) {
        super(name);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }

    public UnaryExpression(String name, LatinExpression expr){
        super(name);
        this.branch = expr;
    }

    public LatinExpression getBranch() {
        return branch;
    }

    public void setBranch(LatinExpression branch) {
        this.branch = branch;
    }

    @Override
    public boolean hasChildren() {
        return this.branch != null;
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

}
