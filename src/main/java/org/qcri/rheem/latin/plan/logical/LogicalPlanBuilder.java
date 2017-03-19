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

package org.qcri.rheem.latin.plan.logical;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;
import org.qcri.rheem.latin.exception.*;
import org.qcri.rheem.latin.plan.Operator;
import org.qcri.rheem.latin.plan.OperatorPlan;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpression;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpressionPlan;
import org.qcri.rheem.latin.plan.operator.expression.ProjectExpression;
import org.qcri.rheem.latin.plan.operator.expression.le.ConstantExpression;
import org.qcri.rheem.latin.plan.operator.expression.le.NotExpression;
import org.qcri.rheem.latin.plan.operator.relational.LogicalRelationalOperator;
import org.qcri.rheem.latin.plan.operator.relational.lo.*;
import org.qcri.rheem.latin.plan.operator.relational.lo.LOCogroup.GROUPTYPE;
import org.qcri.rheem.latin.plan.operator.relational.lo.LOJoin.JOINTYPE;
import org.qcri.rheem.latin.util.*;
import org.qcri.rheem.latin.util.StreamingCommand.Handle;
import org.qcri.rheem.latin.util.StreamingCommand.HandleSpec;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.util.*;

public class LogicalPlanBuilder {

    private LogicalPlan plan = new LogicalPlan();

    private String lastRel = null;

    private Map<String, Operator> operators = new HashMap<String, Operator>() {
        @Override
        public Operator put(String k, Operator v) {
            lastRel = k;
            return super.put(k, v);
        }
    };

    Map<String, String> fileNameMap;

    private LatinContext latinContext = null;
    private String scope = null;
    private IntStream intStream;
    private int storeIndex = 0;
    private int loadIndex = 0;

    private static NodeIdGenerator nodeIdGen = NodeIdGenerator.getGenerator();

    LogicalPlan getPlan() {
        return plan;
    }

    Map<String, Operator> getOperators() {
        return operators;
    }

    public String getLastRel(SourceLocation loc) throws ParserValidationException {
        if (lastRel == null) {
            throw new ParserValidationException(intStream, loc, "Asked for last relation -- no relations have been defined");
        }
        return lastRel;
    }

    public String getLastRel() {
        return lastRel;
    }

    LogicalPlanBuilder(LatinContext latinContext, String scope, Map<String, String> fileNameMap,
                       IntStream input) {
        this.latinContext = latinContext;
        this.scope = scope;
        this.fileNameMap = fileNameMap;
        this.intStream = input;
    }

    Operator lookupOperator(String alias) {
        return operators.get( alias );
    }

    void setParallel(LogicalRelationalOperator op, Integer parallel) {
        if( parallel != null ) {
            op.setRequestedParallelism( parallel );
        }
    }

    void putOperator(String alias, Operator op) {
        operators.put(alias, op);
    }

    void defineCommand(String alias, StreamingCommand command) {
        latinContext.registerStreamCmd( alias, command );
    }


    StreamingCommand buildCommand(SourceLocation loc, String cmd, List<String> shipPaths, List<String> cachePaths,
                                  List<HandleSpec> inputHandleSpecs, List<HandleSpec> outputHandleSpecs,
                                  String logDir, Integer limit) throws RecognitionException {
        StreamingCommand command = null;
        try {
            command = buildCommand( loc, cmd );

            // Process ship paths
            if( shipPaths != null ) {
                if( shipPaths.size() == 0 ) {
                    command.setShipFiles( false );
                } else {
                    for( String path : shipPaths )
                        command.addPathToShip( path );
                }
            }

            // Process cache paths
            if( cachePaths != null ) {
                for( String path : cachePaths )
                    command.addPathToCache( path );
            }

            // Process input handle specs
            if( inputHandleSpecs != null ) {
                for( HandleSpec spec : inputHandleSpecs )
                    command.addHandleSpec( Handle.INPUT, spec );
            }

            // Process output handle specs
            if( outputHandleSpecs != null ) {
                for( HandleSpec spec : outputHandleSpecs )
                    command.addHandleSpec( Handle.OUTPUT, spec );
            }

            // error handling
            if( logDir != null )
                command.setLogDir( logDir );
            if( limit != null )
                command.setLogFilesLimit( limit );
        } catch(IOException e) {
            throw new PlanGenerationFailureException( intStream, loc, e );
        }

        return command;
    }

    StreamingCommand buildCommand(SourceLocation loc, String cmd) throws RecognitionException {
        try {
            String[] args = StreamingCommandUtils.splitArgs( cmd );
            StreamingCommand command = new StreamingCommand( latinContext, args );
            StreamingCommandUtils validator = new StreamingCommandUtils( latinContext );
            validator.checkAutoShipSpecs( command, args );
            return command;
        } catch (ParserException e) {
            throw new InvalidCommandException( intStream, loc, cmd );
        }
    }

    static String unquote(String s) {
        return StringUtils.unescapeInputString( s.substring(1, s.length() - 1 ) );
    }

