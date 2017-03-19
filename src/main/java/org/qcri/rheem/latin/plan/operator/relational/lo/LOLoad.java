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
import org.qcri.rheem.latin.plan.operator.relational.LogicalRelationalOperator;

import java.util.List;

public class LOLoad extends LogicalRelationalOperator {
    @Override
    public void accept(PlanVisitor v) throws FrontendException {
    }

    @Override
    public boolean isEqual(Operator operator) throws FrontendException {
        return false;
    }

    @Override
    public LogicalSchema getSchema() throws FrontendException {
        return null;
    }

    public enum CastState {INSERTED, NONEED, NOADJUST};
    private LogicalSchema scriptSchema;
    private List<Integer> requiredFields = null;
    private CastState castState = CastState.NOADJUST;
    private LogicalSchema uidOnlySchema;
    private final String signature;
    private long limit = -1;
    private boolean isTmpLoad;
    private String filename;
    /**
     * used for pattern matching
     * 
     * @param schema schema user specified in script, or null if not
     * specified.
     * @param plan logical plan this load is part of.
     */
    public LOLoad(LogicalSchema schema, LogicalPlan plan, String path) {
        this(null, schema, plan, null, null, null);
        this.filename = path;
    }

    /**
     * Used from the LogicalPlanBuilder
     *
     * @param loader FuncSpec for load function to use for this load.
     * @param schema schema user specified in script, or null if not specified.
     * @param plan logical plan this load is part of.
     * @param conf
     * @param loadFunc the LoadFunc that was instantiated from loader
     * @param signature the signature that will be passed to the LoadFunc
     */
    public LOLoad(Object loader, LogicalSchema schema, LogicalPlan plan, Object conf, Object loadFunc, String signature) {
        super("LOLoad", plan);
        this.scriptSchema = schema;
        this.signature = signature;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getParam(Class classParam){
        return this.filename;
    }
}
