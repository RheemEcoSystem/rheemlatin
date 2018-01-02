package org.qcri.rheem.latin.plan.addons.structure.Bag;

import org.qcri.rheem.basic.data.Tuple2;
import org.qcri.rheem.latin.plan.addons.structure.LatinStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;


public class LatinBag extends LatinStructure {

    private static String[] PARAMS = {"withHeader", "header", "regex"};

    private String alias_input;
    private Collection<Tuple2<String, String>> columns_base;
    private Map<String, String> parameters;


    private Collection<Tuple2<String, String>> tmp_parameters;


    private Collection<StageBag> stageBags = new ArrayList<>();




    public LatinBag(String name) {
        super(name);
    }



    public void setAliasInput(String aliasInput){
        this.alias_input = aliasInput;
    }

    public String getAlias_input() {
        return alias_input;
    }

    public void openStage(){
        //TODO: se prepara para poder setear todos los elementos juntos para las proximas stages
        tmp_parameters = new ArrayList<>();
    }

    public void closeStage(){
        //TODO: add element in the stage
        this.columns_base = this.tmp_parameters;
    }

    public void addHeader(String name, String type){
        //TODO: terminar de implementar o ver si es suficiente con esto
        this.tmp_parameters.add(new Tuple2<>(name, type));
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(" over("+this.alias_input+")");
        sb.append(" params:");
        if( this.columns_base != null ){
            sb.append("[");
            for (Tuple2 tmp : this.columns_base) {
                sb.append(tmp.field0 + "\"" + tmp.field1 + "\"");
            }
            sb.append("]");
        }
        if( this.parameters != null ) {
            for (Map.Entry tmp : parameters.entrySet()) {
                sb.append("< " + tmp.getKey() + " : " + tmp.getValue() + " >");
            }
        }
        return sb.toString();
    }
}
