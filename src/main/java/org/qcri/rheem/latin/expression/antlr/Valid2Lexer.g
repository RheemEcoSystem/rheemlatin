lexer grammar Valid2Lexer;

@header
{
package org.qcri.rheem.latin.expression.antlr;
}


//===================================================
// Reserved words

TRUE_LITERAL  : 'TRUE'   ;
FALSE_LITERAL : 'FALSE'  ;




//===================================================
// Letters

fragment LETTER : 'a'..'z';

//===================================================
// Digits

fragment DIGIT : '0'..'9';

//===================================================
// Recognize literals and reserved words

fragment UNDERSCORE : '_';

IDENT : LETTER (LETTER|DIGIT|UNDERSCORE)*
      ;


//===================================================
// Punctuation

   SEMICOLON : ';'
             ;
   COMMA     : ','
             ;
   DOT       : '.'
             ;
   COLON     : ':'
             ;

//===================================================
// Brackets

   LEFT_PAREN    : '(' ;
   RIGHT_PAREN   : ')' ;
   LEFT_BRACE    : '{' ;
   RIGHT_BRACE   : '}' ;
   LEFT_BRACKET  : '[' ;
   RIGHT_BRACKET : ']' ;


//==================================================
// Operators

   PLUS  : '+' ;
   SUB   : '-' ;
   STAR  : '*' ;
   SLASH : '/' ;
   MOD   : '%' ;


//==================================================
// Relations

   EQUAL     : '==' ;
   NOT_EQUAL : '!=' ;
   GR_EQUAL  : '>=' ;
   LE_EQUAL  : '<=' ;
   GR        : '>'  ;
   LE        : '<'  ;
   OR_RW     : '&&' ;
   AND_RW    : '||' ;

//===================================================
// Recognize integer literals

NUMBER : (( DIGIT )+ DOT (DIGIT)+) => ( DIGIT )+ DOT (DIGIT)+
         | ( DIGIT )+
         ;


//==================================================
// White spaces

// \t : tab
// \f : form feed
// \n : newline feed
// \r : carriage return


WS :    ((' ' | '\t' | '\f')
        | ( '\n' | '\r' )
        ){ $channel = HIDDEN; }
        ;

