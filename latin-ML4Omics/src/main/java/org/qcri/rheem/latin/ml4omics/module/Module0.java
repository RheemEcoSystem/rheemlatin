package org.qcri.rheem.latin.ml4omics.module;

import org.qcri.rheem.basic.data.Record;
import org.qcri.rheem.core.function.FunctionDescriptor;
import org.qcri.rheem.latin.core.plan.structure.bag.HeaderBag;
import org.qcri.rheem.latin.core.plan.structure.bag.RecordBag;

public class Module0 {
    public static FunctionDescriptor.SerializableFunction<RecordBag, RecordBag> expPlusColumn() {
        String[] selection = new String[]{"cell_line_name", "cosmic_id", "histology", "tissue", "drug_name", "drug_id", "ln_ic50", "auc"};
        HeaderBag header = new HeaderBag(new String[]{"cell_line_name", "cosmic_id", "histology", "tissue", "drug_name", "drug_id", "ln_ic50", "auc", "ic_50_uM"});
        header.setPrintable(true);
        return (recordBag) -> {
            Object[] objects = new Object[selection.length + 1];

            for(int i = 0; i < selection.length; ++i) {
                objects[i] = recordBag.getValue(selection[i]);
            }

            objects[selection.length] = Double.parseDouble(recordBag.getValue("ln_ic50"));
            objects[selection.length] = Math.exp((Double)objects[selection.length]);
            return new RecordBag(header, new Record(objects));
        };
    }
}
