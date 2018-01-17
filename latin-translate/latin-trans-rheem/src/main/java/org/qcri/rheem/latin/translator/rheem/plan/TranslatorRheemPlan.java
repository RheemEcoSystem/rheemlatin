package org.qcri.rheem.latin.translator.rheem.plan;

import org.qcri.rheem.core.api.RheemContext;
import org.qcri.rheem.core.plan.rheemplan.Operator;
import org.qcri.rheem.core.plan.rheemplan.RheemPlan;
import org.qcri.rheem.core.plan.rheemplan.UnarySink;
import org.qcri.rheem.core.platform.Platform;
import org.qcri.rheem.java.Java;
import org.qcri.rheem.latin.core.executor.LatinExecutable;
import org.qcri.rheem.latin.core.plan.LatinPlan;
import org.qcri.rheem.latin.core.plan.enviroment.LatinEnviroment;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;
import org.qcri.rheem.latin.core.plan.operator.OperatorInput;
import org.qcri.rheem.latin.core.plan.operator.logical.SinkOperator;
import org.qcri.rheem.latin.core.plan.structure.LatinStructure;
import org.qcri.rheem.latin.translator.rheem.context.TranslatorRheemContext;
import org.qcri.rheem.latin.translator.rheem.context.TranslatorRheemReflexion;
import org.qcri.rheem.postgres.Postgres;
import org.qcri.rheem.spark.Spark;

import java.util.*;

public class TranslatorRheemPlan extends LatinPlan implements LatinExecutable {

    private RheemContext rheemContext;
    private RheemPlan rheemPlan;

    private List<Operator> operatorsRheem;

    private List<UnarySink> opSinkRheem;

    private static Map<String, Platform> platforms;

    private Collection<LatinStructure> structures;
    private Map<String, LatinEnviroment> enviroments;

    public TranslatorRheemPlan(LatinPlan plan){
        if(platforms == null){
            loadPlatform();
        }
        operators      = plan.getOperators();
        expressions    = plan.getExpressions();
        alias          = plan.getAlias();
        aliasOperators = plan.getAliasOperators();
        sourceOperators= plan.getSourceOperators();
        sinkOperators  = plan.getSinkOperators();

        enviroments = plan.getEnviroments();
        structures = plan.getStructures();

    }

    public LatinPlan generateContext(){
        this.rheemContext = new RheemContext();
        this.rheemContext.with(Java.basicPlugin());
        //this.rheemContext.with(Postgres.plugin());
        //this.rheemContext.with(Spark.basicPlugin());
        return this;
    }


    public LatinPlan convert(){
        this.operatorsRheem = new ArrayList<>();
        this.opSinkRheem    = new ArrayList<>();
        Map<String, String> broadcast = new HashMap<>();
        HashMap<String, Operator> map_names = new HashMap<>();
        HashMap<LatinOperator, Operator> map = new HashMap<>();
        TranslatorRheemReflexion mirror = TranslatorRheemContext.getReflexion();
        for(LatinOperator op: this.operators){
            Operator opRheem = mirror.getReflexion(op);
            if(op.getPlatform() != null) {
                opRheem.addTargetPlatform(platforms.get(op.getPlatform()));
            }
            if(op.hasBroadcast()){
                for(String broadcast_name : op.getBroadcastName()) {
                    broadcast.put(op.getAlias(), broadcast_name);
                }
            }
            this.operatorsRheem.add(opRheem);
            map.put(op, opRheem);
            map_names.put(op.getAlias(), opRheem);
            if(op instanceof SinkOperator){
                this.opSinkRheem.add((UnarySink) opRheem);
            }
        }

        for(Map.Entry<String, String> link: broadcast.entrySet()){
            Operator opbroad = map_names.get(link.getValue());
            Operator opLink  = map_names.get(link.getKey());
            opbroad.broadcastTo(0, opLink, link.getValue());
        }

        for(LatinOperator op: this.operators){
            if( ! (op instanceof OperatorInput) ){
                continue;
            }

            OperatorInput current = (OperatorInput) op;
            int lenght = current.getSizeInput();
            for(int i = 0; i < lenght; i++){
                LatinOperator prev = this.aliasOperators.get( current.getAliasInput(i) );
                Operator currentRheem = map.get(prev);
                Operator nextRheem    = map.get(current);
                currentRheem.connectTo(0, nextRheem, i);
            }

        }

        Operator[] sinkop = new Operator[this.opSinkRheem.size()];
        for(int i = 0; i < this.opSinkRheem.size(); i++){
            sinkop[i] = this.opSinkRheem.get(i);
        }
        this.rheemPlan = new RheemPlan(sinkop);
        return this;
    }


    @Override
    public Object execute(){
        return this.rheemContext.createJob(null, this.rheemPlan);
        //this.rheemContext.execute(this.rheemPlan);
    }



    private void loadPlatform(){
        platforms = new HashMap<>();
        platforms.put("java", Java.platform());
        //platforms.put("spark", Spark.platform());
    }

}
