package org.qcri.rheem.latin.translator.rheem.plan.structure;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.structure.LatinStructure;

public class TranslatorRheemStructure extends LatinStructure{
    public TranslatorRheemStructure(String name) {
        super(name);
    }

    public TranslatorRheemStructure(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }
}
