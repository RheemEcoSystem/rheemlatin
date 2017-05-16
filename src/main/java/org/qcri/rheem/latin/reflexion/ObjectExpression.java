package org.qcri.rheem.latin.reflexion;

/**
 * Created by bertty on 09-04-17.
 */
public class ObjectExpression implements ObjectConf {
    public static final String TYPE_CLASS_BINARY = "binary";
    public static final String TYPE_CLASS_UNARY = "unary";
    public static final String TYPE_CLASS_CONST = "const";
    private String name          = null;
    private String type          = null;
    private String real_operator = null;
    private String type_class    = null;
    private String value         = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReal_operator() {
        return real_operator;
    }

    public void setReal_operator(String real_operator) {
        this.real_operator = real_operator;
    }

    public String getType_class() {
        return type_class;
    }

    public void setType_class(String type_class) {
        this.type_class = type_class;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
