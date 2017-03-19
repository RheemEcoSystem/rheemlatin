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
import org.qcri.rheem.latin.util.DataType;
import org.qcri.rheem.latin.util.SourceLocation;

import java.util.Map;

/**
 * Operator to map the data into the inner plan of LOForEach
 * It can only be used in the inner plan of LOForEach
 *
 */
public class LOInnerLoad extends LogicalRelationalOperator {
    private ProjectExpression prj;
    private LOForEach foreach;
    private boolean sourceIsBag = false;

    public LOInnerLoad(OperatorPlan plan, LOForEach foreach, int colNum) {
        super("LOInnerLoad", plan);        
        
        // store column number as a ProjectExpression in a plan 
        // to be able to dynamically adjust column number during optimization
        LogicalExpressionPlan exp = new LogicalExpressionPlan();
        
        // we don't care about type, so set to -1
        prj = new ProjectExpression(exp, 0, colNum, foreach);
        this.foreach = foreach;
    }

    public LOInnerLoad(OperatorPlan plan, LOForEach foreach, String colAlias)
    throws FrontendException {
        super("LOInnerLoad", plan); 
        
        // store column number as a ProjectExpression in a plan 
        // to be able to dynamically adjust column number during optimization
        LogicalExpressionPlan exp = new LogicalExpressionPlan();
        
        this.prj = new ProjectExpression( exp, 0, colAlias, null, foreach );
        this.foreach = foreach;
    }

    public LOInnerLoad(LogicalPlan plan, LOForEach foreach,
                       ProjectExpression projectExpression) {
        super("LOInnerLoad", plan); 
        this.prj = projectExpression;
        this.prj.setInputNum(0);
        this.prj.setAttachedRelationalOp(foreach);
        this.foreach = foreach;
    }

    @Override
    public LogicalSchema getSchema() throws FrontendException {
        if (schema!=null)
            return schema;
        
        if (prj.findReferent().getSchema()!=null && prj.getFieldSchema()!=null) {
            if (prj.getFieldSchema().type== DataType.BAG) {
                sourceIsBag = true;
                alias = prj.getFieldSchema().alias;
                if (prj.getFieldSchema().schema!=null) {
                    LogicalSchema.LogicalFieldSchema tupleSchema = prj.getFieldSchema().schema.getField(0);
                    if (tupleSchema!=null && tupleSchema.schema!=null) {
                        schema = new LogicalSchema();
                        for (int i=0;i<tupleSchema.schema.size();i++)
                            schema.addField(tupleSchema.schema.getField(i));
                    }
                }
            }
            else {
                schema = new LogicalSchema();
                schema.addField(prj.getFieldSchema());
            }
        } else if (!prj.isRangeOrStarProject()) {
            schema = new LogicalSchema();
            schema.addField(new LogicalSchema.LogicalFieldSchema(null, null, DataType.BYTEARRAY));
        }
        return schema;
    }
    
    @Override
    public void resetSchema(){
        super.resetSchema();
        prj.resetFieldSchema();
    }
    
    public ProjectExpression getProjection() {
        return prj;
    }

    @Override
    public boolean isEqual(Operator other) throws FrontendException {
        if (!(other instanceof LOInnerLoad)) {
            return false;
        }
        
        return (getColNum() == ((LOInnerLoad)other).getColNum());
    }    

    public void accept(PlanVisitor v) throws FrontendException {
         if (!(v instanceof LogicalRelationalNodesVisitor)) {
             throw new FrontendException("Expected LogicalPlanVisitor", 2223);
         }
         ((LogicalRelationalNodesVisitor)v).visit(this);
    }

    public int getColNum() {
        return prj.getColNum();
    }
    
    /**
     * Get the LOForEach operator that contains this operator as part of inner plan
     * @return the LOForEach operator
     */
    public LOForEach getLOForEach() {
        return foreach;
    }
    
    public boolean sourceIsBag() {
        return sourceIsBag;
    }
    
    public String toString() {
        StringBuilder msg = new StringBuilder();

        if (alias!=null) {
            msg.append(alias + ": ");
        }
        msg.append("(Name: " + name);
        msg.append("[");
        if( getProjection().getColAlias() != null )
            msg.append( getProjection().getColAlias() );
        else if (getProjection().isProjectStar())
            msg.append("*");
        else if (getProjection().isRangeProject())
            msg.append(getProjection().getStartCol())
            .append(" .. ")
            .append(getProjection().getEndCol());
        else
            msg.append(getProjection().getColNum());
        msg.append("]");
        msg.append(" Schema: ");
        if (schema!=null)
            msg.append(schema);
        else
            msg.append("null");
        msg.append(")");
        if (annotations!=null) {
            for (Map.Entry<String, Object> entry : annotations.entrySet()) {
                msg.append(entry);
            }
        }
        return msg.toString();
    }
    
    @Override
    public void setLocation(SourceLocation loc) {
    	super.setLocation( loc );
    	prj.setLocation( loc );
    }
}
