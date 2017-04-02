package org.qcri.rheem.latin.expression;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.Tree;

import java.util.ArrayList;

/**
 * Created by bertty on 23-03-17.
 */
public class EvaluatorBuilder implements Types{
    public static int nodo = 0;
    public static ArrayList<Element> lista= null;
    public static String operatorLogical      = "<=>?¿==¬&&||!";
    public static String operatorMathematical = "+-*/%^";

    public static Evaluator builderEvaluator(String input) throws RecognitionException {
        CharStream archivo = new ANTLRStringStream(input);
        CommonTokenStream tokens = new CommonTokenStream(new Valid2Lexer(archivo));

        Valid2Parser parser = new Valid2Parser(tokens);


        Tree ast = (Tree) parser.base().getTree();

       // System.out.println(ast.toStringTree());

        lista = new ArrayList();

        generateList(ast.getChild(0));


        return new Evaluator(lista);
    }


    public static int generateList(Tree ast){
        //   System.out.println("nodo "+var+" :> "+ast.toString());
        //   System.out.println("subarbol :> "+ast.toStringTree());
        int fin = ast.getChildCount();
        boolean allLeaf = true;
        boolean[] branch = new boolean[fin];
        int[] position = new int[fin];
        for(int i = 0; i < fin; i++){
            branch[i] = isleaf(ast.getChild(i));
            if(!branch[i]){
                position[i] = generateList(ast.getChild(i));
            }else{
                position[i] = -1;
            }
        }

        // System.out.print("["+(nodo)+"] ");

        Element element = new Element();

        element.setTypeEle( typeElement(ast.getText()) );
        for(int i = 0; i < fin; i++){

            if(position[i] >= 0){
                // System.out.print("["+position[i]+"] ");
                element.setType(CALCULATED);
                element.setPositon(position[i]);

            }else{

                String children = ast.getChild(i).toString();
                int type = typeComponent(children, element.getTypeEle());
                element.setType(type);

                switch (type){
                    case VALUE:
                        element.setValue(getNumber(children));
                        break;
                    case VALUELOGIC:
                        element.setValueLogic(getLogic(children));
                        break;
                    case VALUESTRING:
                        element.setValueString(children);
                        break;
                    case VARIABLE:
                    case VARIABLELOGIC:
                    case VARIABLESTRING:
                        element.setVariable(children.charAt(0));
                        break;
                    default:
                        break;
                }

                /*
                if(type == VALUE || type == VALUELOGIC ){
                    if(isLogic(children)){
                        element.setValueLogic(getLogic(children));
                    }else {
                        element.setValue(getNumber(children));
                    }
                }else{
                    if(type == VARIABLELOGIC){
                        element.setVariable(children.charAt(0));//// REVISAR SI ES ASI.
                    }else {
                        element.setVariable(children.charAt(0));
                    }
                }*/
            }
            if(i == fin-2 || fin == 1){
                element.setOperator(ast.getText());
            }
        }

        lista.add(element);
        return nodo++;
    }

    public static boolean isleaf(Tree ast){
        return ast.getChildCount() == 0;
    }

    public static int typeElement(String operator){
        if (isOperatorLogica(operator))
            return LOGICAL;
        if (isOperatorMathematical(operator))
            return MATHEMATICAL;

        return FUNC_STRING;
    }

    public static boolean isOperatorLogica(String evaluated){
        return operatorLogical.contains(evaluated);
    }

    public static boolean isOperatorMathematical(String evaluated){
        return operatorMathematical.contains(evaluated);
    }

    public static int typeComponent(String evaluated, int operator){
        // is variable ??
        if(isVariable(evaluated)) {
            // --> what it is type of the variable??
            switch (operator){
                case FUNC_STRING  : return VARIABLESTRING;
                case MATHEMATICAL : return VARIABLE;
                case LOGICAL      : return VARIABLELOGIC;
            }
        }
        //if not variable is value
        // --> what it is type of the value??
        if(isLogic(evaluated)){
            return VALUELOGIC;
        }
        if(isMathematical(evaluated)){
            return VALUE;
        }
        return VALUESTRING;
    }

    public static boolean isVariable(String evaluated){
        if(evaluated.equalsIgnoreCase("true") || evaluated.equalsIgnoreCase("false")){
            return false;
        }
        try {
            double d = Double.parseDouble(evaluated);
        } catch(NumberFormatException nfe) {
            return true;
        }
        return false;
    }

    public static boolean isLogic(String evaluated){
        if(evaluated.equalsIgnoreCase("true") || evaluated.equalsIgnoreCase("false")){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isMathematical(String evaluated){
        try {
            double d = Double.parseDouble(evaluated);
        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean getLogic(String evaluated){
        return (evaluated.equalsIgnoreCase("true"))? true: false;
    }


    public static Double getNumber(String evaluated){
        return Double.parseDouble(evaluated);
    }

}
