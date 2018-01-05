package org.qcri.rheem.latin.parser.latin.plan.structure;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.structure.LatinStructure;

public class ParserLatinStructure extends LatinStructure{
    public ParserLatinStructure(String name) {
        super(name);
    }

    public ParserLatinStructure(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }
}
