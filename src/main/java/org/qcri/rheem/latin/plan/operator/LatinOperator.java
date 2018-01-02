package org.qcri.rheem.latin.plan.operator;

import org.qcri.rheem.latin.plan.LatinElement;
import org.qcri.rheem.latin.plan.addons.structure.LatinStructure;
import org.qcri.rheem.latin.reflexion.ParametersTypes;

/**
 * Created by bertty on 06-04-17.
 */
public abstract class LatinOperator extends LatinElement {
    protected String          alias          = null;
    protected LatinOperator   operatorOutput = null;
    protected Class           classOutput    = null;
    protected String          aliasOutput    = null;
    protected ParametersTypes lambdas        = null;
    protected String          platform       = null;
    protected String          broadcast      = null;
    protected LatinStructure  structure_info = null;

    protected LatinOperator(String name) {
        super(name);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Op( ");
        builder.append(this.name);
        if(this.platform != null){
            builder.append(", platform: ");
            builder.append(this.platform);
        }
        if(this.broadcast != null){
            builder.append(", broadcast: ");
            builder.append(this.broadcast);
        }
        builder.append(" ) -> \"");
        builder.append(this.alias);
        builder.append("\" ");
        builder.append("  output: { ");
        builder.append(this.getClassOutput());
        builder.append(" }");
        if(this.structure_info != null){
            builder.append(" structure : {");
            builder.append(this.structure_info.toString());
            builder.append(" }");
        }
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setBroadcast(String alias_broadcast) {
        this.broadcast = alias_broadcast;
    }

    public String getBroadcast() {
        return this.broadcast;
    }

    public LatinStructure getStructure_info() {
        return structure_info;
    }

    public void setStructure_info(LatinStructure structure_info) {
        this.structure_info = structure_info;
    }
}
