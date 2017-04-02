package org.qcri.rheem.latin.expression;

import java.util.List;

/**
 * Created by bertty on 22-03-17.
 */
public class Evaluator implements Types{
    private Element[] elements           = null;
    private Element   last               = null;
    private double[]  valueVariable      = new double[24];
    private boolean[] valueVariableLogic = new boolean[24];
    private int       size               = 0;



    public Evaluator(List<Element> listOfElements){
        this.size = listOfElements.size();
        elements = new Element[this.size];
        for(int i = 0; i < this.size; i++){
            elements[i] = listOfElements.get(i);
        }
        listOfElements.clear();
        this.last = elements[size-1];
    }

    public boolean returnIsBoolean(){
        return (this.elements[this.size-1].getTypeEle() == LOGICAL)? true: false;
    }


    public void setVariable(char index, int type, double value, boolean valueLogic){
        int indexFinal = index - QUANTITYVARIA;
        if(type == LOGICAL){
            valueVariableLogic[indexFinal] = valueLogic;
        }
        valueVariable[indexFinal] = value;
    }


    public Object evaluate(){
        double  valueA      = 0;
        double  valueB      = 0;
        boolean valueLogicA = false;
        boolean valueLogicB = false;

        for (Element element: this.elements ) {
            switch (element.getTypeA())
            {
                case VALUE           : valueA = element.getValueA(); break; //¿Es un número?
                case VARIABLE        : valueA = valueVariable[element.getVariableA()-QUANTITYVARIA]; break;  //¿Es una variable?
                case CALCULATED      : valueA = this.elements[element.getPositonA()].getValueEle();  break; //¿Es una expresión anterior?
                case VALUELOGIC      : valueLogicA = element.getValueLogicA(); break;
                case VARIABLELOGIC   : valueLogicA = valueVariableLogic[element.getVariableA()-QUANTITYVARIA]; break;
                case CALCULATEDLOGIC : valueLogicA = this.elements[element.getPositonA()].getValueLogicEle(); break;
            }
            if (Double.isNaN(valueA) || Double.isInfinite(valueA)) return valueA;

            switch (element.getTypeB()){
                case VALUE           : valueB = element.getValueB(); break; //¿Es un número?
                case VARIABLE        : valueB = valueVariable[element.getVariableB()-QUANTITYVARIA]; break;  //¿Es una variable?
                case CALCULATED      : valueB = this.elements[element.getPositonB()].getValueEle();  break; //¿Es una expresión anterior?
                case VALUELOGIC      : valueLogicB = element.getValueLogicB(); break;
                case VARIABLELOGIC   : valueLogicB = valueVariableLogic[element.getVariableB()-QUANTITYVARIA]; break;
                case CALCULATEDLOGIC : valueLogicB = this.elements[element.getPositonB()].getValueLogicEle(); break;
            }
            if (Double.isNaN(valueB) || Double.isInfinite(valueB)) return valueB;
            switch (element.getOperator()) {
                case "+":
                    element.setValueEle(valueA + valueB);
                    break;
                case "-":
                    element.setValueEle(valueA - valueB);
                    break;
                case "*":
                    element.setValueEle(valueA * valueB);
                    break;
                case "/":
                    element.setValueEle(valueA / valueB);
                    break;
                case "^":
                    element.setValueEle(Math.pow(valueA, valueB));
                    break;
                case "%":
                    element.setValueEle(valueA % valueB);
                    break;
                case "&&":
                    element.setValueLogicEle(valueLogicA && valueLogicB);
                    break;
                case "||":
                    element.setValueLogicEle(valueLogicA || valueLogicB);
                    break;
                case ">":
                    element.setValueLogicEle(valueA > valueB);
                    break;
                case "<":
                    element.setValueLogicEle(valueA < valueB);
                    break;
                case "<=":
                    element.setValueLogicEle(valueA <= valueB);
                    break;
                case ">=":
                    element.setValueLogicEle(valueA >= valueB);
                    break;
                case "==":
                    element.setValueLogicEle(valueA == valueB);
                    break;
                case "!":
                    element.setValueLogicEle(!valueLogicA);
                    break;
                default:
                    return Double.MAX_VALUE;
            }


        }
        if(this.last.getTypeEle() == LOGICAL){
            return new Boolean(this.last.getValueLogicEle());
        }
        return new Double(this.last.getValueEle());
    }

