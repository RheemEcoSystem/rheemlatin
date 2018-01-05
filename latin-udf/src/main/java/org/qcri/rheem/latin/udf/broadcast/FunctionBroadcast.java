package org.qcri.rheem.latin.udf.broadcast;

import org.qcri.rheem.core.function.FunctionDescriptor;

import java.io.Serializable;
import java.util.Collection;
import java.util.function.Function;

public interface FunctionBroadcast<InputType, OutputType, BroadcastType> extends Serializable{

    public OutputType apply(InputType inputType, Collection<BroadcastType> collection);

}
