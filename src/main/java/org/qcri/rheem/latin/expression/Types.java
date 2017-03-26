package org.qcri.rheem.latin.expression;

import java.io.Serializable;

/**
 * Created by bertty on 22-03-17.
 */
interface Types extends Serializable{
    public static final int LOGICAL         = 0;
    public static final int MATHEMATICAL    = 1;
    public static final int VARIABLE        = 0;
    public static final int VALUE           = 1;
    public static final int CALCULATED      = 2;
    public static final int VARIABLELOGIC   = 3;
    public static final int VALUELOGIC      = 4;
    public static final int CALCULATEDLOGIC = 5;
    public static final int QUANTITYVARIA   = 97;

}
