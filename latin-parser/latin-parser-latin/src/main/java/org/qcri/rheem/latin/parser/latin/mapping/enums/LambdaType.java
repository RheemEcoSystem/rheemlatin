package org.qcri.rheem.latin.parser.latin.mapping.enums;

import org.qcri.rheem.latin.parser.latin.exception.ParserLatinException;

public enum LambdaType {

    PREDICATE("predicate"),
    FUNCTION("function"),
    CONSUMER("consumer"),
    BICONSUMER("biconsumer"),
    BIFUNCTION("bifunction"),
    BIPREDICATE("bipredicate"),
    SUPPLIER("supplier");


    private String text;

    LambdaType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static LambdaType find(String text) {
        for (LambdaType b : LambdaType.values()) {
            if (b.getText().equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new ParserLatinException("The " + text + " is not a valid option for" + LambdaType.class);
    }
}
