package org.qcri.rheem.querytest;

import org.qcri.rheem.latin.UDF.UDFClass;

/**
 * Created by bertty on 27-04-17.
 */
public class Data_Query extends UDFClass {

    private long booking_id;



    @Override
    public Object getKey() {
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return super.compareTo((UDFClass) o);
    }
}
