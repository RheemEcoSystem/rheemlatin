package org.qcri.rheem.latin.core.plan.enviroment;

import org.qcri.rheem.latin.core.plan.LatinElement;

public class JarEnviroment extends LatinEnviroment{
    protected JarEnviroment(String name) {
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