    LOCogroup createGroupOp() {
        return new LOCogroup( plan );
    }

    String buildGroupOp(SourceLocation loc, LOCogroup op, String alias, List<String> inputAliases,
                        MultiMap<Integer, LogicalExpressionPlan> expressionPlans, GROUPTYPE gt, List<Boolean> innerFlags,
                        String partitioner) throws ParserValidationException {
        if( gt == GROUPTYPE.COLLECTED ) {
            if( inputAliases.size() > 1 ) {
                throw new ParserValidationException( intStream, loc,
                        "Collected group is only supported for single input" );
            }

            List<LogicalExpressionPlan> exprPlans = expressionPlans.get( 0 );
            for( LogicalExpressionPlan exprPlan : exprPlans ) {
                Iterator<Operator> it = exprPlan.getOperators();
                while( it.hasNext() ) {
                    if( !( it.next() instanceof ProjectExpression ) ) {
                        throw new ParserValidationException( intStream, loc,
                                "Collected group is only supported for columns or star projection" );
                    }
                }
            }
        }

        boolean[] flags = new boolean[innerFlags.size()];
        for( int i = 0; i < innerFlags.size(); i++ ) {
            flags[i] = innerFlags.get( i );
        }
        op.setExpressionPlans( expressionPlans );
        op.setGroupType( gt );
        op.setInnerFlags( flags );

        return alias;
    }


    /**
     * For any UNKNOWN type in the schema fields, set the type to BYTEARRAY
     * @param sch
     */
    static void setBytearrayForNULLType(LogicalSchema sch){
        for(LogicalSchema.LogicalFieldSchema fs : sch.getFields()){
            if(fs.type == DataType.NULL){
                fs.type = DataType.BYTEARRAY;
            }
            if(fs.schema != null){
                setBytearrayForNULLType(fs.schema);
            }
        }
    }

    GROUPTYPE parseGroupType(String hint, SourceLocation loc) throws ParserValidationException {
        String modifier = unquote( hint );

        if( modifier.equalsIgnoreCase( "collected" ) ) {
            return GROUPTYPE.COLLECTED;
        } else if( modifier.equalsIgnoreCase( "regular" ) ){
            return GROUPTYPE.REGULAR;
        } else if( modifier.equalsIgnoreCase( "merge" ) ){
            return GROUPTYPE.MERGE;
        } else {
            throw new ParserValidationException( intStream, loc,
                    "Only COLLECTED, REGULAR or MERGE are valid GROUP modifiers." );
        }
    }

    /**
     *  Build a project expression in foreach inner plan.
     *  The only difference here is that the projection can be for an expression alias, for which
     *  we will return whatever the expression alias represents.
     * @throws RecognitionException
     */
    LogicalExpression buildProjectExpr(SourceLocation loc, LogicalExpressionPlan plan, LogicalRelationalOperator op,
                                       Map<String, Operator> operators, Map<String, LogicalExpressionPlan> exprPlans, String colAlias, int col)
            throws RecognitionException {
        ProjectExpression result = null;

        if( colAlias != null ) {
            LogicalExpressionPlan exprPlan = exprPlans.get( colAlias );
            if( exprPlan != null ) {
                LogicalExpressionPlan planCopy = null;
                try {
                    planCopy = exprPlan.deepCopy();
                    plan.merge( planCopy );
                } catch (FrontendException ex) {
                    throw new PlanGenerationFailureException( intStream, loc, ex );
                }
                // The projected alias is actually expression alias, so the projections in the represented
                // expression doesn't have any operator associated with it. We need to set it when we
                // substitute the expression alias with the its expression.
                if( op != null ) {
                    Iterator<Operator> it = plan.getOperators();
                    while( it.hasNext() ) {
                        Operator o = it.next();
                        if( o instanceof ProjectExpression ) {
                            ProjectExpression projExpr = (ProjectExpression)o;
                            projExpr.setAttachedRelationalOp( op );
                        }
                    }
                }
                LogicalExpression root = (LogicalExpression)planCopy.getSources().get( 0 );// get the root of the plan
                LogicalSchema.LogicalFieldSchema schema;
                try {
                    schema = root.getFieldSchema();
                    if (schema.alias == null) {
                        schema.alias = colAlias;
                    }
                } catch (FrontendException e) {
                    // Sometimes it can throw an exception. If it does, then there is no schema to get
                }
                return root;
            } else {
                result = new ProjectExpression( plan, 0, colAlias, operators.get( colAlias ), op );
                result.setLocation( loc );
                return result;
            }
        }
        result = new ProjectExpression( plan, 0, col, op );
        result.setLocation( loc );
        return result;
    }

