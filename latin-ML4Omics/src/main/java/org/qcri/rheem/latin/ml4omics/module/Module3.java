package org.qcri.rheem.latin.ml4omics.module;

import org.qcri.rheem.basic.data.Record;
import org.qcri.rheem.core.function.FunctionDescriptor;
import org.qcri.rheem.latin.core.plan.structure.bag.HeaderBag;
import org.qcri.rheem.latin.core.plan.structure.bag.RecordBag;
import org.qcri.rheem.latin.udf.broadcast.FunctionBroadcast;

public class Module3 {

    static final int HI = 0;
    static final int LOW = 1;
    static final int AMP = 0;
    static final int DEL = 1;
    static final int CNV = 2;

    public Module3() {
    }

    public static FunctionBroadcast<RecordBag, RecordBag, String> getGeneName() {
        String key = "gene_name";
        return new MapLikeFilterBroadcast(key);
    }

    public static FunctionDescriptor.SerializablePredicate<RecordBag> removeNull() {
        return (recordBag) -> {
            return recordBag != null;
        };
    }

    public static FunctionDescriptor.SerializableFunction<RecordBag, RecordBag> firstMap() {
        return (recordBag) -> {
            Object[] value = new Object[recordBag.size() - 3];
            int start = 0;
            int middle = 4;
            int stop = recordBag.size();
            int index = 0;
            if (recordBag.getPosition(0).compareToIgnoreCase("gene") == 0) {
                start = 1;
                middle = stop;
                value[index++] = "cln";
            }

            int i;
            for(i = start; i < middle; ++i) {
                if (i != 1 && i != 2 && i != 3) {
                    value[index++] = recordBag.getPosition(i);
                }
            }

            for(i = middle; i < stop; ++i) {
                Object[][] expansion = new Object[2][3];
                String celd = recordBag.getPosition(i);
                if(celd.contains("\"")){
                    celd = celd.replace("\"", "");
                }
                String[] split = celd.split(",");

                for(int j = 0; j <= 1; ++j) {
                    try {
                        expansion[j][0] = expansion[j][1] = expansion[j][2] = Integer.parseInt(split[j]);
                        if ((Integer)expansion[j][0] == -1) {
                            expansion[j][0] = expansion[j][1] = expansion[j][2] = "NA";
                        } else {
                            expansion[j][0] = (Integer)expansion[j][0] >= 5 ? 1 : 0;
                            expansion[j][1] = (Integer)expansion[j][1] <= 1 ? 1 : 0;
                            expansion[j][2] = (Integer)expansion[j][2] - 2;
                        }
                    } catch (Exception var11) {
                        expansion[j][0] = expansion[j][1] = expansion[j][2] = "NA";
                    }
                }

                value[index++] = expansion;
            }

            return new RecordBag((HeaderBag)null, new Record(value));
        };
    }

    public static FunctionDescriptor.SerializableFunction<RecordBag, RecordBag> getHiValue() {
        return getValue("HI");
    }

    public static FunctionDescriptor.SerializableFunction<RecordBag, RecordBag> getLowValue() {
        return getValue("LOW");
    }

    public static FunctionDescriptor.SerializableFunction<RecordBag, RecordBag> getValue(String key) {
        int INDEX = key.compareToIgnoreCase("HI") == 0 ? 0 : 1;
        return (recordBag) -> {
            int max_index = recordBag.size() - 1;
            int amp_index = 1;
            int del_index = max_index + 1;
            int cnv_index = max_index * 2 + 1;
            Object[] value = new Object[max_index * 3 + 1];
            value[0] = recordBag.getPosition(0);
            int i;
            if (!(recordBag.getField(1) instanceof Object[][])) {
                for(i = 0; i < max_index; ++i) {
                    String name = recordBag.getPosition(i + 1);
                    value[amp_index + i] = name + ".amp";
                    value[del_index + i] = name + ".del";
                    value[cnv_index + i] = name + ".cnv";
                }
            } else {
                for(i = 0; i < max_index; ++i) {
                    Object[][] expansion = (Object[][])((Object[][])recordBag.getField(i + 1));
                    value[amp_index + i] = expansion[INDEX][0];
                    value[del_index + i] = expansion[INDEX][1];
                    value[cnv_index + i] = expansion[INDEX][2];
                }
            }

            return new RecordBag((HeaderBag)null, new Record(value));
        };
    }
}
