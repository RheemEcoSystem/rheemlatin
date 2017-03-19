package org.qcri.rheem.latin.exception;

/**
 * Created by bertty on 14-03-17.
 */
public class MappingException extends LatinException {
    private static final long serialVersionUID = 1L;
    private static final int errorCode = 1700;

    public MappingException(String msg){
        super(msg);
    }
    @Override
    public String toString() {
        return "Mapping not found: " +  getMessage();
    }
}
