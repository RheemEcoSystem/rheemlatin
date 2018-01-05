package org.qcri.rheem.latin.optimizer.plan.enviroment;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.enviroment.LatinEnviroment;

public class OptimizerTemplateEnviroment extends LatinEnviroment {
    protected OptimizerTemplateEnviroment(String name) {
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
