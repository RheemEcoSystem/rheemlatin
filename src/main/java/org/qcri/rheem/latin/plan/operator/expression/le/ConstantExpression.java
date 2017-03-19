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

package org.qcri.rheem.latin.plan.operator.expression.le;


import org.qcri.rheem.latin.exception.FrontendException;
import org.qcri.rheem.latin.exception.LatinException;
import org.qcri.rheem.latin.plan.Operator;
import org.qcri.rheem.latin.plan.OperatorPlan;
import org.qcri.rheem.latin.plan.PlanVisitor;
import org.qcri.rheem.latin.plan.logical.LogicalSchema;
import org.qcri.rheem.latin.plan.operator.expression.ColumnExpression;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpression;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpressionPlan;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpressionVisitor;
import org.qcri.rheem.latin.util.DataType;
import org.qcri.rheem.latin.util.SourceLocation;

/**
 * A constant
 *
 */
public class ConstantExpression extends ColumnExpression {
    
    // Stupid Java needs a union
    Object val;

    // Remember data type when the value is null
    byte type = DataType.NULL;
    /**
     * Adds expression to the plan 
     * @param plan LogicalExpressionPlan this constant is a part of.
     * @param val Value of this constant.
     */
    public ConstantExpression(OperatorPlan plan, Object val){
        super("Constant", plan);
        this.val = val;
        plan.add(this);
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

    /**
     * Get the value of this constant.
     * @return value of the constant
     */
    public Object getValue() {
        return val;
    }
    
    public void setValue(Object val) {
    	this.val = val;
    }
    

    @Override
    public boolean isEqual(Operator other) throws FrontendException {
        if (other != null && other instanceof ConstantExpression) {
            ConstantExpression co = (ConstantExpression)other;
            return co.getFieldSchema().isEqual(getFieldSchema()) && ( ( co.val == null && val == null ) 
                    || ( co != null && co.val.equals(val) ) );
        } else {
            return false;
        }
    }
    
    @Override
    public LogicalSchema.LogicalFieldSchema getFieldSchema() throws FrontendException {
        if (fieldSchema!=null)
            return fieldSchema;

        throw new FrontendException(
                    "Error determining field schema from object in constant expression",
                    1125,
                    LatinException.INPUT
            );

    }
 
    @Override
    public LogicalExpression deepCopy(LogicalExpressionPlan lgExpPlan) throws FrontendException{
        ConstantExpression copy = new ConstantExpression(lgExpPlan, this.getValue());
        copy.type = this.type;
        copy.setLocation( new SourceLocation( location ) );
        return copy;
    }
 
    public void inheritSchema(LogicalExpression expr) throws FrontendException {
        fieldSchema = expr.getFieldSchema();
        uidOnlyFieldSchema = fieldSchema.mergeUid(uidOnlyFieldSchema);
        if (fieldSchema.type != DataType.NULL) {
            type = fieldSchema.type;
        }
    }
}
