package org.qcri.rheem.latin.translator;

import org.qcri.rheem.core.api.RheemContext;
import org.qcri.rheem.core.plan.rheemplan.Operator;
import org.qcri.rheem.core.plan.rheemplan.RheemPlan;
import org.qcri.rheem.core.plan.rheemplan.UnarySink;
import org.qcri.rheem.java.Java;
import org.qcri.rheem.latin.plan.LatinPlan;
import org.qcri.rheem.latin.plan.operator.LatinOperator;
import org.qcri.rheem.latin.plan.operator.OperatorInput;
import org.qcri.rheem.latin.plan.operator.logical.SinkOperator;
import org.qcri.rheem.postgres.Postgres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bertty on 11-04-17.
 */
public class TranslatedPlan extends LatinPlan{
    private RheemContext rheemContext = null;
    private RheemPlan    rheemPlan    = null;

    private List<Operator> operatorsRheem  = null;

    private List<UnarySink> opSinkRheem  = null;

    public TranslatedPlan(LatinPlan plan){
        operators      = plan.getOperators();
        expressions    = plan.getExpressions();
        alias          = plan.getAlias();
        aliasOperators = plan.getAliasOperators();
        sourceOperators= plan.getSourceOperators();
        sinkOperators  = plan.getSinkOperators();
    }

    public void generateContext(){
        this.rheemContext = new RheemContext();
        this.rheemContext.with(Java.basicPlugin());
        this.rheemContext.with(Postgres.plugin());
        //this.rheemContext.with(Spark.basicPlugin());
    }


    public void convert(){
        this.operatorsRheem = new ArrayList<>();
        this.opSinkRheem    = new ArrayList<>();
        HashMap<LatinOperator, Operator> map = new HashMap<>();
        for(LatinOperator op: this.operators){
            Operator opRheem = LoaderOperator.reflectOperator(op);
            this.operatorsRheem.add(opRheem);
            map.put(op, opRheem);
            if(op instanceof SinkOperator){
                this.opSinkRheem.add((UnarySink) opRheem);
            }
        }

        for(LatinOperator op: this.operators){
            if( ! (op instanceof OperatorInput) ){
                continue;
            }

            OperatorInput current = (OperatorInput) op;
            int lenght = current.getNinputs();
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

    }



    public void execute(){
        this.rheemContext.execute(this.rheemPlan);
    }




}
