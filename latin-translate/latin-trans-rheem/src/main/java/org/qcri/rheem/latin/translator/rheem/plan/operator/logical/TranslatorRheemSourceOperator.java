package org.qcri.rheem.latin.translator.rheem.plan.operator.logical;

import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;
import org.qcri.rheem.latin.core.plan.operator.logical.SourceOperator;
import org.qcri.rheem.latin.translator.rheem.exception.TranslatorRheemException;
import org.qcri.rheem.latin.translator.rheem.mapping.ParameterType;
import org.qcri.rheem.latin.translator.rheem.plan.operator.TranslatorRheemOperator;

public class TranslatorRheemSourceOperator extends TranslatorRheemOperator {
    private String path_source;

    private String[] name_var;

    private String[] type_var;

    public TranslatorRheemSourceOperator(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {
        super.selfCopy(element);
        if( !(element instanceof SourceOperator)){
            throw new TranslatorRheemException(
                String.format(
                    "the class \"%s\" of the [%s]is not extension of the %s",
                    element.getClass(),
                    element,
                    LatinOperator.class
                )
            );
        }
        SourceOperator operator = (SourceOperator) element;
        this.path_source = operator.getPath_source();
        this.name_var = operator.getName_var();
        this.type_var = operator.getType_var();
    }

    @Override
    public Object[] getParams() {
        Object[] obj = super.getParams();
        int class_count = 0;
        for(int i = 0; i < params.length; i++){
            if(params[i] == ParameterType.STRING){
                obj[i] = this.path_source;
            }
            if(params[i] == ParameterType.STRING_ARRAY) {
                obj[i] = this.name_var;
            }
        }
        return obj;
    }
}
