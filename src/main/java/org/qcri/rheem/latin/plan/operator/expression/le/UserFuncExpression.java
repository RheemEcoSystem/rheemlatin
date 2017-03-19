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

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.qcri.rheem.latin.exception.FrontendException;
import org.qcri.rheem.latin.plan.Operator;
import org.qcri.rheem.latin.plan.OperatorPlan;
import org.qcri.rheem.latin.plan.PlanVisitor;
import org.qcri.rheem.latin.plan.logical.LogicalSchema;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpression;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpressionPlan;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpressionVisitor;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserFuncExpression extends LogicalExpression {

    private String signature;
    private static int sigSeq=0;
    private boolean viaDefine=false; //this represents whether the function was instantiate via a DEFINE statement or not

    public UserFuncExpression(OperatorPlan plan, Object funcSpec) {
        super("UserFunc", plan);
        plan.add(this);
        if (signature==null) {
            signature = Integer.toString(sigSeq++);
        }
    }


    public UserFuncExpression(OperatorPlan plan, Object funcSpec, List<LogicalExpression> args) {
        this( plan, funcSpec );

        for( LogicalExpression arg : args ) {
            plan.connect( this, arg );
        }
    }

    public UserFuncExpression(OperatorPlan plan, Object funcSpec, boolean viaDefine) {
        this( plan, funcSpec);
        this.viaDefine = viaDefine;
    }

    public UserFuncExpression(OperatorPlan plan, Object funcSpec, List<LogicalExpression> args, boolean viaDefine) {
        this( plan, funcSpec, args );
        this.viaDefine = viaDefine;
    }
    
    private boolean lazilyInitializeInvokerFunction = false;
    private List<LogicalExpression> saveArgsForLater = null;
    private boolean invokerIsStatic = false;
    private String funcName = null;
    private String packageName = null;
    
    public UserFuncExpression(OperatorPlan plan, Object funcSpec, List<LogicalExpression> args, boolean viaDefine, boolean lazilyInitializeInvokerFunction, boolean invokerIsStatic, String packageName, String funcName) {
        this( plan, funcSpec, args, viaDefine );
        this.saveArgsForLater = args;
        this.lazilyInitializeInvokerFunction = lazilyInitializeInvokerFunction;
        this.packageName = packageName;
        this.funcName = funcName;
        this.invokerIsStatic = invokerIsStatic;
    }

    @Override
    public void accept(PlanVisitor v) throws FrontendException {
        if (!(v instanceof LogicalExpressionVisitor)) {
            throw new FrontendException("Expected LogicalExpressionVisitor", 2222);
        }
        ((LogicalExpressionVisitor)v).visit(this);
    }

    @Override
    public boolean isEqual(Operator other) throws FrontendException {
        return false;
    }



    public List<LogicalExpression> getArguments() throws FrontendException {
        List<Operator> successors = null;
        List<LogicalExpression> args = new ArrayList<LogicalExpression>();
//        try {
            successors = plan.getSuccessors(this);

            if(successors == null)
                return args;

            for(Operator lo : successors){
                args.add((LogicalExpression)lo);
            }
//        } catch (FrontendException e) {
//           return args;
//        }
        return args;
    }


    @Override
    public LogicalSchema.LogicalFieldSchema getFieldSchema() throws FrontendException {
        return null;
    }

    @Override
    public LogicalExpression deepCopy(LogicalExpressionPlan lgExpPlan) throws FrontendException {
        return null;
    }
}
