package org.qcri.rheem.latin.optimizer.algebraic.engine;

import org.qcri.rheem.latin.core.engine.LatinEngine;
import org.qcri.rheem.latin.core.plan.LatinPlan;

public class OptimizerTemplateEngine extends LatinEngine {
    public OptimizerTemplateEngine(String name) {
        super(name);
    }

    @Override
    public LatinPlan preExecute(LatinPlan plan, Object... obj) {
        return null;
    }

    @Override
    public LatinPlan doexecute(LatinPlan plan, Object... obj) {
        return null;
    }

    @Override
    public LatinPlan postExecute(LatinPlan plan, Object... obj) {
        return null;
    }
}
