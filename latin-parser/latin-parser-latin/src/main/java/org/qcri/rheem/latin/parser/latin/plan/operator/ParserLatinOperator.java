package org.qcri.rheem.latin.parser.latin.plan.operator;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;

public class ParserLatinOperator extends LatinOperator{
    public ParserLatinOperator(String name) {
        super(name);
    }

    public ParserLatinOperator(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }
}
