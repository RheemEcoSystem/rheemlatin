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
import org.qcri.rheem.latin.plan.operator.expression.ProjectExpression;
import org.qcri.rheem.latin.plan.operator.relational.LogicalRelationalNodesVisitor;
import org.qcri.rheem.latin.plan.operator.relational.LogicalRelationalOperator;
import org.qcri.rheem.latin.util.Pair;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LOForEach extends LogicalRelationalOperator {

    private static final long serialVersionUID = 2L;

    private LogicalPlan innerPlan;
      
    public LOForEach(OperatorPlan plan) {
        super("LOForEach", plan);		
    }

    public LogicalPlan getInnerPlan() {
        return innerPlan;
    }
    
    public void setInnerPlan(LogicalPlan p) {
        innerPlan = p;
    }
    
    @Override
    public boolean isEqual(Operator other) throws FrontendException {
        if (!(other instanceof LOForEach)) {
            return false;
        }
        
        return innerPlan.isEqual(((LOForEach)other).innerPlan);
    }
       
    @Override
    public LogicalSchema getSchema() throws FrontendException {
        List<Operator> ll = innerPlan.getSinks();
        LogicalRelationalOperator generate = null;
        // We can assume LOGenerate is the only sink of the inner plan, but
        // only after DanglingNestedNodeRemover. LOForEach.getSchema will be
        // run before DanglingNestedNodeRemover, so need to make sure we do
        // get LOGenerate
        for (Operator op : ll) {
            if (op instanceof LOGenerate) {
                generate = (LogicalRelationalOperator)op;
                break;
            }
        }
        if (generate != null) {
            schema = generate.getSchema();
        }
        
        return schema;
    }

    public void accept(PlanVisitor v) throws FrontendException {
        if (!(v instanceof LogicalRelationalNodesVisitor)) {
            throw new FrontendException("Expected LogicalPlanVisitor", 2222);
        }
        ((LogicalRelationalNodesVisitor)v).visit(this);
    }
    
    // Find the LOInnerLoad of the inner plan corresponding to the project, and 
    // also find whether there is a relational operator in inner plan along the way
    public static Pair<List<LOInnerLoad>, Boolean> findReacheableInnerLoadFromBoundaryProject(ProjectExpression project) throws FrontendException {
        boolean needNewUid = false;
        List<LOInnerLoad> innerLoads = new ArrayList<LOInnerLoad>();
        LogicalRelationalOperator referred = project.findReferent();
        Deque<Operator> stack = new LinkedList<Operator>();
        stack.add(referred);
        while( !stack.isEmpty() ) {
            Operator op = stack.pop();
            if (op instanceof LOInnerLoad) {
                innerLoads.add((LOInnerLoad)op);
            }
            else if (!(op instanceof LOGenerate)) {
                needNewUid = true;
            }
            List<Operator> ops = referred.getPlan().getPredecessors( op );
            if( ops != null ) {
                for( Operator o : ops ) {
                    stack.push( o );
                }
            }
        }
        return new Pair<List<LOInnerLoad>, Boolean>(innerLoads, needNewUid);
    }
    
    public LogicalSchema dumpNestedSchema(String alias, String nestedAlias) throws FrontendException {

        return null;
    }

}
