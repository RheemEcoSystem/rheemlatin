package org.qcri.rheem.latin.core.handler;

import org.qcri.rheem.latin.core.engine.LatinEngine;
import org.qcri.rheem.latin.core.plan.LatinPlan;
import org.qcri.rheem.latin.core.query.LatinQuery;

import java.util.Collection;
import java.util.Map;

public abstract class LatinHandler {

    protected Map<String, LatinEdge> edges = null;

    protected LatinEdge source;

    public void registre(LatinEngine engine){
        this.edges.put(engine.getName(), new LatinEdge(engine));
    }

    public void toconnect(String source, String consumer){
        LatinEdge edgeSource = this.edges.get(source);
        LatinEdge edgeConsumer = this.edges.get(consumer);
        edgeSource.toConnect(edgeConsumer);
        if(this.source == null){
            this.source = edgeSource;
        }
        if(this.source == edgeConsumer){
            this.source = edgeSource;
        }
    }

    public LatinPlan execute(LatinQuery query){
        LatinPlan plan = query.convert();
        return doExecute(plan);
    }

    protected abstract LatinPlan doExecute(LatinPlan plan);

}
