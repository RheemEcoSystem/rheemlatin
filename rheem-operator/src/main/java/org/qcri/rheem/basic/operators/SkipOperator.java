package org.qcri.rheem.basic.operators;


import org.apache.commons.lang3.Validate;
import org.qcri.rheem.core.api.Configuration;
import org.qcri.rheem.core.optimizer.cardinality.CardinalityEstimator;
import org.qcri.rheem.core.optimizer.cardinality.FixedSizeCardinalityEstimator;
import org.qcri.rheem.core.plan.rheemplan.UnaryToUnaryOperator;
import org.qcri.rheem.core.types.DataSetType;

import java.util.Optional;

public class SkipOperator<Type> extends UnaryToUnaryOperator<Type, Type> {

    protected long skip;

    /**
     * Creates a new instance.
     *
     * @param type type of the stream elements
     */
    public SkipOperator(long skip, DataSetType<Type> type) {
        super(type, type, false);
        this.skip = skip;
    }

    /**
     * Creates a new instance.
     *
     * @param typeClass type of the stream elements
     */
    public SkipOperator(long skip, Class<Type> typeClass) {
        this(skip, DataSetType.createDefault(typeClass));
    }

    /**
     * Copies an instance (exclusive of broadcasts).
     *
     * @param that that should be copied
     */
    public SkipOperator(SkipOperator<Type> that) {
        super(that);
        this.skip = that.getSkip();
    }

    @Override
    public Optional<CardinalityEstimator> createCardinalityEstimator(
            final int outputIndex,
            final Configuration configuration) {
        Validate.inclusiveBetween(0, this.getNumOutputs() - 1, outputIndex);
        return Optional.of(new FixedSizeCardinalityEstimator(this.skip));
    }


    public long getSkip(){
        return this.skip;
    }
}