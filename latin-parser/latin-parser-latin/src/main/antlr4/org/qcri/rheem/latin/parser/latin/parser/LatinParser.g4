parser grammar LatinParser;

options {
  tokenVocab=LatinLexer;
}

@header {
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
    (
        statement
    |   class_define
    |   bag_set_param
    |   include_statement
    )*
;

statement :
        ID ASSING
           (    operator_statement
             |  source_statement
           ) with_platform? SEMI_COLON               #BaseStatement
   |   sink_statement with_platform? SEMI_COLON      #SinkStatement
   |   ID ASSING bag_stattement SEMI_COLON           #BagStatement

;

operator_statement :
        name=OPERATOR_NAME (lambda)? (COMA lambda)* with_broadcast? #OperatorStatement
;

lambda :
        ID type?
    |   ID ARROW ACCO_LEFT expr[0] ACCO_RIGHT type?
    |   expr[0]
    |   real_function
;

real_function :
    ID ARROW ID DOT ID PLEFT PRIGHT type ?
;

type :
        COLON (BOOLEAN|INT|LONG|FLOAT|BIGDECIMAL|BIGINTEGER|DOUBLE|DATETIME|STRING|ID)
;

source_statement :
        LOAD QUOTEDSTRING as_clause?
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

with_platform :
        WITH PLATFORM QUOTEDSTRING #namePlatform
;

with_broadcast :
        WITH BROADCAST ID
;

bag_stattement :
    BAG PLEFT bag_header? PRIGHT ARROW_I ID
;

bag_header :
     bag_header_titles ( COMA bag_header_params )*
    | bag_header_params ( COMA bag_header_params )*
;

bag_header_titles :
    COR_LEFT ( bag_header_element (COMA bag_header_element)* ) COR_RIGHT
;

bag_header_element :
    QUOTEDSTRING (type)?
;

bag_header_params:
    ID ASSING constant
;

bag_set_param :
    ID DOT ID ARROW_I (constant | bag_header_titles) SEMI_COLON
;

class_define :
    IMPORT QUOTEDSTRING AS ID SEMI_COLON #ClassDefine
;

include_statement :
    ID ASSING INCLUDE QUOTEDSTRING PLEFT ID+ PRIGHT SEMI_COLON
;