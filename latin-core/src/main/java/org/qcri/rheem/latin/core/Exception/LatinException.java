package org.qcri.rheem.latin.core.Exception;

public class LatinException extends RuntimeException{

    public LatinException() {
    }

    public LatinException(String message) {
        super(message);
    }

    public LatinException(String message, Throwable cause) {
        super(message, cause);
    }

    public LatinException(Throwable cause) {
        super(cause);
    }

    public LatinException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
