package org.qcri.rheem.latin.optimizer.plan.operator;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;

public class OptimizerTemplateOperator extends LatinOperator{
    public OptimizerTemplateOperator(String name) {
        super(name);
    }

    public OptimizerTemplateOperator(LatinElement element) {
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
