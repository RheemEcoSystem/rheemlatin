package org.qcri.rheem.latin.core.plan.structure;

import org.qcri.rheem.basic.data.Tuple2;
import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.enviroment.ClassEnviroment;
import org.qcri.rheem.latin.core.plan.expression.LatinExpression;
import org.qcri.rheem.latin.core.plan.expression.RealFunctionExpression;
import org.qcri.rheem.latin.core.plan.structure.bag.MethodBag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BagStructure extends LatinStructure{
    private static String[] PARAMS = {"withHeader", "header", "regex"};

    private String alias_input;
    private List<Tuple2<String, String>> columns_base;
    private Map<String, String> parameters;


    private List<Tuple2<String, String>> tmp_parameters;

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

    public LatinExpression getExpressionParser(){
        //TODO BAG_CLASS es una palabra reservada para el alias, agregar al parser como validacion;
        ClassEnviroment classEnviroment = new ClassEnviroment("BAG_CLASS", MethodBag.class);

        Object[] _parameters = new Object[2];
        _parameters[0] = (this.getRegex() == null)?";":this.getRegex();

        String[] _header = new String[this.columns_base.size()];
        for(int i = 0; i < _header.length; i++){
            _header[i] = this.columns_base.get(i).field0;
        }
        _parameters[1] = _header;

        return new RealFunctionExpression("BAG_CLASS", classEnviroment, "stringToRecord", _parameters);
    }
}
