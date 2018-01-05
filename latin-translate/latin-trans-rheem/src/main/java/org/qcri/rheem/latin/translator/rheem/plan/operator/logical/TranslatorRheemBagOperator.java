package org.qcri.rheem.latin.translator.rheem.plan.operator.logical;

import org.qcri.rheem.basic.data.Tuple2;
import org.qcri.rheem.latin.core.plan.LatinElement;
import org.qcri.rheem.latin.translator.rheem.plan.operator.TranslatorRheemOperator;
import org.qcri.rheem.latin.udf.normal.UDFFunction;

public class TranslatorRheemBagOperator extends TranslatorRheemOperator {
    public TranslatorRheemBagOperator(LatinElement element) {
        super(element);
    }

    @Override
    protected void selfCopy(LatinElement element) {
        super.selfCopy(element);
    }

    @Override
    public Object[] getParams() {
        Object[] obj = super.getParams();
        obj[0] =(UDFFunction) a -> {
            return new Tuple2<Integer, Integer>(1,2);
        };

        obj[1] = this.inputs.getType(0);
        obj[2] = this.outputs.getType(0);


        return obj;
    }
}
