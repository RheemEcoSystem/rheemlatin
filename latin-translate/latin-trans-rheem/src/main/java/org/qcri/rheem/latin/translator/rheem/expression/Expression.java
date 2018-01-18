package org.qcri.rheem.latin.translator.rheem.expression;

import org.qcri.rheem.basic.data.Record;
//import org.qcri.rheem.latin.reflexion.ReflexBuilder;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bertty on 23-04-17.
 */
public class Expression implements Types {
    private Element[] elements           = null;
    private Element   last               = null;
    private double[]  valueVariable      = new double[24];
    private boolean[] valueVariableLogic = new boolean[24];
    private boolean[] valueVariableString= new boolean[24];
    private int       size               = 0;
    private int       max_params         = 0;
    private int       name               = 0;
    private static int geneted           = 0;

    private Map<String, Method> functions= null;



    public Expression(List<Element> listOfElements){
        this.size = listOfElements.size();
        elements = new Element[this.size];
        this.max_params = Integer.MIN_VALUE;
        this.functions = new HashMap<>();
        for(int i = 0; i < this.size; i++){
            elements[i] = listOfElements.get(i);
            this.max_params = (this.max_params < elements[i].getCount_var())? elements[i].getCount_var(): this.max_params;
            if(elements[i].isFunction() &&  elements[i].getTypeEle() != Types.ID_VALUE ){
                /*TODO ver como obtener las configuraciones de esto
                functions.put(elements[i].getOperator(), ReflexBuilder.getFunction(elements[i].getOperator()));
                */
            }
        }
        if(this.max_params < 0){
            this.max_params = 0;
        }
        listOfElements.clear();
        this.name = geneted++;
        if(this.size > 0 ) {
            this.last = elements[size - 1];
        }else if(this.size != 0) {
                this.last = elements[0];
        }
    }



