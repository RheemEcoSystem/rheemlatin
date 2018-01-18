package org.qcri.rheem.latin.ml4omics.module;

import org.qcri.rheem.basic.data.Record;
import org.qcri.rheem.core.function.FunctionDescriptor;
import org.qcri.rheem.latin.core.plan.structure.bag.HeaderBag;
import org.qcri.rheem.latin.core.plan.structure.bag.RecordBag;
import org.qcri.rheem.latin.udf.broadcast.FunctionBroadcast;

public class Module2 {

    public static FunctionDescriptor.SerializableFunction<String, RecordBag> loadRecord() {
        return new LoadRecordSpecial();
    }

    public static FunctionDescriptor.SerializablePredicate<RecordBag> filterNull() {
        return (recordBag) -> {
            return recordBag != null;
        };
    }

    public static FunctionDescriptor.SerializableFunction<RecordBag, RecordBag> gsubAndToupper() {
        String column = "cell_line_name";
        String[] columns = new String[]{"cell_line_name", "cosmic_id"};
        HeaderBag header = new HeaderBag(columns);
        header.setKeys(new String[]{"cell_line_name"});
        return (recordBag) -> {
            String previous = recordBag.getValue("cell_line_name");
            previous = previous.replaceAll("-", "");
            previous = previous.toUpperCase();
            Object[] obj = new Object[]{previous, recordBag.getValue("cosmic_id")};
            RecordBag record = new RecordBag(header, new Record(obj));
            if (recordBag.typeIsHeader()) {
                record.setTypeAsHeader();
            }

            return record;
        };
    }

    public static FunctionBroadcast<RecordBag, RecordBag, String> getGeneName() {
        String key = "cell_line_name";
        /*SE TIENE QUE REHCER*/
        return new MapLikeFilterBroadcast(key, (String)null, false);
    }


}
