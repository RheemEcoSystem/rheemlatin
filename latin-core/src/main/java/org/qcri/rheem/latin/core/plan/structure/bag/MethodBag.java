package org.qcri.rheem.latin.core.plan.structure.bag;

import org.qcri.rheem.basic.data.Record;
import org.qcri.rheem.basic.data.Tuple2;
import org.qcri.rheem.core.function.FunctionDescriptor;
import org.qcri.rheem.latin.core.exception.LatinCoreException;
import org.qcri.rheem.latin.core.plan.structure.BagStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodBag {

    public static FunctionDescriptor.SerializableFunction<String, RecordBag> stringToRecord(String token, String[] header, String[] key){
        final HeaderBag headerBag = new HeaderBag(header);
        if(key != null && key.length > 0) {
            headerBag.setKeys(key);
        }
        final Pattern patter;
        if(token.length() > 1) {
            patter = Pattern.compile(token);
        }else{
            patter = null;
        }

        return line -> {
            String[] record = null;
            if(patter != null) {
                Matcher matcher = patter.matcher(line);
                ArrayList<String> list = new ArrayList<>();
                while (matcher.find()) {
                    if(matcher.group().length() > 0){
                        list.add(matcher.group());
                    }
                }
                record = list.toArray(new String[0]);
            }else {
                record = line.split(token);
                for (int i = 0; i < record.length; i++) {
                    record[i] = record[i].trim();
                }
            }
            return new RecordBag(headerBag, new Record(record));
        };
    }

    //TODO: implementar este metodo
    public static FunctionDescriptor.SerializableFunction<Tuple2<RecordBag, RecordBag>, RecordBag> mergeRecord(){
        return tuple -> {
            RecordBag bag0 = tuple.field0;
            RecordBag bag1 = tuple.field1;
            int[] index1 = bag1.getIndexKey();
            if(index1.length == bag1.size()){
                index1 = new int[0];
            }

            Record record_0 = bag0.getRecord();
            Record record_1 = bag1.getRecord();
            Object[] obj = new Object[record_0.size()+record_1.size() - index1.length];
            int index = 0;
            for(int i = 0; i < record_0.size(); i++){
                obj[index++] = record_0.getField(i);
            }
            boolean add;
            for(int i = 0; i < record_1.size(); i++){
                add = true;
                for(int j = 0; j < index1.length; j++){
                    if(index1[j] == i){
                        add = false;
                        break;
                    }
                }
                if(add) {
                    obj[index++] = record_1.getField(i);
                }
            }
            HeaderBag header = HeaderBagRepository.getNewHeader(bag0.getHeader(), bag1.getHeader());
            return new RecordBag(header, new Record(obj));
        };
    }

    public static FunctionDescriptor.SerializableFunction<RecordBag, String> getKey(String column_name){
        final String column = column_name;
        return recordBag -> {
            try {
                return recordBag.getValue(column);
            }catch (Exception e){
                System.out.println(recordBag);
                throw new LatinCoreException(e);
            }
        };
    }


    public static FunctionDescriptor.SerializableFunction<Tuple2<Long, RecordBag>, Iterable<RecordBag>> transpose_flatColumns(){
        final HeaderBag header = new HeaderBag("row_index", "column_index", "value");
        header.setKeys("row_index");
        return longRecordBagTuple2 -> {
            long row_index = longRecordBagTuple2.field0;
            RecordBag original_record = longRecordBagTuple2.field1;
            ArrayList<RecordBag> iterable = new ArrayList<>(original_record.size());
            for(int i = 0; i < original_record.size(); i++){
                Object[] obj = new Object[3];
                obj[0] = row_index;
                obj[1] = i;
                obj[2] = original_record.getField(i);
                RecordBag record = new RecordBag(header, new Record(obj));
                if(i == 0 && original_record.typeIsHeader()){
                    record.setTypeAsHeader();
                }
                iterable.add(record);
            }
            return iterable;
        };
    }


    public static FunctionDescriptor.SerializableFunction<RecordBag, Integer> transpose_getKeyGroup(){
        return recordBag -> {
            return Integer.parseInt(recordBag.getValue("column_index"));
        };
    }

    public static FunctionDescriptor.SerializableFunction<Iterable<RecordBag>, RecordBag> transpose_getTranspose(){
        return recordBags -> {
            ArrayList<RecordBag> tmp = (ArrayList<RecordBag>) recordBags;
            Collections.sort(tmp);
            int size = tmp.size();

            Object[] obj = new Object[size];

            boolean isHead = false;
            for(int i = 0; i < size; i++){
                if(i == 0 && tmp.get(i).typeIsHeader()){
                    isHead = true;
                }
                obj[i] = tmp.get(i).getField(2);
            }
            RecordBag record = new RecordBag(null, new Record(obj));
            if(isHead == true){
                record.setTypeAsHeader();
            }
            return record;
        };
    }

}
