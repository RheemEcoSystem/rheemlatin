package org.qcri.rheem.latin.core.plan.structure.bag;

import javax.ws.rs.HEAD;
import java.util.Arrays;

public class HeaderBag {

    public static final HeaderBag header_null = new HeaderBag("null");

    String[] header;

    String[] keys;

    boolean printable = false;

    boolean haveRecord = false;

    public HeaderBag(String... header) {
        this.header = header;
        this.keys = this.header;
    }

    public HeaderBag(HeaderBag first, HeaderBag second){
        if(first == null){
            first = HeaderBag.header_null;
        }
        if(second == null){
            second = HeaderBag.header_null;
        }
        this.header = new String[first.size() + second.size()];

        System.arraycopy(first.header, 0, this.header, 0, first.size());
        System.arraycopy(second.header, 0, this.header, first.size(), second.size());
    }

    public String[] getHeader() {
        return header;
    }

    public int size(){
        return this.header.length;
    }

    public int position(String name){
        for(int i =0; i < header.length; i++){
            if(name.equals(header[i])){
                return i;
            }
        }
        return -1;
    }

    public String[] getKeys(){
        return this.keys;
    }

    public void setKeys(String... keys){
        if(this.keys != keys) {
            this.keys = keys;
        }
    }

    public int getKeySize(){
        return this.keys.length;
    }

    public int[] getKeysPosition(){
        int[] positions = {0};
        if(this.keys != null){
            positions = new int[this.keys.length];
            for (int i = 0; i < positions.length; i++) {
                for (int j = 0; j < this.header.length; j++) {
                    if (this.keys[i].compareTo(this.header[j]) == 0) {
                        positions[i] = j;
                        break;
                    }
                }
            }
        }
        return positions;
    }

    @Override
    public String toString() {
        if(!printable){
            return "";
        }
        this.printable = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.header.length -1; i++){
            sb.append(this.header[i]);
            sb.append(",");
        }
        sb.append(this.header[this.header.length - 1]);
        sb.append("\n");
        return sb.toString();
    }

    public void setPrintable(boolean printable){
        this.printable = printable;
    }

    public void setHaveRecord(){
        this.haveRecord = true;
    }
}


