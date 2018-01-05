package org.qcri.rheem.latin.core.executor;

import org.qcri.rheem.latin.core.handler.LatinHandler;
import org.qcri.rheem.latin.core.plan.LatinPlan;
import org.qcri.rheem.latin.core.query.LatinQuery;

public abstract class LatinExecutor {

    protected LatinHandler handler;

    public LatinExecutor(LatinHandler handler){
        this.handler = handler;
    }

    public Object execute(LatinQuery query){
        LatinPlan plan_final = this.realExecute(query);
        if(plan_final instanceof LatinExecutable){
            return ((LatinExecutable) plan_final).execute();
        }
        return plan_final;
    }

    protected LatinPlan realExecute(LatinQuery query){
        return this.handler.execute(query);
    }
}
