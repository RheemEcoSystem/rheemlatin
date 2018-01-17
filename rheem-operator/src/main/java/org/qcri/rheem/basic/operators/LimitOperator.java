package org.qcri.rheem.basic.operators;


import org.apache.commons.lang3.Validate;
import org.qcri.rheem.core.api.Configuration;
import org.qcri.rheem.core.optimizer.cardinality.CardinalityEstimator;
import org.qcri.rheem.core.optimizer.cardinality.FixedSizeCardinalityEstimator;
import org.qcri.rheem.core.plan.rheemplan.UnaryToUnaryOperator;
import org.qcri.rheem.core.types.DataSetType;

import java.util.Optional;

public class LimitOperator<Type> extends UnaryToUnaryOperator<Type, Type> {

    protected long limit;

    /**
     * Creates a new instance.
     *
     * @param type type of the stream elements
     */
    public LimitOperator(long limit, DataSetType<Type> type) {
        super(type, type, false);
        this.limit = limit;
    }

    /**
     * Creates a new instance.
     *
     * @param typeClass type of the stream elements
     */
    public LimitOperator(long limit, Class<Type> typeClass) {
        this(limit, DataSetType.createDefault(typeClass));
    }

    /**
     * Copies an instance (exclusive of broadcasts).
     *
     * @param that that should be copied
     */
    public LimitOperator(LimitOperator<Type> that) {
        super(that);
        this.limit = that.getLimit();
    }

    @Override
    public Optional<CardinalityEstimator> createCardinalityEstimator(
            final int outputIndex,
            final Configuration configuration) {
        Validate.inclusiveBetween(0, this.getNumOutputs() - 1, outputIndex);
        return Optional.of(new FixedSizeCardinalityEstimator(this.limit));
    }


    public long getLimit(){
        return this.limit;
    }
}