    public Object evaluate(Object ... obj){
        double[] value       = new double[this.max_params];
        String[] valueString = new String[this.max_params];
        boolean[] valueLogic = new boolean[this.max_params];
        if(elements.length > 1) {
            for (Element element : this.elements) {
                if (element.isFunction()) {
                    if (element.getTypeEle() == Types.ID_VALUE) {
                        String value_string_0 = element.getValueString(0);
                        if (value_string_0.contains("[")) {
                            int start_num = value_string_0.indexOf("[") + 1;
                            int finish_num = value_string_0.indexOf("]");
                            int position = Integer.parseInt(value_string_0.substring(start_num, finish_num));
                            element.setValueStringEle(((Record) obj[0]).getString(position));
                            continue;
                        }
                        String[] parts = value_string_0.split("\\.");
                        Object record = obj[0];
                    /* TODO: importar the record dinamic
                    for(int i = 1; i < parts.length; i++) {
                        if (record instanceof RecordDinamic) {
                            record = ((RecordDinamic) record).getField(parts[i]);

                        }else if(record instanceof Record){
                            record = ((Record) record).getField(i);
                        }
                    }*/
                        if (record == null) {
                            return false;
                        }
                        if (!(record instanceof String)) {
                            record = record.toString();
                        }
                        element.setValueStringEle((String) record);
                        continue;
                    }

                    Method _method = this.functions.get(element.getOperator());
                    int _nparams = _method.getParameterTypes().length;
                    Object[] params = new Object[_nparams];
                    int pos = 0;
                    Object _array = null;
                    for (int i = 0; i < element.getCount_var(); i++) {
                        Object value_pos = null;
                        switch (element.getType(i)) {
                            case VALUE:
                                value_pos = element.getValue(i);
                                break; //¿Es un número?
                            case VARIABLE:
                                value_pos = valueVariable[element.getVariable(i) - QUANTITYVARIA];
                                break;  //¿Es una variable?
                            case CALCULATED:
                                if (_method.getParameterTypes()[i].equals(String.class)) {
                                    value_pos = this.elements[element.getPositon(i)].getValueStringEle();
                                } else if (_method.getParameterTypes()[i].equals(Number.class) || _method.getParameterTypes()[i].equals(double.class)) {
                                    value_pos = this.elements[element.getPositon(i)].getValueEle();
                                } else if (_method.getParameterTypes()[i].equals(Boolean.class)) {
                                    value_pos = this.elements[element.getPositon(i)].getValueLogicEle();
                                }
                                break; //¿Es una expresión anterior?
                            case VALUELOGIC:
                                value_pos = element.getValueLogic(i);
                                break;
                            case VARIABLELOGIC:
                                value_pos = valueVariableLogic[element.getVariable(i) - QUANTITYVARIA];
                                break;
                            case CALCULATEDLOGIC:
                                value_pos = this.elements[element.getPositon(i)].getValueLogicEle();
                                break;
                            case VALUESTRING:
                                value_pos = element.getValueString(i);
                                break;
                            case VARIABLESTRING:
                                value_pos = valueVariableString[element.getVariable(i) - QUANTITYVARIA];
                                break;
                            case CALCULATESTRING:
                                value_pos = this.elements[element.getPositon(i)].getValueStringEle();
                                break;
                        }

                        if (_method.getParameterTypes()[pos].isArray()) {
                            if (_array == null) {
                                _array = Array.newInstance(_method.getParameterTypes()[pos].getComponentType(), element.getCount_var() - _nparams + 1);
                            }
                            Array.set(_array, i - _nparams + 1, value_pos);
                            if (params[pos] == null) {
                                params[pos] = _array;
                            }
                        } else {
                            params[pos] = value_pos;
                            pos++;
                        }
                    }
                    try {
                        switch (element.getTypeEle()) {
                            case Types.MATHEMATICAL:
                                Object _value = _method.invoke(null, params);
                                if (_value instanceof Integer) {
                                    element.setValueEle((Integer) _value);
                                } else if (_value instanceof Double) {
                                    element.setValueEle((Double) _value);
                                } else if (_value instanceof Long) {
                                    element.setValueEle((Long) _value);
                                } else if (_value instanceof Float) {
                                    element.setValueEle((Float) _value);
                                }
                                break;
                            case Types.LOGICAL:
                                element.setValueLogicEle((Boolean) _method.invoke(null, params));
                                break;
                            case Types.FUNC_STRING:
                                element.setValueStringEle((String) _method.invoke(null, params));
                                break;
                            default:
                                Object result = _method.invoke(null, params);

                                element.setValueObjectEle(result);
                                break;
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    continue;
                }
                if (element.getCount_var() <= 2) {
                    switch (element.getType(0)) {
                        case VALUE:
                            value[0] = element.getValue(0);
                            if (Double.isNaN(value[0]) || Double.isInfinite(value[0])) return value[0];
                            break; //¿Es un número?
                        case VARIABLE:
                            value[0] = valueVariable[element.getVariable(0) - QUANTITYVARIA];
                            if (Double.isNaN(value[0]) || Double.isInfinite(value[0])) return value[0];
                            break;  //¿Es una variable?
                        case CALCULATED:
                            value[0] = this.elements[element.getPositon(0)].getValueEle();
                            if (Double.isNaN(value[0]) || Double.isInfinite(value[0])) return value[0];
                            break; //¿Es una expresión anterior?
                        case VALUELOGIC:
                            valueLogic[0] = element.getValueLogic(0);
                            break;
                        case VARIABLELOGIC:
                            valueLogic[0] = valueVariableLogic[element.getVariable(0) - QUANTITYVARIA];
                            break;
                        case CALCULATEDLOGIC:
                            valueLogic[0] = this.elements[element.getPositon(0)].getValueLogicEle();
                            break;
                    }

                }
                if (element.getCount_var() == 2) {

                    switch (element.getType(1)) {
                        case VALUE:
                            value[1] = element.getValue(1);
                            if (Double.isNaN(value[1]) || Double.isInfinite(value[1])) return value[1];
                            break; //¿Es un número?
                        case VARIABLE:
                            value[1] = valueVariable[element.getVariable(1) - QUANTITYVARIA];
                            if (Double.isNaN(value[1]) || Double.isInfinite(value[1])) return value[1];
                            break;  //¿Es una variable?
                        case CALCULATED:
                            value[1] = this.elements[element.getPositon(1)].getValueEle();
                            if (Double.isNaN(value[1]) || Double.isInfinite(value[1])) return value[1];
                            break; //¿Es una expresión anterior?
                        case VALUELOGIC:
                            valueLogic[1] = element.getValueLogic(1);
                            break;
                        case VARIABLELOGIC:
                            valueLogic[1] = valueVariableLogic[element.getVariable(1) - QUANTITYVARIA];
                            break;
                        case CALCULATEDLOGIC:
                            valueLogic[1] = this.elements[element.getPositon(1)].getValueLogicEle();
                            break;
                    }
                }
                switch (element.getOperator()) {
                    case "+":
                        element.setValueEle(value[0] + value[1]);
                        break;
                    case "-":
                        element.setValueEle(value[0] - value[1]);
                        break;
                    case "*":
                        element.setValueEle(value[0] * value[1]);
                        break;
                    case "/":
                        element.setValueEle(value[0] / value[1]);
                        break;
                    case "^":
                        element.setValueEle(Math.pow(value[0], value[1]));
                        break;
                    case "%":
                        element.setValueEle(value[0] % value[1]);
                        break;
                    case "&&":
                        element.setValueLogicEle(valueLogic[0] && valueLogic[1]);
                        break;
                    case "||":
                        element.setValueLogicEle(valueLogic[0] || valueLogic[1]);
                        break;
                    case ">":
                        element.setValueLogicEle(value[0] > value[1]);
                        break;
                    case "<":
                        element.setValueLogicEle(value[0] < value[1]);
                        break;
                    case "<=":
                        element.setValueLogicEle(value[0] <= value[1]);
                        break;
                    case ">=":
                        element.setValueLogicEle(value[0] >= value[1]);
                        break;
                    case "==":
                        element.setValueLogicEle(value[0] == value[1]);
                        break;
                    case "!":
                        element.setValueLogicEle(!valueLogic[0]);
                        break;
                    default:
                        return Double.MAX_VALUE;
                }
            }
        }
        switch ( this.last.getTypeEle() ){
            case Types.MATHEMATICAL:
                return (Double) this.last.getValueEle();
            case Types.LOGICAL:
                this.print();
                return (Boolean) this.last.getValueLogicEle();
            case Types.FUNC_STRING:
            case Types.ID_VALUE:
                return (String) this.last.getValueStringEle();
            default:
                return this.last.getValueObjectEle();
        }
    }

    public void print(){
        System.out.println("expression new "+this.name);
        for(int i = 0; i < elements.length; i++){
            System.out.println(elements[i].toString());
        }
    }
/*
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

    public Object evaluate(Object ... values){
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
        int count = 0;
        for (Element element: this.elements ) {
            ele += "["+(count++)+"] " + element.toString() + "\n";
        }
        return ele;
    }
    */
}
