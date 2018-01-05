package org.qcri.rheem.latin.parser.latin.query;

import org.qcri.rheem.latin.core.plan.LatinPlan;
import org.qcri.rheem.latin.core.query.LatinQuery;
import org.qcri.rheem.latin.parser.latin.query.plan.FileInputPlan;

public class LatinFileQuery extends LatinQuery {

    private String path;

    public LatinFileQuery(String query_path){
        this.path = query_path;
    }
    @Override
    public LatinPlan convert() {
        return new FileInputPlan(this.path);
    }
}
