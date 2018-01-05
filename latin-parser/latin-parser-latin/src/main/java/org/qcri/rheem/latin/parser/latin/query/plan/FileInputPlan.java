package org.qcri.rheem.latin.parser.latin.query.plan;

import org.qcri.rheem.latin.core.plan.LatinPlan;
import org.qcri.rheem.latin.core.plan.SpecialPlan;

public class FileInputPlan extends LatinPlan implements SpecialPlan{

    public String path;

    public FileInputPlan(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