    /**
     * Build a project expression for a projection present in global plan (not in nested foreach plan).
     * @throws ParserValidationException
     */
    LogicalExpression buildProjectExpr(SourceLocation loc,
                                       LogicalExpressionPlan plan, LogicalRelationalOperator relOp,
                                       int input, String colAlias, int col)
            throws ParserValidationException {
        ProjectExpression result = null;
        result = colAlias != null ?
                new ProjectExpression( plan, input, colAlias, null, relOp ) :
                new ProjectExpression( plan, input, col, relOp );
        result.setLocation( loc );
        return result;
    }

    LOFilter createFilterOp() {
        return new LOFilter( plan );
    }


    String buildFilterOp(SourceLocation loc, LOFilter op, String alias,
                         String inputAlias, LogicalExpressionPlan expr)
            throws ParserValidationException {

        op.setFilterPlan( expr );
        alias = buildOp( loc, op, alias, inputAlias, null ); // it should actually return same alias

        return alias;
    }

    private String buildOp(SourceLocation loc, LogicalRelationalOperator op, String alias,
                           String inputAlias, String partitioner) throws ParserValidationException {
        List<String> inputAliases = new ArrayList<String>();
        if( inputAlias != null )
            inputAliases.add( inputAlias );
        return buildOp( loc, op, alias, inputAliases, partitioner );
    }

    private String buildOp(SourceLocation loc, LogicalRelationalOperator op, String alias,
                           List<String> inputAliases, String partitioner) throws ParserValidationException {
        setAlias( op, alias );
        setPartitioner( op, partitioner );
        op.setLocation( loc );
        plan.add( op );
        for( String a : inputAliases ) {
            Operator pred = operators.get( a );
            if (pred==null) {
                throw new ParserValidationException( intStream, loc, "Unrecognized alias " + a );
            }
            plan.connect( pred, op );
        }
        operators.put( op.getAlias(), op );
        latinContext.setLastAlias(op.getAlias());
        return op.getAlias();
    }

    void setAlias(LogicalRelationalOperator op, String alias) {
        if( alias == null )
            alias = newOperatorKey();
        op.setAlias( alias );
    }


    private String newOperatorKey() {
        return new OperatorKey( scope, getNextId() ).toString();
    }

    public static String newOperatorKey(String scope) {
        return new OperatorKey( scope, getNextId(scope)).toString();
    }

    static void setPartitioner(LogicalRelationalOperator op, String partitioner) {
        if( partitioner != null )
            op.setCustomPartitioner( partitioner );
    }

    private long getNextId() {
        return getNextId(scope);
    }

    public static long getNextId(String scope) {
        return nodeIdGen.getNextNodeId( scope );
    }

    LogicalExpression buildUDF(SourceLocation loc, LogicalExpressionPlan plan,
                               String funcName, List<LogicalExpression> args)
            throws RecognitionException {

        return null;
    }


    LogicalExpression buildInvokerUDF(SourceLocation loc, LogicalExpressionPlan plan, String packageName, String funcName, boolean isStatic, List<LogicalExpression> args) throws RecognitionException {
        return null;
    }

    static int undollar(String s) {
        return Integer.parseInt( s.substring( 1, s.length() ) );
    }

    /**
     * Build a project expression that projects a range of columns
     * @param loc
     * @param plan
     * @param relOp
     * @param input
     * @param startExpr the first expression to be projected, null
     *        if everything from first is to be projected
     * @param endExpr the last expression to be projected, null
     *        if everything to the end is to be projected
     * @return project expression
     * @throws ParserValidationException
     */
    LogicalExpression buildRangeProjectExpr(SourceLocation loc, LogicalExpressionPlan plan, LogicalRelationalOperator relOp,
                                            int input, LogicalExpression startExpr, LogicalExpression endExpr)
            throws ParserValidationException {

        if(startExpr == null && endExpr == null){
            // should not reach here as the parser is enforcing this condition
            String msg = "in range project (..) at least one of start or end " +
                    "has to be specified. Use project-star (*) instead.";
            throw new ParserValidationException(intStream, loc, msg);
        }

        ProjectExpression proj = new ProjectExpression(plan, input, relOp);

        //set first column to be projected
        if(startExpr != null){
            checkRangeProjectExpr(loc, startExpr);
            ProjectExpression startProj = (ProjectExpression)startExpr;
            if(startProj.getColAlias() != null){
                try {
                    proj.setStartAlias(startProj.getColAlias());
                } catch (FrontendException e) {
                    throw new ParserValidationException(intStream, loc, e);
                }
            }else{
                proj.setStartCol(startProj.getColNum());
            }
        }else{
            proj.setStartCol(0);//project from first column
        }

        //set last column to be projected
        if(endExpr != null){
            checkRangeProjectExpr(loc, endExpr);
            ProjectExpression endProj = (ProjectExpression)endExpr;
            if(endProj.getColAlias() != null){
                try {
                    proj.setEndAlias(endProj.getColAlias());
                } catch (FrontendException e) {
                    throw new ParserValidationException(intStream, loc, e);
                }
            }else{
                proj.setEndCol(endProj.getColNum());
            }
        }else{
            proj.setEndCol(-1); //project to last column
        }

        try {
            if(startExpr != null)
                plan.removeAndReconnect(startExpr);
            if(endExpr != null)
                plan.removeAndReconnect(endExpr);
        } catch (FrontendException e) {
            throw new ParserValidationException(intStream, loc, e);
        }

        return proj;
    }

