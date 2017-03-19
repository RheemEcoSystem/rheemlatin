/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.qcri.rheem.latin.util;


import org.qcri.rheem.latin.exception.FrontendException;
import org.qcri.rheem.latin.exception.LatinException;
import org.qcri.rheem.latin.exception.PlanValidationException;
import org.qcri.rheem.latin.plan.DependencyOrderWalker;
import org.qcri.rheem.latin.plan.OperatorPlan;
import org.qcri.rheem.latin.plan.PlanWalker;
import org.qcri.rheem.latin.plan.ReverseDependencyOrderWalker;
import org.qcri.rheem.latin.plan.logical.LogicalSchema;
import org.qcri.rheem.latin.plan.operator.expression.AllSameExpressionVisitor;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpression;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpressionPlan;
import org.qcri.rheem.latin.plan.operator.relational.LogicalRelationalNodesVisitor;
import org.qcri.rheem.latin.plan.operator.relational.lo.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SchemaResetter extends LogicalRelationalNodesVisitor {

    // uid duplicates are removed only after optimizer rule 
    // DuplicateForEachColumnRewrite has run. So disable it in calls before that
    boolean skipDuplicateUidCheck = true;
    
    private void visitAll(Collection<LogicalExpressionPlan> lexpPlans) throws FrontendException {
	for (LogicalExpressionPlan expPlan : lexpPlans) {
	    FieldSchemaResetter fsResetter = new FieldSchemaResetter(expPlan);
	    fsResetter.visit();
	}
    }
    
    public SchemaResetter(OperatorPlan plan) throws FrontendException {
        this(plan, false);
    }

    public SchemaResetter(OperatorPlan plan, boolean skipDuplicateUidCheck) 
            throws FrontendException {
        super(plan, new DependencyOrderWalker(plan));
        this.skipDuplicateUidCheck = skipDuplicateUidCheck;
    }

    @Override
    public void visit(LOLoad load) throws FrontendException {
        load.resetSchema();
        validate(load.getSchema());
    }

    @Override
    public void visit(LOFilter filter) throws FrontendException {
        filter.resetSchema();
        FieldSchemaResetter fsResetter = new FieldSchemaResetter(filter.getFilterPlan());
        fsResetter.visit();
        validate(filter.getSchema());
    }
    
    @Override
    public void visit(LOStore store) throws FrontendException {
        store.resetSchema();
        validate(store.getSchema());
    }
    
    @Override
    public void visit(LOJoin join) throws FrontendException {
        join.resetSchema();
        visitAll(join.getExpressionPlanValues());
        validate(join.getSchema());
    }
    
    @Override
    public void visit(LOForEach foreach) throws FrontendException {
        foreach.resetSchema();
        OperatorPlan innerPlan = foreach.getInnerPlan();
        PlanWalker newWalker = currentWalker.spawnChildWalker(innerPlan);
        pushWalker(newWalker);
        currentWalker.walk(this);
        popWalker();
        validate(foreach.getSchema());
    }
    
    @Override
    public void visit(LOGenerate gen) throws FrontendException {
        gen.resetSchema();
        visitAll(gen.getOutputPlans());
        validate(gen.getSchema());
    }
    
    @Override
    public void visit(LOInnerLoad load) throws FrontendException {
        load.resetSchema();
        load.getProjection().resetFieldSchema();
        load.getSchema();
    }

    @Override
    public void visit(LOCube loCube) throws FrontendException {
	loCube.resetSchema();
	visitAll(loCube.getExpressionPlans().values());
	validate(loCube.getSchema());
    }
    
    @Override
    public void visit(LOCogroup loCogroup) throws FrontendException {
        loCogroup.resetSchema();
        visitAll(loCogroup.getExpressionPlans().values());
        validate(loCogroup.getSchema());
    }
    
    @Override
    public void visit(LOSplit loSplit) throws FrontendException {
        loSplit.resetSchema();
        validate(loSplit.getSchema());
    }
    
    @Override
    public void visit(LOSplitOutput loSplitOutput) throws FrontendException {
        loSplitOutput.resetSchema();
        FieldSchemaResetter fsResetter = new FieldSchemaResetter(loSplitOutput.getFilterPlan());
        fsResetter.visit();
        validate(loSplitOutput.getSchema());
    }
    
    @Override
    public void visit(LOUnion loUnion) throws FrontendException {
        loUnion.resetSchema();
        validate(loUnion.getSchema());
    }
    
    @Override
    public void visit(LOSort loSort) throws FrontendException {
        loSort.resetSchema();
        visitAll(loSort.getSortColPlans());
        validate(loSort.getSchema());
    }

    @Override
    public void visit(LORank loRank) throws FrontendException{
        loRank.resetSchema();
        visitAll(loRank.getRankColPlans());
        validate(loRank.getSchema());
    }

    @Override
    public void visit(LODistinct loDistinct) throws FrontendException {
        loDistinct.resetSchema();
        validate(loDistinct.getSchema());
    }

    @Override
    public void visit(LOLimit loLimit) throws FrontendException {
        loLimit.resetSchema();
        if (loLimit.getLimitPlan() != null) {
            FieldSchemaResetter fsResetter = new FieldSchemaResetter(
                    loLimit.getLimitPlan());
            fsResetter.visit();
        }
        validate(loLimit.getSchema());
    }
    
    @Override
    public void visit(LOCross loCross) throws FrontendException {
        loCross.resetSchema();
        validate(loCross.getSchema());
    }
    
    @Override
    public void visit(LOStream loStream) throws FrontendException {
        loStream.resetSchema();
        validate(loStream.getSchema());
    }


    /**
     * Check if schema is valid (ready to be part of a final logical plan)
     * @param schema
     * @throws PlanValidationException if the if any field in schema has uid -1
     * or (skipDuplicateUidCheck is true and there are duplicate uids in schema) 
     */
    public void validate(LogicalSchema schema)
            throws PlanValidationException {
        
        if(schema == null)
            return;
        
        Set<Long> uidsSeen = new HashSet<Long>();
        for(LogicalSchema.LogicalFieldSchema fs : schema.getFields()){
            
            if(!skipDuplicateUidCheck){
                //check duplicate uid
                if(!uidsSeen.add(fs.uid)){
                    // uid already seen
                    String msg = "Logical plan invalid state: duplicate uid in " +
                            "schema : " + schema;
                    throw new PlanValidationException(
                            msg,
                            2270,
                            LatinException.BUG
                            );
                }
            }
            
            if(fs.uid < 0){
                String msg = "Logical plan invalid state: invalid uid " + fs.uid + 
                        " in schema : " + schema;
                throw new PlanValidationException(
                        msg,
                        2271,
                        LatinException.BUG
                        );
                
            }
        }
    }

}

class FieldSchemaResetter extends AllSameExpressionVisitor {

    protected FieldSchemaResetter(OperatorPlan p) throws FrontendException {
        super(p, new ReverseDependencyOrderWalker(p));
    }

    @Override
    protected void execute(LogicalExpression op) throws FrontendException {
        op.resetFieldSchema();
        op.getFieldSchema();
    }

}

