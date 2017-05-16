package org.qcri.rheem.latin.translator;

import org.qcri.rheem.latin.LatinEngine;
import org.qcri.rheem.latin.plan.LatinPlan;

/**
 * Created by bertty on 11-04-17.
 */
public class TranslatorEngine extends LatinEngine{

    public TranslatorEngine(){
        this.load();
    }

    public void load(){

    }


    @Override
    public LatinPlan execute(LatinPlan plan, Object... obj) {
        TranslatedPlan tr_plan = new TranslatedPlan( plan );
        tr_plan.generateContext();
        tr_plan.convert();
        tr_plan.execute();
        return null;
    }
}
