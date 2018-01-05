package org.qcri.rheem.latin.parser.template.plan.enviroment;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.enviroment.LatinEnviroment;

public class ParserTemplateEnviroment extends LatinEnviroment{
    protected ParserTemplateEnviroment(String name) {
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
