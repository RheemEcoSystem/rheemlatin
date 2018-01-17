package org.qcri.rheem.latin.translator.template.plan.operator;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;

public class TranslatorTemplateOperator extends LatinOperator{
    public TranslatorTemplateOperator(String name) {
        super(name);
    }

    public TranslatorTemplateOperator(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }
}
