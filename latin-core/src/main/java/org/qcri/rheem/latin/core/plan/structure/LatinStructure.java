package org.qcri.rheem.latin.core.plan.structure;

import org.qcri.rheem.latin.core.plan.LatinElement;

public abstract class LatinStructure extends LatinElement {
    public LatinStructure(String name) {
        super(name);
    }

    public LatinStructure(LatinElement element) {
        super(element);
    }
}