    private void checkRangeProjectExpr(SourceLocation loc, LogicalExpression startExpr)
            throws ParserValidationException {
        if(! (startExpr instanceof ProjectExpression)){
            // should not reach here as the parser is enforcing this condition
            String msg = "range project (..) can have only a simple column." +
                    " Found :" + startExpr;
            throw new ParserValidationException(intStream, loc, msg);
        }
    }

    LOLimit createLimitOp() {
        return new LOLimit( plan );
    }

    String buildLimitOp(SourceLocation loc, String alias, String inputAlias, long limit) throws ParserValidationException {
        LOLimit op = new LOLimit( plan, limit );
        return buildOp( loc, op, alias, inputAlias, null );
    }

    String buildLimitOp(SourceLocation loc, LOLimit op, String alias, String inputAlias, LogicalExpressionPlan expr) throws ParserValidationException {
        op.setLimitPlan(expr);
        return buildOp(loc, op, alias, inputAlias, null);
    }

    /**
     * Parse the long given as a string such as "34L".
     */
    static long parseLong(String s) {
        String num = s.substring( 0, s.length() - 1 );
        return Long.parseLong( num );
    }

    LOFilter createSampleOp() {
        return new LOFilter( plan, true );
    }

    String buildSampleOp(SourceLocation loc, String alias, String inputAlias, double value,
                         SourceLocation valLoc)
            throws ParserValidationException {

        LogicalExpressionPlan filterPlan = new LogicalExpressionPlan();
        //  Generate a filter condition.
        LogicalExpression konst = new ConstantExpression( filterPlan, value);
        konst.setLocation( valLoc );
        LOFilter filter = new LOFilter( plan, true );
        return buildFilterOp( loc, filter, alias, inputAlias, filterPlan );
    }

    String buildSampleOp(SourceLocation loc, LOFilter filter, String alias, String inputAlias,
                         LogicalExpressionPlan samplePlan, LogicalExpression expr)
            throws ParserValidationException {

        return buildFilterOp( loc, filter, alias, inputAlias, samplePlan );
    }

    LORank createRankOp() {
        return new LORank( plan );
    }

    String buildRankOp(SourceLocation loc, LORank rank, String alias, String inputAlias, List<LogicalExpressionPlan> plans,
                       List<Boolean> ascFlags) throws ParserValidationException {

        //Rank
        rank.setRankColPlan(plans);
        if (ascFlags.isEmpty()) {
            for (int i=0;i<plans.size();i++)
                ascFlags.add(true);
        }
        rank.setAscendingCol(ascFlags);

        buildOp( loc, rank, alias, inputAlias, null );


        return alias;
    }


    LOSort createSortOp() {
        return new LOSort( plan );
    }

    String buildSortOp(SourceLocation loc, LOSort sort, String alias, String inputAlias, List<LogicalExpressionPlan> plans,
                       List<Boolean> ascFlags, Object fs) throws ParserValidationException {
        sort.setSortColPlans( plans );
        if (ascFlags.isEmpty()) {
            for (int i=0;i<plans.size();i++)
                ascFlags.add(true);
        }
        sort.setAscendingCols( ascFlags );
        alias = buildOp( loc, sort, alias, inputAlias, null );
        return  alias;
    }

    String buildDistinctOp(SourceLocation loc, String alias, String inputAlias, String partitioner) throws ParserValidationException {
        LODistinct op = new LODistinct( plan );
        return buildOp( loc, op, alias, inputAlias, partitioner );
    }

    String buildCrossOp(SourceLocation loc, String alias, List<String> inputAliases, String partitioner) throws ParserValidationException {
        LOCross op = new LOCross( plan );
        return buildOp ( loc, op, alias, inputAliases, partitioner );
    }


    LOJoin createJoinOp() {
        return new LOJoin( plan );
    }

