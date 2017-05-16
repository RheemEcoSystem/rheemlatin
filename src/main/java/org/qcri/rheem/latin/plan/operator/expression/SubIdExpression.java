package org.qcri.rheem.latin.plan.operator.expression;

import org.qcri.rheem.latin.plan.operator.LatinExpression;

/**
 * Created by bertty on 24-04-17.
 */
public class SubIdExpression extends LatinExpression{

    private String value;

    public SubIdExpression(String name) {
        super(name);
    }

    public SubIdExpression(String name, String value) {
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
}
