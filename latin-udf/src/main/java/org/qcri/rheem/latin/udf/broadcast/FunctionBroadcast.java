package org.qcri.rheem.latin.udf.broadcast;


import java.io.Serializable;
import java.util.Collection;

public interface FunctionBroadcast<InputType, OutputType, BroadcastType> extends Serializable{

    public OutputType apply(InputType inputType, Collection<BroadcastType> collection);

}
