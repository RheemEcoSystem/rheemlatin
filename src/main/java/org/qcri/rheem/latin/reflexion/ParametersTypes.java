package org.qcri.rheem.latin.reflexion;

/**
 * Created by bertty on 13-04-17.
 */
public enum ParametersTypes {
    PREDICATE( "predicate" ),
    CLASS    ( "class" ),
    FUNCTION ( "function" ),
    STRING   ( "string" );

    private final String type;

    ParametersTypes (String type){
        this.type = type;
    }



    public String getType() {
        return type;
    }
}
