package org.qcri.rheem.latin.core.plan.operator.logical;

import org.apache.zookeeper.Op;
import org.qcri.rheem.latin.core.exception.LatinCoreException;
import org.qcri.rheem.latin.core.plan.expression.LatinExpression;
import org.qcri.rheem.latin.core.plan.expression.RealFunctionExpression;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;
import org.qcri.rheem.latin.core.plan.operator.OperatorInput;


import java.util.*;


public class WrapperOperator extends ManyOperator {

    private Map<String, LatinOperator> operators;

    private List<String> alias_inputs;
    private List<String> alias_output;

    private Map<String, RealFunctionExpression> expressionMap;

    {
        if(this.expressionMap == null) {
            this.expressionMap = new HashMap<>();
        }
    }

    public WrapperOperator(String name, int inputs, int outputs) {
        super(name, inputs, outputs);
    }

    public Map<String, LatinOperator> getWrapped(){
        return this.operators;
    }

    public void setOperators(Map<String, LatinOperator> operators) {
        this.operators = operators;
    }

    @Override
    public void setAlias(String alias) {
        this.alias = alias;

        Set<Map.Entry<String, LatinOperator>> setEntry = this.operators.entrySet();
        HashMap<String, LatinOperator> map_new = new HashMap<>();

        for(Map.Entry<String, LatinOperator> entry: setEntry){
            LatinOperator tmp = entry.getValue();
            tmp.setAlias(String.format(tmp.getAlias(), this.alias));

            if(tmp instanceof OperatorInput){
                OperatorInput tmp_input = (OperatorInput) tmp;
                for(int i = 0; i < tmp_input.getSizeInput(); i++) {
                    tmp_input.setAliasInput(
                        i,
                        String.format(
                            tmp_input.getAliasInput(i),
                            this.alias
                        )
                    );
                }
            }


            map_new.put(tmp.getAlias(), tmp);
        }

        ArrayList<String> tmp_output = new ArrayList<>();
        for(String tmp: this.alias_output){
            tmp_output.add(
                String.format(tmp, this.alias)
            );
        }

        this.alias_output = tmp_output;
        this.operators = map_new;


    }

    public List<String> getAlias_inputs() {
        return alias_inputs;
    }

    public void setAlias_inputs(List<String> alias_inputs) {
        this.alias_inputs = alias_inputs;
    }

    public List<String> getAlias_output() {
        return alias_output;
    }

    public void setAlias_output(List<String> alias_outpus) {
        this.alias_output = alias_outpus;
    }

    public String getAliasInputReal(String name){
        int position = this.alias_inputs.indexOf(name);
        if(position < 0){
            //TODO crear un mejor detalle dentro del mensaje
            throw new LatinCoreException(
                String.format("No exist the reference to %s", name)
            );
        }

        return this.getAliasInput(position);
    }

    public  RealFunctionExpression getExpressionMap(String key) {
        return expressionMap.get(key);
    }

    public void putExpressionMap(String key, RealFunctionExpression expressionMap) {
        this.expressionMap.put(key, expressionMap);
    }
}
