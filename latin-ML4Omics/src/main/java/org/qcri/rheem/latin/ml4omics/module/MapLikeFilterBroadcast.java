package org.qcri.rheem.latin.ml4omics.module;

import org.qcri.rheem.latin.core.plan.structure.bag.RecordBag;
import org.qcri.rheem.latin.udf.broadcast.FunctionBroadcast;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MapLikeFilterBroadcast implements FunctionBroadcast<RecordBag, RecordBag, String> {
    private String key;
    private String column_name;
    private boolean validate;
    private static Set<String> set;

    public MapLikeFilterBroadcast(String key) {
        this.column_name = "gene";
        this.validate = true;
        this.key = key;
    }

    public MapLikeFilterBroadcast(String key, String column_name, boolean validate) {
        this(key);
        this.column_name = column_name;
        this.validate = validate;
    }

    public RecordBag apply(RecordBag recordBag, Collection<String> collection) {
        if (set == null) {
            set = new HashSet();
            set.addAll(collection);
        }

        if (this.validate && recordBag.getPosition(0).compareToIgnoreCase(this.column_name) == 0) {
            return recordBag;
        } else {
            return set.contains(recordBag.getValue(this.key).split("\\.")[0]) ? recordBag : null;
        }
    }
}
