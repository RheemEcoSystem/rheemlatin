package org.qcri.rheem.latin;

import org.qcri.rheem.latin.plan.LatinPlan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bertty on 11-04-17.
 */
public class HandlerEngine {
    private List<LatinEngine> engines = null;

    private Map<LatinEngine, Object[]> params = null;

    public HandlerEngine(){
        this.engines = new ArrayList<>();
        this.params  = new HashMap<>();
    }

    public void run(){
        LatinPlan plan = null;
        for(LatinEngine engine: this.engines){

            plan = (LatinPlan) engine.execute( plan, this.params.get(engine) );
        }
    }

    public void registrerEngine(LatinEngine engine, Object ... params){
        this.engines.add(engine);
        this.params.put(engine, params);
    }

}
