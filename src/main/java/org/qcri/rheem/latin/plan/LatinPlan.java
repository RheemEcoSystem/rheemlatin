package org.qcri.rheem.latin.plan;

import org.qcri.rheem.latin.plan.addons.structure.LatinStructure;
import org.qcri.rheem.latin.plan.addons.enviroment.LatinEnviroment;
import org.qcri.rheem.latin.plan.operator.LatinExpression;
import org.qcri.rheem.latin.plan.operator.LatinOperator;
import org.qcri.rheem.latin.plan.operator.logical.SinkOperator;
import org.qcri.rheem.latin.plan.operator.logical.SourceOperator;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by bertty on 06-04-17.
 */
public abstract class LatinPlan {

    protected Collection<LatinOperator>        operators      = null;

    protected Collection<LatinExpression>      expressions    = null;

    protected Collection<String>               alias          = null;

    protected Map<String, LatinOperator>       aliasOperators = null;

    protected Collection<SourceOperator>       sourceOperators= null;

    protected Collection<SinkOperator>         sinkOperators  = null;

    protected Collection<LatinStructure>       structures     = null;

    protected Map<String, LatinEnviroment>     enviroments    = null;

    public LatinPlan(){

    }

    public Collection<LatinOperator> getOperators() {
        return operators;
    }

    public void setOperators(Collection<LatinOperator> operators) {
        this.operators = operators;
    }

    public Collection<LatinExpression> getExpressions() {
        return expressions;
    }

    public void setExpressions(Collection<LatinExpression> expressions) {
        this.expressions = expressions;
    }

    public Collection<String> getAlias() {
        return alias;
    }

    public void setAlias(Collection<String> alias) {
        this.alias = alias;
    }

    public Map<String, LatinOperator> getAliasOperators() {
        return aliasOperators;
    }

    public void setAliasOperators(Map<String, LatinOperator> aliasOperators) {
        this.aliasOperators = aliasOperators;
    }

    public Collection<SourceOperator> getSourceOperators() {
        return sourceOperators;
    }

    public void setSourceOperators(Collection<SourceOperator> sourceOperators) {
        this.sourceOperators = this.sourceOperators;
    }

    public Collection<SinkOperator> getSinkOperators() {
        return sinkOperators;
    }

    public void setSinkOperators(Collection<SinkOperator> sinkOperators) {
        this.sinkOperators = sinkOperators;
    }

    public Collection<LatinStructure> getStructures() {
        return structures;
    }

    public void setStructures(Collection<LatinStructure> structures) {
        this.structures = structures;
    }

    public Map<String, LatinEnviroment> getEnviroments() {
        return enviroments;
    }

    public void setEnviroments(Map<String, LatinEnviroment> enviroments) {
        this.enviroments = enviroments;
    }

    public void print(){
        if (this.enviroments != null) {
            for (LatinEnviroment env : this.enviroments.values()) {
                System.err.println("env: "+env);
            }
        }
        if (this.expressions != null){
            for(LatinExpression expr: this.expressions){
                System.err.println("expr: "+expr);
            }
        }
        if (this.structures != null) {
            for (LatinStructure str : this.structures) {
                System.err.println("stru: "+str);
            }
        }
        for(LatinOperator tmp: this.operators){
            System.err.println("ope: "+tmp);
        }
    }
}
