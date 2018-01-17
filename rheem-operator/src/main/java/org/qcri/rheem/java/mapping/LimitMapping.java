package org.qcri.rheem.java.mapping;

import org.qcri.rheem.basic.operators.LimitOperator;
import org.qcri.rheem.core.mapping.*;
import org.qcri.rheem.core.types.DataSetType;
import org.qcri.rheem.java.operators.JavaLimitOperator;
import org.qcri.rheem.java.platform.JavaPlatform;

import java.util.Collection;
import java.util.Collections;

/**
 * Mapping from {@link LimitOperator} to {@link JavaLimitOperator}.
 */
public class LimitMapping implements Mapping {

    @Override
    public Collection<PlanTransformation> getTransformations() {
        return Collections.singleton(new PlanTransformation(
                this.createSubplanPattern(), this.createReplacementSubplanFactory(), JavaPlatform.getInstance()
        ));
    }

    private SubplanPattern createSubplanPattern() {
        final OperatorPattern operatorPattern = new OperatorPattern<>(
                "limit", new LimitOperator<>(0, DataSetType.none()), false
        );
        return SubplanPattern.createSingleton(operatorPattern);
    }

    private ReplacementSubplanFactory createReplacementSubplanFactory() {
        return new ReplacementSubplanFactory.OfSingleOperators<LimitOperator<?>>(
                (matchedOperator, epoch) -> new JavaLimitOperator<>(matchedOperator).at(epoch)
        );
    }
}