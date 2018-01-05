package org.qcri.rheem.latin.translator.json.plan.enviroment;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.enviroment.LatinEnviroment;

public class TranslatorJsonEnviroment extends LatinEnviroment{
    protected TranslatorJsonEnviroment(String name) {
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
