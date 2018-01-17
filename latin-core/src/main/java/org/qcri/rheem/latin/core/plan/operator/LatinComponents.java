package org.qcri.rheem.latin.core.plan.operator;

import org.qcri.rheem.latin.core.exception.LatinCoreException;
import org.qcri.rheem.latin.core.plan.expression.LatinExpression;

import java.util.Arrays;

public class LatinComponents {

    private int size;
    private Class[] types;
    private String[] alias;
    private LatinOperator[] connections;
    private LatinExpression[] expressions;
    private String[] expression_alias;

    public LatinComponents(int size){
        this.size = size;
        this.types = new Class[this.size];
        this.alias = new String[this.size];
        this.connections = new LatinOperator[this.size];
        this.expressions = new LatinExpression[this.size];
        this.expression_alias = new String[this.size];
    }


    public Class getType(int index){
        validIndex(index);
        return this.types[index];
    }

    public Class[] getTypes(){
        return this.types;
    }

    public String getAlias(int index){
        validIndex(index);
        return this.alias[index];
    }

    public String[] getAllAlias(){
        return this.alias;
    }

    public LatinOperator getOperator(int index){
        validIndex(index);

        return null;
    }

    public LatinOperator getOperator(String name){
        int index = this.getIndexOperator(name);
        return this.getOperator(index);
    }

    public LatinOperator[] getOperators(){
        return this.connections;
    }

    public LatinExpression getExpression(int index){
        validIndex(index);
        return this.expressions[index];
    }

    public LatinExpression[] getExpressions(){
        return this.expressions;
    }

    public String[] getExpressions_alias() {
        return expression_alias;
    }

    public String getExpression_alias(int index){
        validIndex(index);
        return this.expression_alias[index];
    }

    public void setType(int index, Class clazz){
        validIndex(index);
        this.types[index] = clazz;
    }

    public void setOperator(int index, LatinOperator operator){
        validIndex(index);
        this.connections[index] = operator;
    }

    public void setAlias(int index, String alias){
        validIndex(index);
        this.alias[index] = alias;
    }

    public void setExpression(int index, LatinExpression expression){
        validIndex(index);
        this.expressions[index] = expression;
    }

    public void setExpression_alias(int index, String expression_alias) {
        validIndex(index);
        this.expression_alias[index] = expression_alias;
    }

    public int getSize(){
        return this.size;
    }

    private void validIndex(int index){
        if(index < 0 || index >= this.size){
            throw new LatinCoreException(
                new ArrayIndexOutOfBoundsException(
                    String.format("the index (%s) is not valid, the range is 0 to %s", index, this.size)
                )
            );
        }
    }

    private int getIndexOperator(String name){
        for(int i = 0; i < this.size; i++){
            if( name.compareTo( this.connections[i].getAlias() ) == 0){
                return i;
            }
        }
        throw new LatinCoreException(
            String.format("the name (%s) not exist in the connection", name)
        );
    }

    @Override
    public String toString() {
        return "LatinComponents{" +
                "size=" + size +
                ", types=" + Arrays.toString(types) +
                ", alias=" + Arrays.toString(alias) +
                ", expressions=" + Arrays.toString(expressions) +
                ", expression_alias=" + Arrays.toString(expression_alias) +
                ", conexion: "+ Arrays.toString(Arrays.stream(this.connections).map(a -> (a ==null)?"":a.getAlias()).toArray()) +
                '}';
    }
}
