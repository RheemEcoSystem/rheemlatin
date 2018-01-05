package org.qcri.rheem.latin.optimizer.algebraic.plan.enviroment;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.enviroment.LatinEnviroment;

public class OptimizerAlgebraicEnviroment extends LatinEnviroment{
    protected OptimizerAlgebraicEnviroment(String name) {
        super(name);
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }
}