    public Object evaluate2(Object ... values){
        double  valueA       = 0;
        double  valueB       = 0;
        boolean valueLogicA  = false;
        boolean valueLogicB  = false;
        String  valueStringA = "";
        String  valueStringB = "";


        for (Element element: this.elements ) {
            switch (element.getTypeA())
            {
                case VALUE           : valueA = element.getValueA(); break; //¿Es un número?
                case VARIABLE        : valueA = (Double) values[element.getVariableA()-QUANTITYVARIA]; break;  //¿Es una variable?
                case CALCULATED      : valueA = this.elements[element.getPositonA()].getValueEle();  break; //¿Es una expresión anterior?
                case VALUELOGIC      : valueLogicA = element.getValueLogicA(); break;
                case VARIABLELOGIC   : valueLogicA = (Boolean) values[element.getVariableA()-QUANTITYVARIA]; break;
                case CALCULATEDLOGIC : valueLogicA  = this.elements[element.getPositonA()].getValueLogicEle(); break;
                case VALUESTRING     : valueStringA = element.getValueStringA(); break; //¿Es un número?
                case VARIABLESTRING  : valueStringA = (String) values[element.getVariableA()-QUANTITYVARIA]; break;  //¿Es una variable?
                case CALCULATESTRING : valueStringA = this.elements[element.getPositonA()].getValueStringEle();  break; //¿Es una expresión anterior?

            }
            if (Double.isNaN(valueA) || Double.isInfinite(valueA)) return valueA;

            switch (element.getTypeB()){
                case VALUE           : valueB = element.getValueB(); break; //¿Es un número?
                case VARIABLE        : valueB = (Double) values[element.getVariableB()-QUANTITYVARIA]; break;  //¿Es una variable?
                case CALCULATED      : valueB = this.elements[element.getPositonB()].getValueEle();  break; //¿Es una expresión anterior?
                case VALUELOGIC      : valueLogicB = element.getValueLogicB(); break;
                case VARIABLELOGIC   : valueLogicB = (Boolean) values[element.getVariableB()-QUANTITYVARIA]; break;
                case CALCULATEDLOGIC : valueLogicB = this.elements[element.getPositonB()].getValueLogicEle(); break;
                default: break;
            }
            if (Double.isNaN(valueB) || Double.isInfinite(valueB)) return valueB;
            switch (element.getOperator()) {
                case "+":
                    element.setValueEle(valueA + valueB);
                    break;
                case "-":
                    element.setValueEle(valueA - valueB);
                    break;
                case "*":
                    element.setValueEle(valueA * valueB);
                    break;
                case "/":
                    element.setValueEle(valueA / valueB);
                    break;
                case "^":
                    element.setValueEle(Math.pow(valueA, valueB));
                    break;
                case "%":
                    element.setValueEle(valueA % valueB);
                    break;
                case "&&":
                    element.setValueLogicEle(valueLogicA && valueLogicB);
                    break;
                case "||":
                    element.setValueLogicEle(valueLogicA || valueLogicB);
                    break;
                case ">":
                    element.setValueLogicEle(valueA > valueB);
                    break;
                case "<":
                    element.setValueLogicEle(valueA < valueB);
                    break;
                case "<=":
                    element.setValueLogicEle(valueA <= valueB);
                    break;
                case ">=":
                    element.setValueLogicEle(valueA >= valueB);
                    break;
                case "==":
                    element.setValueLogicEle(valueA == valueB);
                    break;
                case "!":
                    element.setValueLogicEle(!valueLogicA);
                    break;
                case "@LENGTH":
                    element.setValueEle(valueStringA.length());
                    break;
                default:
                    return Double.MAX_VALUE;
            }


        }
        if(this.last.getTypeEle() == LOGICAL){
            return new Boolean(this.last.getValueLogicEle());
        }
        return new Double(this.last.getValueEle());
    }



    public String toString(){
        String ele= "";
        for (Element element: this.elements ) {
            ele += element.toString() +"\n";
        }
        return ele;
    }
}
