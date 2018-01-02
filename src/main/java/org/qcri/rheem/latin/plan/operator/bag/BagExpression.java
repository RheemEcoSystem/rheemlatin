package org.qcri.rheem.latin.plan.operator.bag;

import org.qcri.rheem.latin.plan.operator.LatinExpression;

public class BagExpression extends LatinExpression{



    protected BagExpression(String name) {
        super(name);
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

    }

    @Override
    public int countChildren() {
        return 0;
    }

    @Override
    public boolean isImplemented(){
        return true;
    }


}
