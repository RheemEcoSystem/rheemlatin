package org.qcri.rheem.latin.plan.addons.enviroment;

import org.qcri.rheem.latin.plan.LatinElement;
import org.qcri.rheem.latin.util.LatinException;

public abstract class LatinEnviroment extends LatinElement {

    protected LatinEnviroment(String name) {
        super(name);
    }

    public abstract boolean validate() throws LatinException;
}
