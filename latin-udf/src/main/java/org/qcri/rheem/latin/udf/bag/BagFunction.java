package org.qcri.rheem.latin.udf.bag;

import org.qcri.rheem.basic.data.Record;
import org.qcri.rheem.core.function.FunctionDescriptor;

public class BagFunction {



    public static FunctionDescriptor.SerializableFunction<Record, String> getKey(String[] structure, String key){
        int position = -1;
        for(int i = 0; i < structure.length; i++){
            if(key.compareTo(structure[i]) == 0){
                position = i;
                break;
            }
        }
        final int index = position;
        return record -> {
            return record.getString(index);
        };
    }
}
