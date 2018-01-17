package org.qcri.rheem.latin.core.handler;

import org.qcri.rheem.latin.core.exception.LatinCoreException;
import org.qcri.rheem.latin.core.engine.LatinEngine;

import java.util.ArrayList;
import java.util.List;

public class LatinEdge {

    private List<LatinEdge> previous;
    private List<LatinEdge> next;

    private LatinEngine engine;

    public LatinEdge(LatinEngine engine){
        if(engine == null){
            throw new LatinCoreException(
                new NullPointerException(
                    String.format("the engine is null")
                )
            );
        }
        this.engine   = engine;
        this.next     = new ArrayList<>();
        this.previous = new ArrayList<>();
    }

    public void toConnect(LatinEdge next){
        this.next.add(next);
        next.toConnectPrevious(this);
    }

    private void toConnectPrevious(LatinEdge previus){
        this.previous.add(previus);
    }

    public LatinEngine getEngine(){
        return this.engine;
    }

    public LatinEdge getNext(int index){
        if(this.next.size() == 0){
            return null;
        }
        return this.next.get(index);
    }

    public LatinEdge getPrevius(int index){
        if(this.previous.size() == 0){
            return null;
        }
        return this.previous.get(index);
    }
}
