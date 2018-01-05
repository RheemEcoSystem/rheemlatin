package org.qcri.rheem.latin.optimizer.algebraic.plan.structure;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.structure.LatinStructure;

public class OptimizerAlgebraicStructure extends LatinStructure{
    public OptimizerAlgebraicStructure(String name) {
        super(name);
    }

    public OptimizerAlgebraicStructure(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }
}
