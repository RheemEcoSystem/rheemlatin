package org.qcri.rheem.latin.core.plan.structure.bag;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.List;
import java.util.Map;

public class HeaderBagRepository {

    private static Table<HeaderBag, HeaderBag, HeaderBag> TABLE = HashBasedTable.create();



    public static HeaderBag getNewHeader(HeaderBag first, HeaderBag second){
        if(first == null){
            first = HeaderBag.header_null;
        }
        if(second == null){
            second = HeaderBag.header_null;
        }
        HeaderBag header_new = TABLE.get(first, second);
        if( header_new == null ){
            header_new = new HeaderBag(first, second);
            TABLE.put(first, second, header_new);
        }
        return header_new;
    }


}
