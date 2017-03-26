parser grammar Valid2Parser;

options {
    tokenVocab=Valid2Lexer;
    backtrack=false;
    output=AST;
}

tokens
{

}

@header {
package org.qcri.rheem.latin.expression.antlr;
}
//=======================================================
//Expressions


base          : expr EOF;

expr          :  expAND  (OR_RW^ expAND)*;

expAND        :  expCons (AND_RW^ expCons)*;

expCons       :  expSum  ((EQUAL^|
                           LE_EQUAL^|
                           GR_EQUAL^|
                           NOT_EQUAL^|
                           GR^|
                           LE^) expSum)* ;

expSum        :  expProduct  ((PLUS^|
                               SUB^) expProduct)* ;

expProduct    :  expMinus ((STAR^ |
                            SLASH^|
                            MOD^ ) expMinus)* ;

expMinus      : (SUB! expNot)
              | ((PLUS!)? expNot)
              ;

expNot: (NOT_RW^)? (IDENT|NUMBER|(LEFT_PAREN! expr RIGHT_PAREN!));


//lit: REAL_LITERAL|INT_LITERAL;


