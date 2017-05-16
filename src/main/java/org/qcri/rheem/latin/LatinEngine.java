package org.qcri.rheem.latin;

import org.qcri.rheem.latin.plan.LatinPlan;

/**
 * Created by bertty on 09-04-17.
 */
public abstract class LatinEngine {


    protected String name = null;

    protected LatinPlan plan = null;

    public void load(){
        try {
            LatinContext.loadContext();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-100);
        }
    }


    public abstract LatinPlan execute(LatinPlan plan, Object ... obj);

    public void setPlan(LatinPlan plan){
        this.plan = plan;
    }
}
