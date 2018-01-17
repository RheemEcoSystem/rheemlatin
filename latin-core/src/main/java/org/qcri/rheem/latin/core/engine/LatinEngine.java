package org.qcri.rheem.latin.core.engine;


import org.qcri.rheem.latin.core.exception.LatinException;
import org.qcri.rheem.latin.core.context.LatinContext;
import org.qcri.rheem.latin.core.plan.LatinPlan;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class that permit
 */
public abstract class LatinEngine {
    protected String name = null;

    protected LatinContext context = null;

    public LatinEngine(String name){
        this.name = name;
    }

    public void load(){
        try {
            context.loadContext();
        } catch (LatinException e) {
            e.printStackTrace();
            System.exit(-100);
        }
    }

    public LatinPlan execute(LatinPlan plan, Object ... obj){
        this.load();
        LatinPlan _plan = this.preExecute(plan, obj);
        _plan = this.doexecute(_plan, obj);
        return this.postExecute(_plan, obj);
    }

    public abstract LatinPlan preExecute(LatinPlan plan, Object ... obj);

    public abstract LatinPlan doexecute(LatinPlan plan, Object ... obj);

    public abstract LatinPlan postExecute(LatinPlan plan, Object ... obj);

    public Object[] getParameters(){
        return null;
    }

    public String getName(){
        return this.name;
    }
}
