package org.qcri.rheem.latin.parser.latin.mapping.enums;

import org.qcri.rheem.latin.parser.latin.exception.ParserLatinException;

public enum ExpressionType {

    MATHEMATICAL("mathematical"),
    LOGICAL("logical");

    private String text;

    ExpressionType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static ExpressionType find(String text) {
        for (ExpressionType b : ExpressionType.values()) {
            if (b.getText().equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new ParserLatinException("The "+text+" is not a valid option for"+ ExpressionType.class);
    }
}