    String buildJoinOp(SourceLocation loc, LOJoin op, String alias, List<String> inputAliases,
                       MultiMap<Integer, LogicalExpressionPlan> joinPlans,
                       JOINTYPE jt, List<Boolean> innerFlags, String partitioner)
            throws ParserValidationException {
        checkDuplicateAliases(inputAliases, loc, "JOIN");
        if (jt==null)
            jt = JOINTYPE.HASH;
        else {
            op.pinOption(LOJoin.OPTION_JOIN);
        }

        int inputCount = inputAliases.size();

        if( jt == JOINTYPE.SKEWED ) {
            if( partitioner != null ) {
                throw new ParserValidationException( intStream, loc,
                        "Custom Partitioner is not supported for skewed join" );
            }

            if( inputCount != 2 ) {
                throw new ParserValidationException( intStream, loc,
                        "Skewed join can only be applied for 2-way joins" );
            }
        } else if( (jt == JOINTYPE.MERGE || jt == JOINTYPE.MERGESPARSE) && inputCount != 2 ) {
            throw new ParserValidationException( intStream, loc,
                    "Merge join can only be applied for 2-way joins" );
        } else if( jt == JOINTYPE.REPLICATED ) {
            if( innerFlags.size() == 2 && innerFlags.get( 0 ) == false ) {
                throw new ParserValidationException( intStream, loc,
                        "Replicated join does not support (right|full) outer joins" );
            }
        }

        boolean[] flags = new boolean[joinPlans.size()];
        if (innerFlags.size()!=0) {
            for( int i = 0; i < joinPlans.size(); i++ ) {
                flags[i] = innerFlags.get( i );
            }
        }
        else {
            for( int i = 0; i < joinPlans.size(); i++ ) {
                flags[i] = true;
            }
        }
        op.setJoinType( jt );
        op.setInnerFlags( flags );
        op.setJoinPlans( joinPlans );
        alias = buildOp( loc, op, alias, inputAliases, partitioner );

        return alias;
    }

    private void checkDuplicateAliases(List<String> inputAliases, SourceLocation loc,
                                       String opName) throws ParserValidationException {
        //Keep the count of the number of times the same Alias is used
        Map<Operator, Integer> inputAliasesMap = new HashMap<Operator, Integer>();
        for(String a : inputAliases) {
            Operator pred = operators.get( a );
            if (pred == null) {
                throw new ParserValidationException( intStream, loc, "Unrecognized alias " + a );
            }
            if (inputAliasesMap.containsKey(pred)) {
                throw new ParserValidationException( intStream, loc,
                        "Pig does not accept same alias as input for " + opName +
                                " operation : " + a );
            }
            else {
                inputAliasesMap.put(pred, 1);
            }
        }
    }

    JOINTYPE parseJoinType(String hint, SourceLocation loc) throws ParserValidationException {
        String modifier = unquote( hint );

        if( modifier.equalsIgnoreCase( "repl" ) || modifier.equalsIgnoreCase( "replicated" ) ) {
            return JOINTYPE.REPLICATED;
        } else if( modifier.equalsIgnoreCase( "hash" ) || modifier.equalsIgnoreCase( "default" ) ) {
            return LOJoin.JOINTYPE.HASH;
        } else if( modifier.equalsIgnoreCase( "skewed" ) ) {
            return JOINTYPE.SKEWED;
        } else if (modifier.equalsIgnoreCase("merge")) {
            return JOINTYPE.MERGE;
        } else if (modifier.equalsIgnoreCase("merge-sparse")) {
            return JOINTYPE.MERGESPARSE;
        } else {
            throw new ParserValidationException( intStream, loc,
                    "Only REPL, REPLICATED, HASH, SKEWED, MERGE, and MERGE-SPARSE are vaild JOIN modifiers." );
        }

    }

    String buildUnionOp(SourceLocation loc, String alias, List<String> inputAliases, boolean onSchema) throws ParserValidationException {
        checkDuplicateAliases(inputAliases, loc, "UNION");
        LOUnion op = new LOUnion( plan, onSchema );
        return buildOp( loc, op, alias, inputAliases, null );
    }

    LOForEach createForeachOp() {
        return new LOForEach( plan );
    }

    String buildForeachOp(SourceLocation loc, LOForEach op, String alias, String inputAlias, LogicalPlan innerPlan)
            throws ParserValidationException {
        op.setInnerPlan( innerPlan );
        alias = buildOp( loc, op, alias, inputAlias, null );

        return alias;
    }

    Operator buildNestedProjectOp(SourceLocation loc, LogicalPlan innerPlan, LOForEach foreach,
                                  Map<String, Operator> operators,
                                  String alias,
                                  ProjectExpression projExpr,
                                  List<LogicalExpressionPlan> exprPlans)
            throws ParserValidationException {
        Operator input = null;
        String colAlias = projExpr.getColAlias();
        if( colAlias != null ) {
            // ProjExpr refers to a name, which can be an alias for another operator or col name.
            Operator op = operators.get( colAlias );
            if( op != null ) {
                // ProjExpr refers to an operator alias.
                input = op ;
            } else {
                // Assuming that ProjExpr refers to a column by name. Create an LOInnerLoad
                input = createInnerLoad( loc, innerPlan, foreach, colAlias );
                input.setLocation( projExpr.getLocation() );
            }
        } else {
            // ProjExpr refers to a column by number.
            input = new LOInnerLoad( innerPlan, foreach, projExpr.getColNum() );
            input.setLocation( projExpr.getLocation() );
        }

        LogicalPlan lp = new LogicalPlan(); // f's inner plan
        LOForEach f = new LOForEach( innerPlan );
        f.setInnerPlan( lp );
        f.setLocation( loc );
        LOGenerate gen = new LOGenerate( lp );
        boolean[] flatten = new boolean[exprPlans.size()];

        List<Operator> innerLoads = new ArrayList<Operator>( exprPlans.size() );
        for( LogicalExpressionPlan plan : exprPlans ) {
            ProjectExpression pe = (ProjectExpression)plan.getSinks().get( 0 );
            String al = pe.getColAlias();
            LOInnerLoad iload = ( al == null ) ?
                    new LOInnerLoad( lp, f, pe.getColNum() ) : createInnerLoad(loc, lp, f, al );
            iload.setLocation( pe.getLocation() );
            pe.setColNum( -1 );
            pe.setInputNum( innerLoads.size() );
            pe.setAttachedRelationalOp( gen );
            innerLoads.add( iload );
        }

        gen.setOutputPlans( exprPlans );
        gen.setFlattenFlags( flatten );
        lp.add( gen );

        for( Operator il : innerLoads ) {
            lp.add( il );
            lp.connect( il, gen );
        }

        // Connect the inner load operators to gen
        setAlias( f, alias );
        innerPlan.add( input );
        innerPlan.add( f );
        innerPlan.connect( input, f );
        return f;
    }

