package org.qcri.rheem.latin.core.plan.structure;

import org.qcri.rheem.basic.data.Tuple2;
import org.qcri.rheem.latin.core.exception.LatinCoreException;
import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.enviroment.ClassEnviroment;
import org.qcri.rheem.latin.core.plan.expression.LatinExpression;
import org.qcri.rheem.latin.core.plan.expression.RealFunctionExpression;
import org.qcri.rheem.latin.core.plan.structure.bag.MethodBag;

import java.util.*;

public class BagStructure extends LatinStructure{
    private static String[] PARAMS = {"withHeader", "header", "regex"};
    //TODO BAG_CLASS es una palabra reservada para el alias, agregar al parser como validacion;
    private static ClassEnviroment CLASS_ENVIROMENT;

    static{
        CLASS_ENVIROMENT = new ClassEnviroment("BAG_CLASS", MethodBag.class);
    }

    private String alias_input;
    private List<Tuple2<String, String>> columns_base;
    private Map<String, String> parameters;


    private List<Tuple2<String, String>> tmp_parameters;

    private List<String> keys;

    private String regex;

   // private Collection<StageBag> stageBags = new ArrayList<>();


    public BagStructure(String name) {
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

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
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

    @Override
    protected void selfCopy(LatinElement element) {

    }

    public LatinExpression getExpressionSplit(){


        Object[] _parameters = new Object[3];
        _parameters[0] = (this.getRegex() == null)?";":this.getRegex();
        _parameters[1] = getHeader();
        if(this.keys != null){
            _parameters[2] = getKeys();
        }

        return new RealFunctionExpression("BAG_CLASS", CLASS_ENVIROMENT, "stringToRecord", _parameters);
    }

    public String[] getHeader(){
        String[] _header = new String[this.columns_base.size()];
        for(int i = 0; i < _header.length; i++){
            _header[i] = this.columns_base.get(i).field0;
        }
        return _header;
    }

    public void setKeys(List<String> keys){
        this.keys = keys;
    }

    public String[] getKeys(){
        return this.keys.toArray(new String[0]);
    }

    public LatinExpression getExpressionKey(String key){
        Object[] _parameters = new Object[1];

        _parameters[0] = key;

        if(_parameters[0] == null){
            //TODO mas descriptivo el mensaje
            throw new LatinCoreException("the key not exist");
        }
        return new RealFunctionExpression("BAG_CLASS", CLASS_ENVIROMENT, "getKey", _parameters);
    }



}
