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


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qcri.rheem.latin.exception.FrontendException;
import org.qcri.rheem.latin.plan.Operator;
import org.qcri.rheem.latin.plan.PlanVisitor;
import org.qcri.rheem.latin.plan.logical.LogicalPlan;
import org.qcri.rheem.latin.plan.logical.LogicalSchema;
import org.qcri.rheem.latin.plan.operator.relational.LogicalRelationalNodesVisitor;
import org.qcri.rheem.latin.plan.operator.relational.LogicalRelationalOperator;
import org.qcri.rheem.latin.util.DataType;
import org.qcri.rheem.latin.util.StreamingCommand;

public class LOStream extends LogicalRelationalOperator {
    public enum CastState {INSERTED, NONEED, NOADJUST};
    private LogicalSchema scriptSchema;
    private static final long serialVersionUID = 2L;
    private static Log log = LogFactory.getLog(LOFilter.class);
    
    // the StreamingCommand object for the
    // Stream Operator this operator represents
    private StreamingCommand command;
    private LogicalSchema uidOnlySchema;
    private CastState castState = CastState.NOADJUST;
        
    public LOStream(LogicalPlan plan, StreamingCommand cmd, LogicalSchema schema) {
        super("LOStream", plan);
        command = cmd;
        scriptSchema = schema;
    }
    
    /**
     * Get the StreamingCommand object associated
     * with this operator
     * 
     * @return the StreamingCommand object
     */
    public StreamingCommand getStreamingCommand() {
        return command;
    }


    @Override
    public LogicalSchema getSchema() throws FrontendException {
        if (schema!=null)
            return schema;
        
        if (isCastAdjusted()) {
            schema = new LogicalSchema();
            for (int i=0;i<scriptSchema.size();i++) {
                LogicalSchema.LogicalFieldSchema fs = scriptSchema.getField(i).deepCopy();
                fs.type = DataType.BYTEARRAY;
                schema.addField(fs);
            }
        } else {
            if (scriptSchema!=null)
                schema = scriptSchema.deepCopy();
        }
        
        if (schema!=null)
            uidOnlySchema = schema.mergeUid(uidOnlySchema);

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
    public boolean isEqual(Operator other) throws FrontendException {
        if (other != null && other instanceof LOStream) { 
            return checkEquality((LogicalRelationalOperator)other);
        } else {
            return false;
        }
    }
    
    public void setCastState(CastState state) {
        castState = state;
    }
    
    public CastState getCastState() {
        return castState;
    }
    
    public boolean isCastAdjusted() {
        return castState!= CastState.NOADJUST;
    }

    @Override
    public void resetUid() {
        uidOnlySchema = null;
    }
    
    public LogicalSchema getScriptSchema() {
        return scriptSchema;
    }
}
