package org.qcri.rheem.latin.translator.rheem.expression;


public class Element implements Types{
    private int     typeEle        = -1;
    private double  valueEle       = -1;
    private boolean valueLogicEle  = false;
    private String  valueStringEle = "";
    private int     positionParam  = -1;
    private Object  valueObjectEle = null;

    private boolean isFunction     = false;
    private String  operator       = "";

    private int[]     type         = null;
    private double[]  value        = null;
    private boolean[] valueLogic   = null;
    private String[]  valueString  = null;
    private int[]     positon      = null;
    private char[]    variable     = null;

    private int       count_var    = 0;
    private int       index        = 0;

    public Element(int count_var) {
        this.count_var   = count_var;
        this.type        = new int[this.count_var];
        this.value       = new double[this.count_var];
        this.valueLogic  = new boolean[this.count_var];
        this.valueString = new String[this.count_var];
        this.positon     = new int[this.count_var];
        this.variable    = new char[this.count_var];
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setIsFunction(boolean value){
        this.isFunction = value;
    }

    public void setType(int type) {
        this.type[this.index] = type;
    }

    public void setValue(double value) {
        this.value[this.index] = value;
    }

    public void setValueLogic(boolean valueLogic) {
        this.valueLogic[this.index] = valueLogic;
    }

    public void setValueString(String valueString){
        this.valueString[this.index] = valueString;
    }

    public void setPositon(int positon) {
        this.positon[this.index] = positon;
    }

    public void setVariable(char variable) {
        this.variable[this.index] = variable;
    }

    public int getType(int index) {
        return this.type[index];
    }

    public double getValue(int index) {
        return this.value[index];
    }

    public boolean getValueLogic(int index) {
        return this.valueLogic[index];
    }

    public String getValueString(int index){
        return this.valueString[index];
    }

    public int getPositon(int index) {
        return this.positon[index];
    }

    public char getVariable(int index) {
        return this.variable[index];
    }


    public int getTypeEle() {
        return typeEle;
    }

    public void setTypeEle(int typeEle) {
        this.typeEle = typeEle;
    }

    public double getValueEle() {
        return valueEle;
    }

    public void setValueEle(double valueEle) {
        this.valueEle = valueEle;
    }

    public boolean getValueLogicEle() {
        return valueLogicEle;
    }

    public void setValueLogicEle(boolean valueLogicEle) {
        this.valueLogicEle = valueLogicEle;
    }

    public String getValueStringEle() {
        return valueStringEle;
    }

    public void setValueStringEle(String valueStringEle) {
        this.valueStringEle = valueStringEle;
    }

    public String getOperator() {
        return operator;
    }

    public int getPositionParam() {
        return positionParam;
    }

    public void setPositionParam(int positionParam) {
        this.positionParam = positionParam;
    }

    public void addIndex(){
        this.index++;
    }

    public int getCount_var() {
        return count_var;
    }

    public boolean isFunction() {
        return isFunction;
    }







    public String toString(){
        StringBuilder string = new StringBuilder();
        int index = 0;
        if (this.count_var == 2 && ! this.isFunction) {
            string.append(toStringPosition(index++));
        }

        string.append(" " + this.operator + " ");
        for(; index < this.count_var; index++){
            string.append(toStringPosition(index));
            string.append(" ");
        }

        return string.toString();
    }

    private String toStringPosition(int index){
        StringBuilder string = new StringBuilder();

        switch(this.type[index]){
            case CALCULATED:
            case CALCULATEDLOGIC:
            case CALCULATESTRING:
                string.append( "[" + this.positon[index] +"]" );
                break;
            case VALUE:
                string.append(  this.value[index] );
                break;
            case VALUELOGIC:
                string.append( this.valueLogic[index] );
                break;
            case VALUESTRING:
                string.append( this.valueString[index] );
                break;
            case VARIABLE:
            case VARIABLELOGIC:
            case VARIABLESTRING:
                string.append( this.variable[index] );
                break;

        }
        return string.toString();
    }

    public Object getValueObjectEle() {
        return valueObjectEle;
    }

    public void setValueObjectEle(Object valueObjectEle) {
        this.valueObjectEle = valueObjectEle;
    }
}
