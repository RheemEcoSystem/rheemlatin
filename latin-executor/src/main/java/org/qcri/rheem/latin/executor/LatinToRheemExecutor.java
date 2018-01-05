package org.qcri.rheem.latin.executor;

import org.qcri.rheem.core.api.Job;
import org.qcri.rheem.latin.core.executor.LatinExecutor;
import org.qcri.rheem.latin.core.handler.LatinHandler;
import org.qcri.rheem.latin.core.handler.LinealHandler;
import org.qcri.rheem.latin.core.plan.LatinPlan;
import org.qcri.rheem.latin.core.query.LatinQuery;
import org.qcri.rheem.latin.optimizer.algebraic.engine.OptimizerAlgebraicEngine;
import org.qcri.rheem.latin.parser.latin.engine.ParserLatinEngine;
import org.qcri.rheem.latin.parser.latin.query.LatinFileQuery;
import org.qcri.rheem.latin.translator.rheem.engine.TranslatorRheemEngine;


public class LatinToRheemExecutor extends LatinExecutor{

    public LatinToRheemExecutor(LatinHandler handler) {
        super(handler);
    }


    public static void main(String... args){

        LatinQuery query = new LatinFileQuery(args[0]);

        LatinHandler handler = new LinealHandler();

        handler.registre(new ParserLatinEngine("parser"));
      //  handler.registre(new OptimizerAlgebraicEngine("algebraic"));
        handler.registre(new TranslatorRheemEngine("toRheem"));

        handler.toconnect("parser", "toRheem");
      //  handler.toconnect("parser", "algebraic");
//        handler.toconnect("algebraic", "toRheem");

        LatinToRheemExecutor executor = new LatinToRheemExecutor(handler);

        Job job = (Job) executor.execute(query);

        job.execute();

    }
}
