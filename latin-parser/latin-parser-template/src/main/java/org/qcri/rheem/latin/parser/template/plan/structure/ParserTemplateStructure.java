package org.qcri.rheem.latin.parser.template.plan.structure;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.structure.LatinStructure;

public class ParserTemplateStructure extends LatinStructure{
    public ParserTemplateStructure(String name) {
        super(name);
    }

    public ParserTemplateStructure(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }
}
