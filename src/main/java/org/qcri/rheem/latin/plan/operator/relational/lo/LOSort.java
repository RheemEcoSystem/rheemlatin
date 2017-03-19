/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.qcri.rheem.latin.plan.operator.relational.lo;


import org.qcri.rheem.latin.exception.FrontendException;
import org.qcri.rheem.latin.plan.Operator;
import org.qcri.rheem.latin.plan.OperatorPlan;
import org.qcri.rheem.latin.plan.PlanVisitor;
import org.qcri.rheem.latin.plan.logical.LogicalPlan;
import org.qcri.rheem.latin.plan.logical.LogicalSchema;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpressionPlan;
import org.qcri.rheem.latin.plan.operator.expression.ProjectExpression;
import org.qcri.rheem.latin.plan.operator.relational.LogicalRelationalNodesVisitor;
import org.qcri.rheem.latin.plan.operator.relational.LogicalRelationalOperator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LOSort extends LogicalRelationalOperator {
    private List<Boolean> mAscCols;
    private boolean mIsStar = false;
    private long limit = -1;
    private List<LogicalExpressionPlan> mSortColPlans;
    
    public LOSort(OperatorPlan plan) {
        super("LOSort", plan);
    }

    public LOSort(OperatorPlan plan, List<LogicalExpressionPlan> sortColPlans,
            List<Boolean> ascCols,
            Object sortFunc ) {
        this( plan );
        mSortColPlans = sortColPlans;
        mAscCols = ascCols;
    }

    public List<LogicalExpressionPlan> getSortColPlans() {
        return mSortColPlans;
    }

    public void setSortColPlans(List<LogicalExpressionPlan> sortPlans) {
        mSortColPlans = sortPlans;
    }

    public List<Boolean> getAscendingCols() {
        return mAscCols;
    }

    public void setAscendingCols(List<Boolean> ascCols) {
        mAscCols = ascCols;
    }


    public boolean isStar() {
        return mIsStar;
    }

    public void setStar(boolean b) {
        mIsStar = b;
    }

    public void setLimit(long l)
    {
        limit = l;
    }
    
    public long getLimit()
    {
        return limit;
    }
    
    public boolean isLimited()
    {
        return (limit!=-1);
    }

    @Override
    public LogicalSchema getSchema() throws FrontendException {
        if (schema!=null)
            return schema;
        
        LogicalRelationalOperator input = null;
        input = (LogicalRelationalOperator)plan.getPredecessors(this).get(0);
        
        schema = input.getSchema();
        return schema;
    }

    @Override
    public void accept(PlanVisitor v) throws FrontendException {
        if (!(v instanceof LogicalRelationalNodesVisitor)) {
            throw new FrontendException("Expected LogicalPlanVisitor", 2223);
        }
        ((LogicalRelationalNodesVisitor)v).visit(this);
        
    }

    @Override
    public boolean isEqual(Operator operator) throws FrontendException {
        return false;
    }


    public Operator getInput(LogicalPlan plan) {
        return plan.getPredecessors(this).get(0);
    }


}
