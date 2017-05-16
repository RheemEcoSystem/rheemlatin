package org.qcri.rheem.latin.UDF;

import java.io.Serializable;

/**
 * Created by bertty on 27-04-17.
 */
public abstract class UDFClass implements Comparable, Serializable, Cloneable{

    public int compareTo(UDFClass other) {
        return (this.getKey().equals(other.getKey()))? 0: 1;
    }

    public boolean equals(UDFClass other){
        return this.getKey().equals(other.getKey());
    }



    public abstract Object getKey();
}
