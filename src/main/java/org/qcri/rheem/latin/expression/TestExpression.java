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
        Evaluator tmp = EvaluatorBuilder.builderEvaluator("@LENGTH(a)>5");
     //  for(int i = 0; i < 10; i++) {
        String hola = "holass";
            System.out.println(hola.length());
            System.out.println(0 +"=>"+ tmp.evaluate2(hola));
     //   }
    }

}
