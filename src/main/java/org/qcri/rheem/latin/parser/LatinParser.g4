parser grammar LatinParser;

options {
  tokenVocab=LatinLexer;
}

@header {
package org.qcri.rheem.latin.parser;
import java.util.*;
}


@members {
    private static final int    BINARY  = 0;
    static Map<String, Integer> precedenceMap = new HashMap<String, Integer>();
    static Map<String, Integer> operatorMap   = new HashMap<String, Integer>();
    static Map<String, Integer> functionMap   = new HashMap<String, Integer>();


    public static void addPrecedenceMap(String symbol, int code){
        precedenceMap.put(symbol, code);
    }

    public static Integer getPrecedence(Token op) {
        Integer tmp = precedenceMap.get(op.getText());
        return (tmp != null)? tmp: -1;
    }

    public static Integer getNextPrecedence(Token op) {
        System.out.println(op.getType()+"  ");
        Integer p = getPrecedence(op);
        if (op.getType() == PREOP)              return p;
        else if (op.getType() == BINOP)         return p+1;
        else if (op.getType() == POSTOP)        return p+1;
        else if (op.getType() == OPERATOR_NAME) return p+1;
        else if (op.getType() == FUNC_NAME)     return p+1;
        throw new IllegalArgumentException(op.getText());
    }

    public static void addOperatorMap(String symbol, int code){
        operatorMap.put(symbol, code);
    }

    public static void addFunctionMap(String symbol, int code){
        functionMap.put(symbol, code);
    }
}

query :
        statement*
;

statement :
       ID ASSING
       (    operator_statement
         |  source_statement
       ) with? SEMI_COLON                   #BaseStatement
   |   sink_statement with? SEMI_COLON      #SinkStatement


;

operator_statement :
        name=OPERATOR_NAME (lambda)? (COMA lambda)* #OperatorStatement
;

lambda :
        ID type?
    |   ID ARROW ACCO_LEFT expr[0] ACCO_RIGHT type?
    |   expr[0]
;

type :
        COLON (BOOLEAN|INT|LONG|FLOAT|BIGDECIMAL|BIGINTEGER|DOUBLE|DATETIME|STRING)
;

source_statement :
        LOAD QUOTEDSTRING as_clause*
;

as_clause :
        AS type_load? PLEFT pair PRIGHT /*( explicit_field_def | (PLEFT field_def_list* PRIGHT)) */
;

type_load :
        JSON
    |   ID
    |   SQL
;

pair :
    ((QUOTEDSTRING (COMA QUOTEDSTRING)*) | (ID type (COMA ID type)*))*
;

sink_statement :
        name=OPERATOR_NAME ID QUOTEDSTRING
;
/*
function_statement
    :   func_name
    |   func_name PLEFT func_args* PRIGHT
    ;

func_name
    :
    ;

func_args
    :
    ;
*/

expr [int _p] :
        atom
        (  {getPrecedence(_input.LT(1)) >= $_p}? op=BINOP expr[getNextPrecedence($op)]
        |   {getPrecedence(_input.LT(1)) >= $_p}? op=POSTOP
        )*
    ;

atom :
        constant                                #NumberExpression
    |   PLEFT expr[0] PRIGHT                    #ParenExpression
    |   op=PREOP expr[getNextPrecedence($op)]   #PrefixExpression
    |   functionExpr                            #FunctionExpression
    ;

functionExpr :
        name=FUNC_NAME PLEFT ( expr[0] (COMA expr[0])* )?  PRIGHT
;

constant :
        NUMBER
    |   ID
    |   QUOTEDSTRING
    |   boolean_const
    |   sub_id
;

sub_id :
        ID (DOT ID)? COR_LEFT QUOTEDSTRING COR_RIGHT
    |   ID DOT ID (DOT ID)*
;

boolean_const :
        TRUE
    |   FALSE
;

with :
        WITH QUOTEDSTRING #namePlatform
;