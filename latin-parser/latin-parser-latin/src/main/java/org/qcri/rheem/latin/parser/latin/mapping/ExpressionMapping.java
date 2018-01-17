package org.qcri.rheem.latin.parser.latin.mapping;

import org.qcri.rheem.latin.parser.latin.mapping.enums.ExpressionType;
import org.qcri.rheem.latin.parser.latin.mapping.enums.ExpressionTypeClass;

public class ExpressionMapping implements MappingFinal {
    private String name;
    private ExpressionType type;
    private String real_operator;
    private ExpressionTypeClass type_class;

    public ExpressionMapping(String name, ExpressionType type, String real_operator, ExpressionTypeClass type_class) {
        this.name = name;
        this.type = type;
        this.real_operator = real_operator;
        this.type_class = type_class;
    }

    public String getName() {
        return name;
    }

    public ExpressionType getType() {
        return type;
    }

    public String getReal_operator() {
        return real_operator;
    }

    public ExpressionTypeClass getType_class() {
        return type_class;
    }

    @Override
    public Object clone() {
        return new ExpressionMapping(
            this.name,
            this.type,
            this.real_operator,
            this.type_class
        );
    }
}
