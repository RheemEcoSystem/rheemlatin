package org.qcri.rheem.latin.translator;

import org.qcri.rheem.latin.plan.Operator;

import java.util.List;

/**
 * Created by bertty on 14-03-17.
 */
public abstract class Translated {

    protected Mapped       mapped       = null;
    protected List<Mapped> predecessors = null;
    protected List<Mapped> successors   = null;

    public boolean isTranslationComplete(){
        return false;
    };

    public List<Mapped> incomplete(){
        return null;
    };

    public String getName() {
        return this.mapped.getName();
    }

    public void setName(String name) {
        this.mapped.setName( name );
    }

    public Operator getOperator() {
        return this.mapped.getOperator();
    }

    public void setOperator(Operator operator) {
        this.mapped.setOperator( operator );
    }

    public List<Mapped> getPredecessors() {
        return predecessors;
    }

    public List<Mapped> getSuccessors() {
        return successors;
    }

    public void addPredecessor(Mapped predecessor){
        this.predecessors.add(predecessor);
    }

    public void addSuccessor(Mapped successor){
        this.successors.add(successor);
    }

    public void setPredecessors(List<Mapped> op_predecessors) {
        if ( op_predecessors == null || op_predecessors.size() == 0 ) return;
        this.predecessors = op_predecessors;
    }

    public void setSuccessors(List<Mapped> op_successors) {
        if ( op_successors == null || op_successors.size() == 0 ) return;
        this.successors = op_successors;
    }



    public Mapped getMapped() {
        return mapped;
    }

    public void setMapped(Mapped mapped) {
        this.mapped = mapped;
    }

    public void generateSlot(){
        this.mapped.getOperatorMapped().setInputSlot(this.predecessors.size());
        this.mapped.getOperatorMapped().setOutputSlot(this.successors.size());
    }
}