    private LOInnerLoad createInnerLoad(SourceLocation loc, LogicalPlan innerPlan, LOForEach foreach,
                                        String colAlias) throws ParserValidationException {
        try {
            return new LOInnerLoad( innerPlan, foreach, colAlias );
        } catch (FrontendException e) {
            throw new ParserValidationException(intStream, loc, e);
        }
    }

    static LOFilter createNestedFilterOp(LogicalPlan plan) {
        return new LOFilter( plan );
    }

    // Build operator for foreach inner plan.
    Operator buildNestedFilterOp(SourceLocation loc, LOFilter op, LogicalPlan plan, String alias,
                                 Operator inputOp, LogicalExpressionPlan expr) {
        op.setFilterPlan( expr );
        buildNestedOp( loc, plan, op, alias, inputOp );
        return op;
    }

    private void buildNestedOp(SourceLocation loc, LogicalPlan plan, LogicalRelationalOperator op,
                               String alias, Operator inputOp) {
        op.setLocation( loc );
        setAlias( op, alias );
        plan.add( op );
        plan.connect( inputOp, op );
    }

    private void buildNestedOp(SourceLocation loc, LogicalPlan plan, LogicalRelationalOperator op,
                               String alias, List<Operator> inputOpList) {
        op.setLocation( loc );
        op.setLocation( loc );
        setAlias( op, alias );
        plan.add( op );
        for (Operator inputOp : inputOpList) {
            plan.connect( inputOp, op );
        }
    }

    static LOSort createNestedSortOp(LogicalPlan plan) {
        return new LOSort( plan );
    }

    Operator buildNestedSortOp(SourceLocation loc, LOSort op, LogicalPlan plan, String alias, Operator inputOp,
                               List<LogicalExpressionPlan> plans,
                               List<Boolean> ascFlags, Object fs) {
        op.setSortColPlans( plans );
        if (ascFlags.isEmpty()) {
            for (int i=0;i<plans.size();i++)
                ascFlags.add(true);
        }
        op.setAscendingCols( ascFlags );
        buildNestedOp( loc, plan, op, alias, inputOp );
        return op;
    }

    Operator buildNestedDistinctOp(SourceLocation loc, LogicalPlan plan, String alias, Operator inputOp) {
        LODistinct op = new LODistinct( plan );
        buildNestedOp( loc, plan, op, alias, inputOp );
        return op;
    }

    static LOLimit createNestedLimitOp(LogicalPlan plan) {
        return new LOLimit ( plan );
    }

    Operator buildNestedLimitOp(SourceLocation loc, LogicalPlan plan, String alias, Operator inputOp, long limit) {
        LOLimit op = new LOLimit( plan, limit );
        buildNestedOp( loc, plan, op, alias, inputOp );
        return op;
    }

    Operator buildNestedLimitOp(SourceLocation loc, LOLimit op, LogicalPlan plan, String alias,
                                Operator inputOp, LogicalExpressionPlan expr) {
        op.setLimitPlan( expr );
        buildNestedOp( loc, plan, op, alias, inputOp );
        return op;
    }

    Operator buildNestedCrossOp(SourceLocation loc, LogicalPlan plan, String alias, List<Operator> inputOpList) {
        LOCross op = new LOCross( plan );
        op.setNested(true);
        buildNestedOp( loc, plan, op, alias, inputOpList );
        return op;
    }

    static LOForEach createNestedForeachOp(LogicalPlan plan) {
        return new LOForEach(plan);
    }

    Operator buildNestedForeachOp(SourceLocation loc, LOForEach op, LogicalPlan plan, String alias,
                                  Operator inputOp, LogicalPlan innerPlan)
            throws ParserValidationException {
        op.setInnerPlan(innerPlan);
        buildNestedOp(loc, plan, op, alias, inputOp);
        return op;
    }

