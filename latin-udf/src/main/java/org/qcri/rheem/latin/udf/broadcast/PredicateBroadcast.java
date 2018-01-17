package org.qcri.rheem.latin.udf.broadcast;

import java.io.Serializable;
import java.util.Collection;

public interface PredicateBroadcast<InputType, BroadcastType> extends Serializable {

    public boolean test(InputType inputType, Collection<BroadcastType> collection);


}
