package org.qcri.rheem.latin.optimizer.plan.structure;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.structure.LatinStructure;

public class OptimizerTemplateStructure extends LatinStructure{
    public OptimizerTemplateStructure(String name) {
        super(name);
    }

    public OptimizerTemplateStructure(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }
}