    LOGenerate createGenerateOp(LogicalPlan plan) {
        return new LOGenerate( plan );
    }

    void buildGenerateOp(SourceLocation loc, LOForEach foreach, LOGenerate gen,
                         List<LogicalExpressionPlan> exprPlans, List<Boolean> flattenFlags,
                         List<LogicalSchema> schemas)
            throws ParserValidationException {

        boolean[] flags = new boolean[ flattenFlags.size() ];
        for( int i = 0; i < flattenFlags.size(); i++ )
            flags[i] = flattenFlags.get( i );
        LogicalPlan innerPlan = (LogicalPlan)gen.getPlan();
        ArrayList<Operator> inputs = new ArrayList<Operator>();
        int idx = 0;
        for( LogicalExpressionPlan exprPlan : exprPlans ) {
            LogicalExpression expr = (LogicalExpression)exprPlan.getSources().get(0);
            LogicalSchema userSchema = schemas.get(idx);
            if (userSchema == null && expr.hasFieldSchema()) {
                LogicalSchema ls = new LogicalSchema();
                try {
                    ls.addField(expr.getFieldSchema());
                    schemas.set(idx, ls);
                } catch (FrontendException e) {
                    // if we get an exception, then we have no schema to set
                }
            }
            idx++;
            try {
                processExpressionPlan( foreach, innerPlan, exprPlan, inputs );
            } catch (FrontendException e) {
                throw new ParserValidationException(intStream, loc, e);
            }
        }

        gen.setOutputPlans( exprPlans );
        gen.setFlattenFlags( flags );
        gen.setUserDefinedSchema( schemas );
        innerPlan.add( gen );
        gen.setLocation( loc );
        for( Operator input : inputs ) {
            innerPlan.connect( input, gen );
        }
    }

    /**
     * Process expression plans of LOGenerate and set inputs relation
     * for the ProjectExpression
     * @param foreach
     * @param lp Logical plan in which the LOGenerate is in
     * @param plan One of the output expression of the LOGenerate
     * @param inputs  inputs of the LOGenerate
     * @throws FrontendException
     */
    private static void processExpressionPlan(LOForEach foreach,
                                              LogicalPlan lp,
                                              LogicalExpressionPlan plan,
                                              ArrayList<Operator> inputs ) throws FrontendException {
        Iterator<Operator> it = plan.getOperators();
        while( it.hasNext() ) {
            Operator sink = it.next();
            //check all ProjectExpression
            if( sink instanceof ProjectExpression ) {
                ProjectExpression projExpr = (ProjectExpression)sink;
                String colAlias = projExpr.getColAlias();
                if( projExpr.isRangeProject()){

                    LOInnerLoad innerLoad = new LOInnerLoad( lp, foreach,
                            new ProjectExpression(projExpr, new LogicalExpressionPlan())
                    );
                    setupInnerLoadAndProj(innerLoad, projExpr, lp, inputs);
                } else if( colAlias != null ) {
                    // the project is using a column alias
                    Operator op = projExpr.getProjectedOperator();
                    if( op != null ) {
                        // this means the project expression refers to a relation
                        // in the nested foreach

                        //add the relation to inputs of LOGenerate and set
                        // projection input
                        int index = inputs.indexOf( op );
                        if( index == -1 ) {
                            index = inputs.size();
                            inputs.add( op );
                        }
                        projExpr.setInputNum( index );
                        projExpr.setColNum( -1 );
                    } else {
                        // this means the project expression refers to a column
                        // in the input of foreach. Add a LOInnerLoad and use that
                        // as input
                        LOInnerLoad innerLoad = new LOInnerLoad( lp, foreach, colAlias );
                        setupInnerLoadAndProj(innerLoad, projExpr, lp, inputs);
                    }
                } else {
                    // the project expression is referring to column in ForEach input
                    // using position (eg $1)
                    LOInnerLoad innerLoad = new LOInnerLoad( lp, foreach, projExpr.getColNum() );
                    setupInnerLoadAndProj(innerLoad, projExpr, lp, inputs);
                }
            }
        }

    }

    private static void setupInnerLoadAndProj(LOInnerLoad innerLoad,
                                              ProjectExpression projExpr, LogicalPlan lp,
                                              ArrayList<Operator> inputs) {
        innerLoad.setLocation( projExpr.getLocation() );
        projExpr.setInputNum( inputs.size() );
        projExpr.setColNum( -1 ); // Projection Expression on InnerLoad is always (*).
        lp.add( innerLoad );
        inputs.add( innerLoad );

    }

