package org.qcri.rheem.latin.translator;

import org.qcri.rheem.latin.plan.Operator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bertty on 14-03-17.
 */
public class LatinTranslated extends Translated{

    public LatinTranslated(String name, Operator operator) {
        this.mapped = new Mapped(name, operator);
        this.predecessors = new ArrayList<Mapped>();
        this.successors   = new ArrayList<Mapped>();
    }

    @Override
    public boolean isTranslationComplete() {
        return false;
    }

    @Override
    public List<Mapped> incomplete() {
        return null;
    }

}
