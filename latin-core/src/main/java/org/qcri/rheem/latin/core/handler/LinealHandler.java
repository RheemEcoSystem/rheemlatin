package org.qcri.rheem.latin.core.handler;

import org.qcri.rheem.latin.core.engine.LatinEngine;
import org.qcri.rheem.latin.core.plan.LatinPlan;

import java.util.HashMap;

public class LinealHandler extends LatinHandler{

    public LinealHandler(){
        this.edges = new HashMap<>();
    }
    @Override
    protected LatinPlan doExecute(LatinPlan plan) {
        if(this.source == null){
            this.source = (LatinEdge) this.edges.values().toArray()[0];
        }
        LatinEdge current_engine = this.source;
        LatinPlan current_plan   = plan;
        while (current_engine != null) {
            LatinEngine engine = current_engine.getEngine();
            Object[] parameters = engine.getParameters();
            current_plan = engine.execute(current_plan, parameters);
            current_engine = current_engine.getNext(0);
        }
        return current_plan;
    }
}
