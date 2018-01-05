package org.qcri.rheem.latin.core.plan.structure.bag;

import org.qcri.rheem.basic.data.Record;

public class RecordBag {

    HeaderBag header;

    Record record;

    public RecordBag(HeaderBag header, Record record) {
        this.header = header;
        this.record = record;
    }

    public HeaderBag getHeader() {
        return header;
    }

    public Record getRecord() {
        return record;
    }

    @Override
    public String toString() {
        return "RecordBag{" +
                "header=" + header +
                ", record=" + record +
                '}';
    }
}
