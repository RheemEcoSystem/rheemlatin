package org.qcri.rheem.latin.parser.template.plan.operator;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;

public class ParserTemplateOperator extends LatinOperator {
    public ParserTemplateOperator(String name) {
        super(name);
    }

    public ParserTemplateOperator(LatinElement element) {
        super(element);
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }
}
