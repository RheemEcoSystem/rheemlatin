package org.qcri.rheem.latin.translator.rheem.engine;

import org.qcri.rheem.latin.core.engine.LatinEngine;
import org.qcri.rheem.latin.core.plan.LatinPlan;
import org.qcri.rheem.latin.translator.rheem.context.TranslatorRheemContext;
import org.qcri.rheem.latin.translator.rheem.exception.TranslatorRheemException;
import org.qcri.rheem.latin.translator.rheem.plan.TranslatorRheemPlan;

import java.net.URI;

public class TranslatorRheemEngine extends LatinEngine{

    public TranslatorRheemEngine(String name) {
        super(name);
        this.context = new TranslatorRheemContext(URI.create("file:///Users/bertty/Qatar/rheem-latin/latin-translate/latin-trans-rheem/src/main/resources/latin.conf.mapping.json"));
    }

    @Override
    public LatinPlan preExecute(LatinPlan plan, Object... obj) {
        return new TranslatorRheemPlan(plan).generateContext();
    }

    @Override
    public LatinPlan doexecute(LatinPlan plan, Object... obj) {
        System.out.println("TranslatorRheemEngine");
        validPlan(plan);
        return ((TranslatorRheemPlan)plan).convert();
    }

    @Override
    public LatinPlan postExecute(LatinPlan plan, Object... obj) {
        validPlan(plan);
        return plan;
    }

    private void validPlan(LatinPlan plan){
        if( ! (plan instanceof TranslatorRheemPlan) ){
            throw new TranslatorRheemException(
                    String.format(
                            "The class %s not extend of %s",
                            plan.getClass(),
                            TranslatorRheemPlan.class
                    )
            );
        }
    }
}


