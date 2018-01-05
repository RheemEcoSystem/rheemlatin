package org.qcri.rheem.latin.translator.json.plan.structure;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.structure.LatinStructure;

public class TranslatorJsonStructure extends LatinStructure {
    public TranslatorJsonStructure(String name) {
        super(name);
    }

    public TranslatorJsonStructure(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }
}
