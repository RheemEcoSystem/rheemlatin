package org.qcri.rheem.latin.translator.lambda;

import org.qcri.rheem.core.function.FunctionDescriptor;

import java.util.function.Predicate;

/**
 * Created by bertty on 12-04-17.
 */
public class ObjSerializablePredicate<T> implements FunctionDescriptor.SerializablePredicate {
    @Override
    public boolean test(Object o) {
        return false;
    }

    @Override
    public Predicate and(Predicate other) {
        return null;
    }

    @Override
    public Predicate negate() {
        return null;
    }

    @Override
    public Predicate or(Predicate other) {
        return null;
    }
}
