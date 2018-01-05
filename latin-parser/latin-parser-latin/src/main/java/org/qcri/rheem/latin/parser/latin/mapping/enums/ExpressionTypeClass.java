package org.qcri.rheem.latin.parser.latin.mapping.enums;

import org.qcri.rheem.latin.parser.latin.exception.ParserLatinException;

public enum ExpressionTypeClass {


    BINARY("binary"),
    UNARY("unary"),
    POSTUNARY("post_unary");


    private String text;

    ExpressionTypeClass(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static ExpressionTypeClass find(String text) {
        for (ExpressionTypeClass b : ExpressionTypeClass.values()) {
            if (b.getText().equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new ParserLatinException("The "+text+" is not a valid option for"+ ExpressionTypeClass.class);
    }
}