    Operator buildNestedOperatorInput(SourceLocation loc, LogicalPlan innerPlan, LOForEach foreach,
                                      Map<String, Operator> operators, LogicalExpression expr)
            throws NonProjectExpressionException, ParserValidationException {
        OperatorPlan plan = expr.getPlan();
        Iterator<Operator> it = plan.getOperators();
        if( !( it.next() instanceof ProjectExpression ) || it.hasNext() ) {
            throw new NonProjectExpressionException( intStream, loc, expr );
        }
        Operator op = null;
        ProjectExpression projExpr = (ProjectExpression)expr;
        String colAlias = projExpr.getColAlias();
        if( colAlias != null ) {
            op = operators.get( colAlias );
            if( op == null ) {
                op = createInnerLoad(loc, innerPlan, foreach, colAlias );
                op.setLocation( projExpr.getLocation() );
                innerPlan.add( op );
            }
        } else {
            op = new LOInnerLoad( innerPlan, foreach, projExpr.getColNum() );
            op.setLocation( projExpr.getLocation() );
            innerPlan.add( op );
        }
        return op;
    }

    StreamingCommand lookupCommand(String alias) {
        return latinContext.getCommandForAlias( alias );
    }

    String buildStreamOp(SourceLocation loc, String alias, String inputAlias, StreamingCommand command,
                         LogicalSchema schema, IntStream input)
            throws RecognitionException {
        LOStream op = new LOStream( plan, command, schema );
        return buildOp( loc, op, alias, inputAlias, null );
    }



    String buildNativeOp(SourceLocation loc, String inputJar, String cmd,
                         List<String> paths, String storeAlias, String loadAlias, IntStream input)
            throws RecognitionException {
        LONative op;
        try {
            op = new LONative( plan, inputJar, StreamingCommandUtils.splitArgs( cmd ) );
            latinContext.addJar( inputJar );
            for( String path : paths )
                latinContext.addJar( path );
            buildOp( loc, op, null, new ArrayList<String>(), null );
    //      ((LOStore)operators.get( storeAlias )).setTmpStore(true);
            plan.connect( operators.get( storeAlias ), op );
            LOLoad load = (LOLoad)operators.get( loadAlias );
            plan.connect( op, load );
            return load.getAlias();
        } catch (ParserException e) {
            throw new InvalidCommandException( input, loc, cmd );
        } catch (MalformedURLException e) {
            throw new RecognitionException();
        }
    }

    String buildSplitOp(SourceLocation loc, String inputAlias) throws ParserValidationException {
        LOSplit op = new LOSplit( plan );
        return buildOp( loc, op, null, inputAlias, null );
    }

    LOSplitOutput createSplitOutputOp() {
        return  new LOSplitOutput( plan );
    }

    String buildSplitOutputOp(SourceLocation loc, LOSplitOutput op, String alias, String inputAlias,
                              LogicalExpressionPlan filterPlan) throws ParserValidationException {
        op.setFilterPlan( filterPlan );
        return buildOp ( loc, op, alias, inputAlias, null );
    }

    String buildSplitOtherwiseOp(SourceLocation loc, LOSplitOutput op, String alias, String inputAlias)
            throws ParserValidationException, PlanGenerationFailureException {
        LogicalExpressionPlan splitPlan = new LogicalExpressionPlan();
        Operator losplit = lookupOperator(inputAlias);
        LogicalExpression currentExpr = null;
        for (Operator losplitoutput : plan.getSuccessors(losplit)) {
            // take all the LOSplitOutput and negate their filter plans
            LogicalExpressionPlan fragment = ((LOSplitOutput) losplitoutput)
                    .getFilterPlan();
            throw new ParserValidationException(
                            intStream, loc, new FrontendException(op,
                            "Can not use Otherwise in Split with an expression containing a @Nondeterministic UDF", 1131));

        }
        // using De Morgan's law (!A && !B) == !(A || B)
        currentExpr = new NotExpression(splitPlan, currentExpr);


        op.setFilterPlan(splitPlan);
        return buildOp(loc, op, alias, inputAlias, null);
    }


    /**
     * Parse big integer formatted string (e.g. "1234567890123BI") into BigInteger object
     */
    static BigInteger parseBigInteger(String s) {
        String num = s.substring( 0, s.length() - 2 );
        return new BigInteger( num );
    }

    /**
     * Parse big decimal formatted string (e.g. "123456.7890123BD") into BigDecimal object
     */
    static BigDecimal parseBigDecimal(String s) {
        String num = s.substring( 0, s.length() - 2 );
        return new BigDecimal( num );
    }

    String buildLoadOp(SourceLocation loc, String alias, String filename, Object funcSpec, LogicalSchema schema)
            throws ParserValidationException {
        String absolutePath;
        List<String> tmp = new ArrayList<String>();
        LOLoad load = new LOLoad(schema, plan, filename);
        return buildOp( loc, load, alias, tmp, null );
    }

    String buildStoreOp(SourceLocation loc, String alias, String inputAlias, String filename, Object funcSpec)
            throws ParserValidationException {
        try {
            // Load StoreFunc class from default properties if funcSpec is null. Fallback on PigStorage if StoreFunc is not specified in properties.

            LOStore op = new LOStore(plan, filename, null, null);
            return buildOp(loc, op, alias, inputAlias, null);
        } catch(Exception ex) {
            throw new ParserValidationException(intStream, loc, ex);
        }
    }
}
