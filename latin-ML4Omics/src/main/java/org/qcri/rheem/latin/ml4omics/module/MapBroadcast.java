package org.qcri.rheem.latin.ml4omics.module;

import org.qcri.rheem.basic.data.Record;
import org.qcri.rheem.latin.core.plan.structure.bag.HeaderBag;
import org.qcri.rheem.latin.core.plan.structure.bag.RecordBag;
import org.qcri.rheem.latin.udf.broadcast.FunctionBroadcast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MapBroadcast implements FunctionBroadcast<Iterable<RecordBag>, RecordBag, RecordBag> {
    private String[] names;
    private String key;
    private String key_value;
    private HeaderBag headerBag;

    public MapBroadcast(String key, String key_value, String[] names) {
        this.key = key;
        this.key_value = key_value;
        this.names = names;
    }

    public RecordBag apply(Iterable<RecordBag> recordBags, Collection<RecordBag> collection) {
        Object[] obj = new Object[this.names.length + collection.size()];
        String[] titles = null;
        if (this.headerBag == null) {
            titles = new String[obj.length];

            for(int i = 0; i < this.names.length; ++i) {
                titles[i] = this.names[i];
            }
        }

        Iterator var11 = recordBags.iterator();

        while(var11.hasNext()) {
            RecordBag recordBag = (RecordBag)var11.next();
            int i;
            if (obj[0] == null) {
                for(i = 0; i < this.names.length; ++i) {
                    obj[i] = recordBag.getValue(this.names[i]);
                }
            }

            i = this.names.length;

            for(Iterator var8 = collection.iterator(); var8.hasNext(); ++i) {
                RecordBag vector = (RecordBag)var8.next();
                int value = 0;
                if (recordBag.getValue(this.key).compareTo(vector.getValue(this.key)) == 0) {
                    value = 1;
                }

                if (obj[i] != null) {
                    value = Math.max((Integer)obj[i], value);
                }

                obj[i] = value;
                if (this.headerBag == null) {
                    titles[i] = vector.getValue(this.key);
                }
            }
        }

        if (this.headerBag == null) {
            this.headerBag = new HeaderBag(titles);
            this.headerBag.setKeys(new String[]{"sample_name"});
            this.headerBag.setPrintable(true);
        }

        return new RecordBag(this.headerBag, new Record(obj));
    }
}
