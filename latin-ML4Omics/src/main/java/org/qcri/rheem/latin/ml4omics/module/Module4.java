package org.qcri.rheem.latin.ml4omics.module;

import org.qcri.rheem.basic.data.Record;
import org.qcri.rheem.core.function.FunctionDescriptor;
import org.qcri.rheem.latin.core.plan.structure.bag.HeaderBag;
import org.qcri.rheem.latin.core.plan.structure.bag.RecordBag;
import org.qcri.rheem.latin.udf.broadcast.FunctionBroadcast;

public class Module4 {

    public static FunctionDescriptor.SerializableFunction<RecordBag, RecordBag> getKeyGlioma() {
        String[] names = new String[]{"cosmic_id", "drug_id"};
        HeaderBag header = new HeaderBag(names);
        return (recordBag) -> {
            Object[] obj = new Object[names.length];

            for(int i = 0; i < names.length; ++i) {
                obj[i] = recordBag.getValue(names[i]);
            }

            return new RecordBag(header, new Record(obj));
        };
    }


    public static FunctionBroadcast<Iterable<RecordBag>, RecordBag, RecordBag> dcast() {
        String[] names = new String[]{"cell_line_name", "cosmic_id"};
        return new MapBroadcast("gene_name", "ic_50_uM", names);
    }

    public static FunctionDescriptor.SerializableFunction<RecordBag, RecordBag> getIdSample(){
        final String column = "id_sample";
        final HeaderBag header = new HeaderBag("id");
        header.setKeys("id");
        return recordBag -> {
            return new RecordBag(header, new Record(recordBag.getValue(column)));
        };
    }
}
