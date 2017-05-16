package org.qcri.rheem.latin.plan.operator.expression;

import org.qcri.rheem.latin.plan.operator.LatinExpression;

/**
 * Created by bertty on 06-04-17.
 */
public class ConstantExpression<Type> extends LatinExpression {

    private Type value = null;

    private Class _class = null;
    public ConstantExpression(String name) {
        super(name);
    }

    public  ConstantExpression(String name, Type value){
        super(name);
        this.value = value;
        this._class = value.getClass();
    }

    public Type getValue() {
        return value;
    }

    public Class get_class() {
        return _class;
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
        return;
    }

    @Override
    public int countChildren() {
        return 0;
    }
}
