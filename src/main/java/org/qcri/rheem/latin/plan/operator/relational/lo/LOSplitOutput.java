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
import org.qcri.rheem.latin.plan.PlanVisitor;
import org.qcri.rheem.latin.plan.logical.LogicalPlan;
import org.qcri.rheem.latin.plan.logical.LogicalSchema;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpression;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpressionPlan;
import org.qcri.rheem.latin.plan.operator.relational.LogicalRelationalNodesVisitor;
import org.qcri.rheem.latin.plan.operator.relational.LogicalRelationalOperator;
import org.qcri.rheem.latin.util.DataType;

import java.util.HashMap;
import java.util.Map;

public class LOSplitOutput extends LogicalRelationalOperator {
    private LogicalExpressionPlan filterPlan;
    private Map<Long, Long> uidMapping = new HashMap<Long, Long>();
    public LOSplitOutput(LogicalPlan plan) {
        super("LOSplitOutput", plan);       
    }
    
    public LOSplitOutput(LogicalPlan plan, LogicalExpressionPlan filterPlan) {
        super("LOSplitOutput", plan);
        this.filterPlan = filterPlan;
    }
    
    public LogicalExpressionPlan getFilterPlan() {
        return filterPlan;
    }
    
    public void setFilterPlan(LogicalExpressionPlan filterPlan) {
        this.filterPlan = filterPlan;
    }
    
    private void reassignUidRec(LogicalSchema schema) {
        for (LogicalSchema.LogicalFieldSchema fs : schema.getFields()) {
            /* If one of the field contains a nested schema, we need to reassign Uids on the nested fields too */
            if (fs.schema != null && (fs.type == DataType.TUPLE || fs.type == DataType.BAG || fs.type == DataType.MAP)) {
                reassignUidRec(fs.schema);
            }
            if (uidMapping.containsKey(fs.uid)) {
                fs.uid = uidMapping.get(fs.uid);
            }
            else {
                long predUid = fs.uid;
                fs.uid = LogicalExpression.getNextUid();
                uidMapping.put(predUid, fs.uid);
            }
        }
    }
    
    @Override
    public LogicalSchema getSchema() throws FrontendException {
        if (schema!=null)
            return schema;
        
        LogicalRelationalOperator input = null;
        input = (LogicalRelationalOperator)plan.getPredecessors(this).get(0);
        
        if (input.getSchema()!=null) {
            schema = input.getSchema().deepCopy();
            reassignUidRec(schema);
        }
        return schema;
    }   

    public void accept(PlanVisitor v) throws FrontendException {
        if (!(v instanceof LogicalRelationalNodesVisitor)) {
            throw new FrontendException("Expected LogicalPlanVisitor", 2223);
        }
        ((LogicalRelationalNodesVisitor)v).visit(this);
    }
    
    @Override
    public boolean isEqual(Operator other) throws FrontendException {
        if (other != null && other instanceof LOSplitOutput) { 
            LOSplitOutput os = (LOSplitOutput)other;
            return filterPlan.isEqual(os.filterPlan) && checkEquality(os);
        } else {
            return false;
        }
    }
    
    @Override
    public void resetUid() {
        uidMapping = new HashMap<Long, Long>();
    }
    
    public long getInputUids(long uid) {
        for (Map.Entry<Long, Long> pair : uidMapping.entrySet()) {
            if (pair.getValue()==uid)
                return pair.getKey();
        }
        return -1;
    }
}
