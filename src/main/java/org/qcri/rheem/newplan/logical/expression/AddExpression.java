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

package org.qcri.rheem.newplan.logical.expression;

import org.qcri.rheem.util.FrontendException;
import org.qcri.rheem.newplan.Operator;
import org.qcri.rheem.newplan.OperatorPlan;
import org.qcri.rheem.newplan.PlanVisitor;
import org.qcri.rheem.newplan.logical.relational.LogicalSchema;
import org.qcri.rheem.util.SourceLocation;

/**
 * Add Operator
 */
public class AddExpression extends BinaryExpression {

    /**
     * Will add this operator to the plan and connect it to the 
     * left and right hand side operators.
     * @param plan plan this operator is part of
     * @param lhs expression on its left hand side
     * @param rhs expression on its right hand side
     */
    public AddExpression(OperatorPlan plan,
                         LogicalExpression lhs,
                         LogicalExpression rhs) {
        super("Add", plan, lhs, rhs);
    }

    /**
     * @link org.apache.pig.newplan.Operator#accept(org.apache.pig.newplan.PlanVisitor)
     */
    @Override
    public void accept(PlanVisitor v) throws FrontendException {
        if (!(v instanceof LogicalExpressionVisitor)) {
            throw new FrontendException("Expected LogicalExpressionVisitor", 2222);
        }
        ((LogicalExpressionVisitor)v).visit(this);
    }
    
    @Override
    public boolean isEqual(Operator other) throws FrontendException {
        if (other != null && other instanceof AddExpression) {
            AddExpression ao = (AddExpression)other;
            return ao.getLhs().isEqual(getLhs()) && ao.getRhs().isEqual(getRhs());
        } else {
            return false;
        }
    }
    
    @Override
    public LogicalSchema.LogicalFieldSchema getFieldSchema() throws FrontendException {
        if (fieldSchema!=null)
            return fieldSchema;
        fieldSchema = new LogicalSchema.LogicalFieldSchema(null, null, getLhs().getType());
        uidOnlyFieldSchema = fieldSchema.mergeUid(uidOnlyFieldSchema);
        return fieldSchema;
    }

    @Override
    public LogicalExpression deepCopy(LogicalExpressionPlan lgExpPlan) throws FrontendException {
        LogicalExpression copy = new AddExpression(
                (OperatorPlan) lgExpPlan,
                this.getLhs().deepCopy(lgExpPlan),
                this.getRhs().deepCopy(lgExpPlan) );
        copy.setLocation( new SourceLocation( location ) );
        return copy;
    }
}
