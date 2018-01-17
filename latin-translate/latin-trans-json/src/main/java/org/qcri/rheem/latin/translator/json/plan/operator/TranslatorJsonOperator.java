package org.qcri.rheem.latin.translator.json.plan.operator;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;

public class TranslatorJsonOperator extends LatinOperator{
    public TranslatorJsonOperator(String name) {
        super(name);
    }

    public TranslatorJsonOperator(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }
}
