package org.qcri.rheem.latin.translator.lambda;

import org.qcri.rheem.core.function.FunctionDescriptor;

import java.util.function.Predicate;

/**
 * Created by bertty on 12-04-17.
 */
public class TESTSP<T>  implements FunctionDescriptor.SerializablePredicate<T>{

    Predicate tmp = null;

    public TESTSP(Predicate tmp){
        this.tmp = tmp;
    }

    @Override
    public boolean test(T t) {
        return tmp.test(t);
    }

    @Override
    public Predicate<T> and(Predicate<? super T> other) {
        return null;
    }

    @Override
    public Predicate<T> negate() {
        return a -> ! tmp.test(a);
    }

    @Override
    public Predicate<T> or(Predicate<? super T> other) {
        return null;
    }
}
