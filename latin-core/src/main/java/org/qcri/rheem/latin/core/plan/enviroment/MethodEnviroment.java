package org.qcri.rheem.latin.core.plan.enviroment;

import org.qcri.rheem.latin.core.plan.LatinElement;

public class MethodEnviroment extends LatinEnviroment{
    protected MethodEnviroment(String name) {
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
