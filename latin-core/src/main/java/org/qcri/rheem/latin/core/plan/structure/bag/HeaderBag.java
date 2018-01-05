package org.qcri.rheem.latin.core.plan.structure.bag;

import java.util.Arrays;

public class HeaderBag {

    String[] header;

    public HeaderBag(String... header) {
        this.header = header;
    }


    public String[] getHeader() {
        return header;
    }

    public int size(){
        return this.header.length;
    }

    @Override
    public String toString() {
        return "HeaderBag{" +
                "header=" + Arrays.toString(header) +
                '}';
    }
}


