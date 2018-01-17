package org.qcri.rheem.latin.core.plan.structure.bag;

import org.apache.spark.status.api.v1.OneJobResource;
import org.jets3t.service.model.container.ObjectKeyAndVersion;
import org.qcri.rheem.basic.data.Record;
import org.qcri.rheem.latin.core.exception.LatinCoreException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RecordBag implements Serializable, Comparable{

    HeaderBag header;

    Record record;

    boolean type_record = false;

    public RecordBag(HeaderBag header, Record record) {
        this(header, record, false);
    }

    public RecordBag(HeaderBag header, Record record, boolean has_header){
        this.header = header;
        this.record = record;
        if(has_header && this.header != null){
            this.setTypeAsHeader();
            this.header.setHaveRecord();
        }
    }

    public HeaderBag getHeader() {
        return header;
    }

    public Record getRecord() {
        return record;
    }

    public String getPosition(int index){
        return this.record.getString(index);
    }

    public Object getField(int index){
        return this.record.getField(index);
    }

    public String getValue(String column){
        if(this.header == null){
            return record.getString(0);
        }
        return record.getString(this.header.position(column));
    }

    public void setValue(String column, Object value) {
        Object[] tmp = new Object[this.record.size()];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = this.record.getField(i);
        }
        int index = this.header.position(column);
        tmp[index] = value;
        this.record = new Record(tmp);
    }

    public void setRecord(Record record){
        this.record = record;
    }

    public void setHeader(HeaderBag header) {
        this.header = header;
    }

    public void append(Object[] element_new){
        Object[] tmp = new Object[this.record.size()+element_new.length];
        for(int i = 0; i < this.record.size(); i++){
            tmp[i] = this.record.getField(i);
        }
        System.arraycopy(element_new, 0, tmp, this.record.size(), element_new.length);

        this.record = new Record(tmp);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(100);
        if(this.header != null){
            builder.append(this.header.toString());
        }
        for(int i = 0; i < record.size() - 1; i++){
            builder.append( record.getString(i) );
            builder.append(",");
        }
        builder.append(record.getString(record.size() -1));
        return builder.toString();
    }

    private Object[] getKeyValue(){
        try {
            int[] position;
            if(this.header != null) {
                position = this.getHeader().getKeysPosition();
            }else{
                position = new int[1];
                position[0] = 0;
            }
            Object[] key_value = new Object[position.length];
            for (int i = 0; i < position.length; i++) {
                key_value[i] = this.getRecord().getField(position[i]);
            }
            return key_value;
        }catch (Exception e){
            System.out.println("explote "+this+"\n"+this.record+"\n"+this.header);
            throw new LatinCoreException(e);
        }
    }

    public int[] getIndexKey(){
        if(this.getHeader() == null){
            int[] position = new int[1];
            position[0] = 0;
            return position;
        }
        return this.getHeader().getKeysPosition();
    }

    public int sizeKey(){
        return this.getHeader().getKeySize();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordBag recordBag = (RecordBag) o;
        if(this.sizeKey() != recordBag.sizeKey()) return false;
        Object[] self_key = this.getKeyValue();
        Object[] other_key = recordBag.getKeyValue();
        for(int i = 0; i < self_key.length; i++){
            if(!self_key[i].equals(other_key[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash( getKeyValue() );
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if(this.typeIsHeader()) {
            return -1;
        }
        if (o == null || getClass() != o.getClass()) return 1;
        RecordBag recordBag = (RecordBag) o;
        if(recordBag.typeIsHeader()) {
            return 1;
        }
        Object[] self_key = this.getKeyValue();
        Object[] other_key = recordBag.getKeyValue();
        //TODO: crear de forma parametrica
        try {
            if ((long) self_key[0] < (long) (other_key[0])) return -1;
            if ((long) self_key[0] > (long) (other_key[0])) return 1;
        }catch (Exception e){
            return self_key[0].toString().compareTo(other_key[0].toString());
        }

        return 0;
    }

    public int size(){
        return this.record.size();
    }

    public void setTypeAsHeader(){
        this.type_record = true;
    }

    public boolean typeIsHeader(){
        return this.type_record;
    }

}
