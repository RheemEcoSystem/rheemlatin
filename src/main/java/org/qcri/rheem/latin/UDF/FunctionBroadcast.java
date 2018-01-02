package org.qcri.rheem.latin.UDF;

import java.util.Collection;

public interface FunctionBroadcast<InputType, OutputType, BroadcastType> {

    public OutputType apply(InputType inputType, Collection<BroadcastType> collection);

}
