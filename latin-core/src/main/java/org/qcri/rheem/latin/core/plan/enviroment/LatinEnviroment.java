package org.qcri.rheem.latin.core.plan.enviroment;

import org.qcri.rheem.latin.core.plan.LatinElement;

public abstract class LatinEnviroment extends LatinElement {

    protected LatinEnviroment(String name) {
        super(name);
    }

    public abstract boolean validate();
}
