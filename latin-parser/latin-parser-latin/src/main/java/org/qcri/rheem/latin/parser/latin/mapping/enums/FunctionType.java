package org.qcri.rheem.latin.parser.latin.mapping.enums;

import org.qcri.rheem.latin.parser.latin.exception.ParserLatinException;

public enum FunctionType {

    MATHEMATICAL("mathematical"),
    LOGICAL("logical"),
    OBJECT("object");

    private String text;

    FunctionType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static FunctionType find(String text) {
        for (FunctionType b : FunctionType.values()) {
            if (b.getText().equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new ParserLatinException("The " + text + " is not a valid option for" + FunctionType.class);
    }
}
