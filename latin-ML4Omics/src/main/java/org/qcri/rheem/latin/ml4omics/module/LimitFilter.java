package org.qcri.rheem.latin.ml4omics.module;

import org.qcri.rheem.core.function.FunctionDescriptor;

public class LimitFilter<InputType> implements FunctionDescriptor.SerializablePredicate<InputType> {
    int check = 0;
    final int top;

    public LimitFilter(int top) {
        this.top = top;
    }

    public boolean test(InputType inputType) {
        return this.check++ < this.top;
    }
}
