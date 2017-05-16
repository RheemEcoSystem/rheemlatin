package org.qcri.rheem.latin.plan.operator;

import org.qcri.rheem.latin.reflexion.ParametersTypes;

/**
 * Created by bertty on 06-04-17.
 */
public abstract class LatinOperator extends LatinElement {
    protected String        alias          = null;
    protected LatinOperator operatorOutput = null;
    protected Class         classOutput    = null;
    protected String        aliasOutput    = null;
    protected ParametersTypes lambdas      = null;

    protected LatinOperator(String name) {
        super(name);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Op( ");
        builder.append(this.name);
        builder.append(" ) -> \"");
        builder.append(this.alias);
        builder.append("\" ");
        builder.append("  output: { ");
        builder.append(this.getClassOutput());
        builder.append(" }");
        return builder.toString();
    }

    public LatinOperator getOperatorOutput() {
        return this.operatorOutput;
    }

    public void setOperatorOutput(LatinOperator operatorOutput) {
        this.operatorOutput = operatorOutput;
    }

    public Class getClassOutput() {
        return this.classOutput;
    }

    public void setClassOutput(Class classOutput) {
        this.classOutput = classOutput;
    }

    public String getAliasOutput() {
        return this.aliasOutput;
    }

    public void setAliasOutput(String aliasOutput) {
        this.aliasOutput = aliasOutput;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setLambdas(ParametersTypes pt){
        this.lambdas = pt;
    }


    public Object[] getParams(String[] params){
        Object[] obj = new Object[params.length];
        return obj;
    }

}
