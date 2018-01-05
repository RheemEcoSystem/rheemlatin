package org.qcri.rheem.latin.translator.template.plan.structure;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.structure.LatinStructure;

public class TranslatorTemplateStructure extends LatinStructure{
    public TranslatorTemplateStructure(String name) {
        super(name);
    }

    public TranslatorTemplateStructure(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }
}
