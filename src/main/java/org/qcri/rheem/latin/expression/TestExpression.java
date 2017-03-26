package org.qcri.rheem.latin.expression;

import org.antlr.runtime.RecognitionException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by bertty on 21-03-17.
 */
public class TestExpression implements Types{

    public static int nodo = 0;
    public static ArrayList<Element> lista= null;
    public static String operatorLogical      = "<=>?¿=¬&&||!";
    public static String operatorMathematical = "+-*/%^";





    public static void main(String ... args) throws IOException, RecognitionException {
        Evaluator tmp = EvaluatorBuilder.builderEvaluator("a%2==0");
        for(int i = 0; i < 10; i++) {
            tmp.setVariable('a', MATHEMATICAL, i, false);
            System.out.println(i +"=>"+ tmp.evaluate());
        }
    }

}
