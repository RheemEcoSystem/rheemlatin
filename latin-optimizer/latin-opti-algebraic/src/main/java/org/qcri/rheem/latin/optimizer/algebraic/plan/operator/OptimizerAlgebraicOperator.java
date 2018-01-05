package org.qcri.rheem.latin.optimizer.algebraic.plan.operator;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;

public class OptimizerAlgebraicOperator extends LatinOperator{
    public OptimizerAlgebraicOperator(String name) {
        super(name);
    }

    public OptimizerAlgebraicOperator(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }
}
