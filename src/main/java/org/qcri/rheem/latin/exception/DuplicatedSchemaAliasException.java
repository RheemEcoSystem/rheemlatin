package org.qcri.rheem.latin.exception;

import org.antlr.runtime.IntStream;
import org.qcri.rheem.latin.util.SourceLocation;

/**
 * Created by bertty on 08-03-17.
 */
public class DuplicatedSchemaAliasException extends LatinRecognitionException {

    private static final long serialVersionUID = 1L;

    private String alias;

    public DuplicatedSchemaAliasException(IntStream input, SourceLocation loc, String alias) {
        super( input, loc );
        this.alias = alias;
    }

    public String toString() {
        return msgHeader() + "Duplicated alias in schema: " + alias;
    }

    public String getAlias() {
        return alias;
    }

}
