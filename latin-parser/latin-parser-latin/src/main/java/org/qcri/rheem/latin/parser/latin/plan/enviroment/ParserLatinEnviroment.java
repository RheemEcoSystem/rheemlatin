package org.qcri.rheem.latin.parser.latin.plan.enviroment;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.enviroment.LatinEnviroment;

public class ParserLatinEnviroment extends LatinEnviroment{
    protected ParserLatinEnviroment(String name) {
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
