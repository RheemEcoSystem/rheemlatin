package org.qcri.rheem.latin.translator.rheem.mapping;

import org.qcri.rheem.latin.translator.rheem.exception.TranslatorRheemException;

public enum ParameterType {
    PREDICATE("predicate",org.qcri.rheem.core.function.FunctionDescriptor.SerializablePredicate.class),
    FUNCTION("function", org.qcri.rheem.core.function.FunctionDescriptor.SerializableFunction.class),
    CLASS("class", Class.class),
    STRING("string", String.class),
    STRING_ARRAY("string[]",String[].class);

    private String text;
    private Class type;

    ParameterType(String text, Class type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return this.text;
    }

    public Class getType(){
        return this.type;
    }

    public static ParameterType find(String text) {
        for (ParameterType b : ParameterType.values()) {
            if (b.getText().equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new TranslatorRheemException("The "+text+" is not a valid option for"+ ParameterType.class);
    }

}
