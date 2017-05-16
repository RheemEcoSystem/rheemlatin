parser grammar MathParser;

options {
  tokenVocab=MathLexer;
}

@header {
    import java.util.*;
}


@members {
    static Map<String, Integer> precedenceMap = new HashMap<String, Integer>();
    static {
        precedenceMap.put("*", 2);
        precedenceMap.put("+", 1);
        precedenceMap.put("^", 4);
        precedenceMap.put("-", 3);
        precedenceMap.put("!", 5);
    }

    public static void addPrecedenceMap(String symbol, int code){
        precedenceMap.put(symbol, code);
    }

    public static Integer getPrecedence(Token op) {
        return precedenceMap.get(op.getText());
    }

    public static Integer getNextPrecedence(Token op) {
        Integer p = getPrecedence(op);
        if (op.getType() == PREOP)          return p;
        else if (op.getText().equals("^"))  return p;
        else if (op.getType() == BINOP)     return p+1;
        throw new IllegalArgumentException(op.getText());
    }
}

prog
    :   expr[0]
    ;


expr [int _p]
    :   atom
        (  {getPrecedence(_input.LT(1)) >= $_p}? op=BINOP expr[getNextPrecedence($op)]
        |   {getPrecedence(_input.LT(1)) >= $_p}? op=POSTOP
        )*
    ;

atom
    :   numero                                  #ExprNum
    |   PLEFT expr[0] PRIGHT                    #Parens
    |   op=PREOP expr[getNextPrecedence($op)]   #ExprPre
    ;

numero: INT;
