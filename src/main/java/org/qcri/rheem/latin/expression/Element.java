package org.qcri.rheem.latin.expression;

/**
 * Created by bertty on 22-03-17.
 */
public class Element implements Types{
    private int     typeEle        = -1;
    private double  valueEle       = -1;
    private boolean valueLogicEle  = false;
    private String  valueStringEle = "";

    private int     typeA          = -1;
    private double  valueA         = -1;
    private boolean valueLogicA    = false;
    private String  valueStringA   = "";
    private int     positonA       = -1;
    private char    variableA      = '\0';

    private String  operator       = "";

    private int     typeB          = -1;
    private double  valueB         = -1;
    private boolean valueLogicB    = false;
    private String  valueStringB   = "";
    private int     positonB       = -1;
    private char    variableB      = '\0';

    public int getTypeEle() {
        return typeEle;
    }

    public void setTypeEle(int typeEle) {
        this.typeEle = typeEle;
    }

    public double getValueEle() {
        return valueEle;
    }

    public void setValueEle(double value) {
        this.valueEle = value;
    }

    public boolean getValueLogicEle() {
        return valueLogicEle;
    }

    public void setValueLogicEle(boolean valueLogic) {
        this.valueLogicEle = valueLogic;
    }

    public int getTypeA() {
        return typeA;
    }

    public void setTypeA(int typeA) {
        this.typeA = typeA;
    }

    public double getValueA() {
        return valueA;
    }

    public void setValueA(double valueA) {
        this.valueA = valueA;
    }

    public boolean getValueLogicA() {
        return valueLogicA;
    }

    public void setValueLogicA(boolean valueLogicA) {
        this.valueLogicA = valueLogicA;
    }

    public int getPositonA() {
        return positonA;
    }

    public void setPositonA(int positonA) {
        this.positonA = positonA;
    }

    public char getVariableA() {
        return variableA;
    }

    public void setVariableA(char variableA) {
        this.variableA = variableA;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getTypeB() {
        return typeB;
    }

    public void setTypeB(int typeB) {
        this.typeB = typeB;
    }

    public double getValueB() {
        return valueB;
    }

    public void setValueB(double valueB) {
        this.valueB = valueB;
    }

    public boolean getValueLogicB() {
        return valueLogicB;
    }

    public void setValueLogicB(boolean valueLogicB) {
        this.valueLogicB = valueLogicB;
    }

    public int getPositonB() {
        return positonB;
    }

    public void setPositonB(int positonB) {
        this.positonB = positonB;
    }

    public char getVariableB() {
        return variableB;
    }

    public void setVariableB(char variableB) {
        this.variableB = variableB;
    }

    public boolean isValueLogicEle() {
        return valueLogicEle;
    }

    public String getValueStringEle() {
        return valueStringEle;
    }

    public void setValueStringEle(String valueStringEle) {
        this.valueStringEle = valueStringEle;
    }

    public boolean isValueLogicA() {
        return valueLogicA;
    }

    public String getValueStringA() {
        return valueStringA;
    }

    public void setValueStringA(String valueStringA) {
        this.valueStringA = valueStringA;
    }

    public boolean isValueLogicB() {
        return valueLogicB;
    }

    public String getValueStringB() {
        return valueStringB;
    }

    public void setValueStringB(String valueStringB) {
        this.valueStringB = valueStringB;
    }

    public void setType(int type) {
        if(this.operator == ""){
            this.typeA = type;
            return;
        }
        this.typeB = type;
    }


    public void setValue(double value) {
        if(this.operator == ""){
            this.valueA = value;
            return;
        }
        this.valueB = value;
    }

    public void setValueLogic(boolean valueLogic) {
        if(this.operator == "") {
            this.valueLogicA = valueLogic;
            return;
        }
        this.valueLogicB = valueLogic;
    }

    public void setValueString(String valueString){
        if(this.operator == "") {
            this.valueStringA = valueString;
            return;
        }
        this.valueStringB = valueString;
    }

    public void setPositon(int positon) {
        if(this.operator == "") {
            this.positonA = positon;
        }
        this.positonB = positon;
    }

    public void setVariable(char variable) {
        if(this.operator == "") {
            this.variableA = variable;
        }
        this.variableB = variable;
    }

    public String toString(){
        String string = " ";
        switch(this.getTypeA()){
            case CALCULATED:
            case CALCULATEDLOGIC:
            case CALCULATESTRING:
                string += "[" + this.getPositonA() +"]";
                break;
            case VALUE:
                string +=  this.getValueA();
                break;
            case VALUELOGIC:
                string += this.getValueLogicA();
                break;
            case VALUESTRING:
                string += this.getValueStringA();
                break;
            case VARIABLE:
            case VARIABLELOGIC:
            case VARIABLESTRING:
                string += this.getVariableA();
                break;

        }
        string += " " + this.getOperator() + " ";
        switch(this.getTypeB()){
            case CALCULATED:
                string += "[" + this.getPositonB() +"]";
                break;
            case VALUE:
                string += (this.getTypeB() != LOGICAL)? this.getValueB(): this.getValueLogicB();
                break;
            case VARIABLE:
                string += this.getVariableB();
        }
        return string;
    }
}
