package org.qcri.rheem.latin.parser;

import org.qcri.rheem.latin.reflexion.ObjectConf;
import org.qcri.rheem.latin.reflexion.ObjectExpression;
import org.qcri.rheem.latin.reflexion.ReflexBuilder;

import java.util.Set;

/**
 * Created by bertty on 09-04-17.
 */
public class LoaderTokens {

    public static void load(){
        System.err.println("Loading Tokens");

        System.err.println("\tLoading Lexers");
        loadLexer();

        System.err.println("\tLoading Parser");
        loadParser();

        System.err.println("Tokens Loaded");
    }


    private  static void loadLexer(){
        try {
            loadLexerExpression(ObjectConf.OP_EXPRESSION);
            loadLexerLogical(ObjectConf.OP_LOGICAL);
            loadLexerFunction(ObjectConf.OP_FUNCTION);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-101);
        }
    }

    private static void loadLexerExpression(String nameGroup) throws Exception {
        Set<String> keys = ReflexBuilder.getKeys(nameGroup);

        for(String key:keys){
            ObjectConf obj = ReflexBuilder.getObject(nameGroup, key);
            ObjectExpression element = (ObjectExpression) obj;
            switch (element.getType_class()) {
                case ObjectExpression.TYPE_CLASS_BINARY:
                    LatinLexer.addBinaryOperator(element.getName());
                    break;
                case ObjectExpression.TYPE_CLASS_UNARY:
                    LatinLexer.addPrefixOperator(element.getName());
                    break;
                case ObjectExpression.TYPE_CLASS_CONST:
                    break;
                default:
                    throw new Exception("problema al cargar las clases");
            }
        }
    }

    private static void loadLexerLogical(String nameGroup){
        Set<String> keys = ReflexBuilder.getKeys(nameGroup);
        for(String key:keys){
            ObjectConf obj = ReflexBuilder.getObject(nameGroup, key);
            LatinLexer.addOperator(obj.getName());
        }
    }

    private static void loadLexerFunction(String nameGroup){
        Set<String> keys = ReflexBuilder.getKeys(nameGroup);

        for(String key:keys){
            ObjectConf obj = ReflexBuilder.getObject(nameGroup, key);
            LatinLexer.addFunction(obj.getName());

        }
    }

    private static void loadParser(){
        loadParserExpression(ObjectConf.OP_EXPRESSION);
        loadParserLogical(ObjectConf.OP_LOGICAL);
        loadParserFunction(ObjectConf.OP_FUNCTION);

    }

    private static void loadParserExpression(String nameGroup){
        Set<String> keys = ReflexBuilder.getKeys(nameGroup);
        int index = 0;
        for(String key:keys){
            ObjectExpression element =(ObjectExpression) ReflexBuilder.getObject(nameGroup, key);
            LatinParser.addPrecedenceMap(element.getName(), index);
            index++;
        }
    }

    private static void loadParserLogical(String nameGroup){
        Set<String> keys = ReflexBuilder.getKeys(nameGroup);
        int index = 0;
        for(String key:keys){
            ObjectConf element = ReflexBuilder.getObject(nameGroup, key);
            LatinParser.addOperatorMap(element.getName(), index);
            index++;
        }
    }

    private static void loadParserFunction(String nameGroup){
        Set<String> keys = ReflexBuilder.getKeys(nameGroup);
        int index = 0;
        for(String key:keys){
            ObjectConf element = ReflexBuilder.getObject(nameGroup, key);
            LatinParser.addFunctionMap(element.getName(), index);
            index++;
        }
    }

}
