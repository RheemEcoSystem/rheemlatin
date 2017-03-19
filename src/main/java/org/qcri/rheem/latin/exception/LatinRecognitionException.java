package org.qcri.rheem.latin.exception;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.IntStream;
import org.qcri.rheem.latin.util.SourceLocation;

/**
 * Subclass of Antlr RecognitionException which should be the parent class of all parser related
 * exception classes. We need this layer because of the line number problem in tree parser in
 * Antlr-3.2. You will need a token where the exception occurs in order to instantiate an instance
 * of this class.
 *
 */
public class LatinRecognitionException extends RecognitionException {
    private static final long serialVersionUID = 1L;

    private SourceLocation location;

    public LatinRecognitionException(IntStream input, SourceLocation loc) {
        super( );
        this.line = loc.line();
        this.charPositionInLine = loc.offset();
        this.location = loc;
    }

    protected String msgHeader() {
        return location.toString();
    }
}
