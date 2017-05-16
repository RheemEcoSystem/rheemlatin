package org.qcri.rheem.latin.dinamic;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**MathParser.ParensContext
 * Created by bertty on 05-04-17.
 */
public class Test {

    public static void main(String ... args) throws IOException {

        CharStream archivo = new ANTLRFileStream("test_dinamic.pig");

        CommonTokenStream tokens = new CommonTokenStream(new MathLexer(archivo));
        MathLexer.addBinaryOperator("$");
        MathParser.addPrecedenceMap("$", 6);
        MathParser test = new MathParser(tokens);

        ParserRuleContext ast = test.prog();



        MathParserListener listener = new MathParserBaseListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, ast);
        return;
    }

    public static void bajar(ParseTree ast){

        for(int i = 0; i < ast.getChildCount(); i++){
            bajar(ast.getChild(i));
        }

    }

}
