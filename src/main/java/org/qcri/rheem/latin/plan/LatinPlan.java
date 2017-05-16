package org.qcri.rheem.latin.plan;

import org.qcri.rheem.latin.plan.operator.LatinExpression;
import org.qcri.rheem.latin.plan.operator.LatinOperator;
import org.qcri.rheem.latin.plan.operator.logical.SinkOperator;
import org.qcri.rheem.latin.plan.operator.logical.SourceOperator;

import java.util.List;
import java.util.Map;

/**
 * Created by bertty on 06-04-17.
 */
public abstract class LatinPlan {

    protected List<LatinOperator>        operators      = null;

    protected List<LatinExpression>      expressions    = null;

    protected List<String>               alias          = null;

    protected Map<String, LatinOperator> aliasOperators = null;

    protected List<SourceOperator>       sourceOperators= null;

    protected List<SinkOperator>         sinkOperators  = null;


    public LatinPlan(){

    }

    public List<LatinOperator> getOperators() {
        return operators;
    }

    public void setOperators(List<LatinOperator> operators) {
        this.operators = operators;
    }

    public List<LatinExpression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<LatinExpression> expressions) {
        this.expressions = expressions;
    }

    public List<String> getAlias() {
        return alias;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    public Map<String, LatinOperator> getAliasOperators() {
        return aliasOperators;
    }

    public void setAliasOperators(Map<String, LatinOperator> aliasOperators) {
        this.aliasOperators = aliasOperators;
    }

    public List<SourceOperator> getSourceOperators() {
        return sourceOperators;
    }

    public void setSourceOperators(List<SourceOperator> sourceOperators) {
        this.sourceOperators = this.sourceOperators;
    }

    public List<SinkOperator> getSinkOperators() {
        return sinkOperators;
    }

    public void setSinkOperators(List<SinkOperator> sinkOperators) {
        this.sinkOperators = sinkOperators;
    }

    public void print(){
        for(LatinOperator tmp: this.operators){
            System.err.println(tmp);
        }
    }
}
