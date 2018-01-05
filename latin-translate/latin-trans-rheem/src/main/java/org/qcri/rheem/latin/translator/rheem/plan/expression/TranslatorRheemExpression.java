package org.qcri.rheem.latin.translator.rheem.plan.expression;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.expression.LatinExpression;

public class TranslatorRheemExpression extends LatinExpression{
    public TranslatorRheemExpression(String name) {
        super(name);
    }

    public TranslatorRheemExpression(LatinExpression element) {
        super(element);
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
    protected void selfCopy(LatinElement element) {

    }
}
