package org.qcri.rheem.latin.UDF;

import org.qcri.rheem.core.function.FunctionDescriptor;

import java.util.Collection;

public interface FunctionBroadcast<InputType, OutputType, BroadcastType> extends FunctionDescriptor.ExtendedSerializableFunction<InputType, OutputType> {

    public OutputType apply(InputType inputType, Collection<BroadcastType> collection);

}
