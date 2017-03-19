package org.qcri.rheem.latin.exception;

import org.qcri.rheem.latin.util.SourceLocation;

import java.io.IOException;

/**
 * Created by bertty on 09-03-17.
 */
public class ImportException extends FrontendException {

    private static final long serialVersionUID = 1L;
    private static final int errorCode = 1300;

    public ImportException(IOException ioException) {
        super( "Macro script not fount for import: " + ioException, errorCode, ioException );
    }

    public ImportException(String msg) {
        super( msg, errorCode );
    }

    public ImportException(String msg, SourceLocation location) {
        super(msg, errorCode, location);
    }

    public ImportException(String msg, Throwable cause) {
        super( msg, errorCode, cause );
    }

    @Override
    public String toString() {
        return "Failed to parse: " +  getMessage();
    }
}
