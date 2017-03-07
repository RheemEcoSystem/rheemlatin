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

package org.qcri.rheem.newplan;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.pig.PigConstants;
import org.apache.pig.PigException;
import org.apache.pig.backend.hadoop.datastorage.ConfigurationUtil;
import org.apache.pig.data.SchemaTupleBackend;
import org.apache.pig.impl.PigContext;
import org.apache.pig.impl.PigImplConstants;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.plan.CompilationMessageCollector;
import org.apache.pig.impl.plan.CompilationMessageCollector.MessageType;
import org.apache.pig.impl.util.HashOutputStream;
import org.apache.pig.impl.util.ObjectSerializer;
import org.qcri.rheem.newplan.BaseOperatorPlan;
import org.qcri.rheem.newplan.Operator;
import org.qcri.rheem.newplan.OperatorPlan;
import org.qcri.rheem.newplan.logical.DotLOPrinter;
import org.qcri.rheem.newplan.logical.optimizer.LogicalPlanOptimizer;
import org.qcri.rheem.newplan.logical.optimizer.LogicalPlanPrinter;
import org.qcri.rheem.newplan.logical.optimizer.SchemaResetter;
import org.qcri.rheem.newplan.logical.optimizer.UidResetter;
import org.qcri.rheem.newplan.logical.visitor.CastLineageSetter;
import org.qcri.rheem.newplan.logical.visitor.ColumnAliasConversionVisitor;
import org.qcri.rheem.newplan.logical.visitor.DanglingNestedNodeRemover;
import org.qcri.rheem.newplan.logical.visitor.DuplicateForEachColumnRewriteVisitor;
import org.qcri.rheem.newplan.logical.visitor.ForEachUserSchemaVisitor;
import org.qcri.rheem.newplan.logical.visitor.ImplicitSplitInsertVisitor;
import org.qcri.rheem.newplan.logical.visitor.InputOutputFileValidatorVisitor;
import org.qcri.rheem.newplan.logical.visitor.ScalarVariableValidator;
import org.qcri.rheem.newplan.logical.visitor.ScalarVisitor;
import org.qcri.rheem.newplan.logical.visitor.SchemaAliasVisitor;
import org.qcri.rheem.newplan.logical.visitor.SortInfoSetter;
import org.qcri.rheem.newplan.logical.visitor.StoreAliasSetter;
import org.qcri.rheem.newplan.logical.visitor.TypeCheckingRelVisitor;
import org.qcri.rheem.newplan.logical.visitor.UnionOnSchemaSetter;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.qcri.rheem.translate.TransformerClass;

/**
 * LogicalPlan is the logical view of relational operations Pig will execute
 * for a given script.  Note that it contains only relational operations.
 * All expressions will be contained in LogicalExpressionPlans inside
 * each relational operator.
 */
public class LogicalPlan extends BaseOperatorPlan {

    private static TransformerClass trans = null;
    public LogicalPlan(LogicalPlan other) {
        // shallow copy constructor
        super(other);
        if( trans == null ){
            trans = new TransformerClass();
        }
    }

    public LogicalPlan() {
        super();
    }

    /**
     * Equality is checked by calling equals on every leaf in the plan.  This
     * assumes that plans are always connected graphs.  It is somewhat
     * inefficient since every leaf will test equality all the way to
     * every root.  But it is only intended for use in testing, so that
     * should be ok.  Checking predecessors (as opposed to successors) was
     * chosen because splits (which have multiple successors) do not depend
     * on order of outputs for correctness, whereas joins (with multiple
     * predecessors) do.  That is, reversing the outputs of split in the
     * graph has no correctness implications, whereas reversing the inputs
     * of join can.  This method of doing equals will detect predecessors
     * in different orders but not successors in different orders.
     * It will return false if either plan has non deterministic EvalFunc.
     */
    @Override
    public boolean isEqual(OperatorPlan other) throws FrontendException {
        if (other == null || !(other instanceof LogicalPlan)) {
            return false;
        }

        return super.isEqual(other);
    }

    @Override
    public void explain(PrintStream ps, String format, boolean verbose)
    throws FrontendException {
        if (format.equals("xml")) {
            ps.println("<logicalPlan>XML Not Supported</logicalPlan>");
            return;
        }

        ps.println("#-----------------------------------------------");
        ps.println("# New Logical Plan:");
        ps.println("#-----------------------------------------------");

        if (this.size() == 0) {
            ps.println("Logical plan is empty.");
        } else if (format.equals("dot")) {
            DotLOPrinter lpp = new DotLOPrinter(this, ps);
            lpp.dump();
        } else {
            LogicalPlanPrinter npp = new LogicalPlanPrinter(this, ps);
            npp.visit();
        }
    }

    public Operator findByAlias(String alias) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    	Iterator<Operator> it = getOperators();
    	List<Operator> ops = new ArrayList<Operator>();
    	while( it.hasNext() ) {
    	    LogicalRelationalOperator op = (LogicalRelationalOperator) it.next();
    	    if(op.getAlias() == null)
    	        continue;
    	    if(op.getAlias().equals( alias ) )  {
                org.qcri.rheem.core.plan.rheemplan.Operator tmp = trans.trans( op );
    	        ops.add( tmp );

    	    }
    	}

    	if( ops.isEmpty() ) {
            return null;
    	} else {
    		return ops.get( ops.size() - 1 ); // Last one
    	}
    }


    public void validate(PigContext pigContext, String scope, boolean skipInputOutputValidation)
            throws FrontendException {

    }
    
    public void optimize(PigContext pigContext) throws FrontendException {

    }
}
