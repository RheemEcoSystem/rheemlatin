package org.qcri.rheem.latin.UDF;

import org.qcri.rheem.core.function.ExecutionContext;
import org.qcri.rheem.core.function.ExtendedFunction;
import org.qcri.rheem.core.function.FunctionDescriptor;

import java.util.Collection;

public class UDFunctionBroadcast<InputType, OutputType, BroadcastType> implements FunctionDescriptor.SerializableFunction<InputType, OutputType>, ExtendedFunction{

    private Collection<BroadcastType> broadcastCollection;
    private String name;
    private FunctionBroadcast<InputType, OutputType, BroadcastType> functionBroadcast;


    public UDFunctionBroadcast(String name, FunctionBroadcast<InputType, OutputType, BroadcastType> functionBroadcast){
        this.name = name;
        this.functionBroadcast = functionBroadcast;
    }

    @Override
    public void open(ExecutionContext executionContext) {
        this.broadcastCollection = executionContext.<BroadcastType>getBroadcast(this.name);
    }


    @Override
    public OutputType apply(InputType inputType) {
        return this.functionBroadcast.apply(inputType, this.broadcastCollection);
    }
}
