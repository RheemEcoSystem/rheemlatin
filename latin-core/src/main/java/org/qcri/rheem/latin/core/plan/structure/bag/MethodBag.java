package org.qcri.rheem.latin.core.plan.structure.bag;

import org.qcri.rheem.basic.data.Record;
import org.qcri.rheem.core.function.FunctionDescriptor;

public class MethodBag {

    public static FunctionDescriptor.SerializableFunction<String, RecordBag> stringToRecord(String token, String[] header){
        final HeaderBag headerBag = new HeaderBag(header);
        return line -> {
            Object[] record = line.split(token);
            return new RecordBag(headerBag, new Record(record));
        };
    }
}
