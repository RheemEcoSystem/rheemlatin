package org.qcri.rheem;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.Tree;
import org.qcri.rheem.parser.QueryLexer;
import org.qcri.rheem.parser.QueryParser;


public class Main {

    public static void main(String[] args){
        try{
            CharStream archivo = new ANTLRFileStream("rheem_latin_test.pig");
            QueryLexer lexer = new QueryLexer(archivo);

            org.qcri.rheem.util.Token tok;

            CommonTokenStream tokens = new CommonTokenStream(new QueryLexer(archivo));

            QueryParser parser = new QueryParser(tokens);

            QueryParser.query_return retorno = parser.query();

            Tree ast = (Tree) retorno.getTree();

            System.out.println(ast.toStringTree());



        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
