package org.qcri.rheem.latin.ml4omics.module;

import org.qcri.rheem.basic.data.Record;
import org.qcri.rheem.core.function.FunctionDescriptor;
import org.qcri.rheem.latin.core.plan.structure.bag.HeaderBag;
import org.qcri.rheem.latin.core.plan.structure.bag.RecordBag;

import java.util.ArrayList;

public class LoadRecordSpecial implements FunctionDescriptor.SerializableFunction<String, RecordBag> {
    private Integer[] position;
    private HeaderBag header;
    private int size_expected;

    public LoadRecordSpecial() {
    }

    public RecordBag apply(String line) {
        String[] split = line.split(",");
        if (this.position == null) {
            this.getPosition(split);
        }

        if (this.header == null) {
            RecordBag record = new RecordBag(this.header, new Record(this.getHeader(split)));
            record.setTypeAsHeader();
            return record;
        } else if (split != null && split.length == this.size_expected) {
            Object[] obj = new Object[this.position.length];

            for(int i = 0; i < this.position.length; ++i) {
                int index = this.position[i];
                if (split[index].length() == 0) {
                    return null;
                }

                obj[i] = split[index];
            }

            return new RecordBag(this.header, new Record(obj));
        } else {
            return null;
        }
    }

    private void getPosition(String[] split) {
        ArrayList<Integer> tmp = new ArrayList(split.length);
        this.size_expected = split.length;

        for(int i = 0; i < split.length; ++i) {
            if (split[i].length() != 0 && split[i].compareToIgnoreCase("also") != 0 && i != 1) {
                tmp.add(i);
            }
        }

        this.position = (Integer[])tmp.toArray(new Integer[0]);
    }

    private Object[] getHeader(String[] split) {
        String[] names = new String[this.position.length];

        for(int i = 0; i < this.position.length; ++i) {
            int index = this.position[i];
            if (index == 0) {
                names[i] = "cell_line";
            } else {
                String value = split[index];
                if (value.contains("_")) {
                    value = value.split("_")[0];
                }

                names[i] = value;
            }
        }

        this.header = new HeaderBag(names);
        this.header.setKeys(new String[]{"cell_line"});
        return names;
    }
}
