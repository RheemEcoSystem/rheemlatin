package org.qcri.rheem.latin.core.plan.operator;

import org.qcri.rheem.latin.core.Exception.LatinCoreException;
import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.expression.LatinExpression;
import org.qcri.rheem.latin.core.plan.structure.LatinStructure;

import java.util.ArrayList;
import java.util.List;

public abstract class LatinOperator extends LatinElement{

    protected String alias;
    protected String platform;
    protected List<LatinOperator> broadcast;
    protected List<String>        broadcast_name;
    protected List<LatinExpression> lambdas;
    protected LatinStructure structure_info;
    protected LatinComponents inputs;
    protected LatinComponents outputs;


    {
        if(this.broadcast == null) {
            broadcast = new ArrayList<>();
        }
        if(this.broadcast_name == null){
            broadcast_name = new ArrayList<>();
        }
        if(this.lambdas == null) {
            lambdas = new ArrayList<>();
        }
    }
    public LatinOperator(String name) {
        super(name);
    }

    public LatinOperator(LatinElement element) {
        super(element);
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public LatinOperator getBroadcast(int index){
        if(index < 0 || index >= this.broadcast.size()){
            throw new LatinCoreException(
                new ArrayIndexOutOfBoundsException(
                    String.format(
                        "the index (%s) is not valid for broadcast, the range is 0 to %s",
                        index,
                        this.broadcast.size()
                    )
                )
            );
        }
        return this.broadcast.get(index);
    }

    public String getBroadcastName(int index){
        if(index < 0 || index >= this.broadcast_name.size()){
            throw new LatinCoreException(
                new ArrayIndexOutOfBoundsException(
                    String.format(
                        "the index (%s) is not valid for broadcast, the range is 0 to %s",
                        index,
                        this.broadcast_name.size()
                    )
                )
            );
        }
        return this.broadcast_name.get(index);
    }
    public List<LatinOperator> getBroadcast() {
        return broadcast;
    }
    public List<String> getBroadcastName() {
        return this.broadcast_name;
    }

    public boolean hasBroadcast(){
        return this.broadcast_name != null && this.broadcast_name.size() > 0;
    }

    public void addBroadcast(LatinOperator broadcast) {
        this.broadcast.add(broadcast);
    }

    public void addBroadcast(String broadcast){
        this.broadcast_name.add(broadcast);
    }

    public LatinExpression getLambda(int index){
        if(index < 0 || index >= this.lambdas.size()){
            throw new LatinCoreException(
                new ArrayIndexOutOfBoundsException(
                    String.format(
                        "the index (%s) is not valid for the lambdas, the range is 0 to %s",
                        index,
                        this.lambdas.size()
                    )
                )
            );
        }
        return this.lambdas.get(index);
    }

    public List<LatinExpression> getLambdas() {
        return lambdas;
    }

    public void addLambdas(LatinExpression lambdas) {
        this.lambdas.add(lambdas);
    }

    public LatinStructure getStructure_info() {
        return structure_info;
    }

    public void setStructure_info(LatinStructure structure_info) {
        this.structure_info = structure_info;
    }

    public LatinComponents getInputs() {
        return inputs;
    }

    public LatinComponents getOutputs() {
        return outputs;
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
        if(this.hasBroadcast()){
            builder.append(", broadcast: [");
            for(String broadcast_name :this.broadcast_name ) {
                builder.append(broadcast_name + ",");
            }
            builder.append(" ]");
        }
        builder.append(" ) -> \"");
        builder.append(this.alias);
        builder.append("\" ");
        if(this instanceof OperatorInput) {
            builder.append(" INPUT: {");
            builder.append(this.inputs.toString());
            builder.append(" }");
        }
        if(this instanceof OperatorOutput) {
            builder.append(" OUTPUT: {");
            builder.append(this.outputs.toString());
            builder.append(" }");
        }
        if(this.structure_info != null){
            builder.append(" structure : {");
            builder.append(this.structure_info.toString());
            builder.append(" }");
        }
        return builder.toString();
    }

    public void changeTypes(){}

}