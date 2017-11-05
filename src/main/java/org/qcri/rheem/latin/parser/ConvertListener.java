package org.qcri.rheem.latin.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.qcri.rheem.latin.plan.LatinPlan;
import org.qcri.rheem.latin.plan.operator.LatinExpression;
import org.qcri.rheem.latin.plan.operator.LatinOperator;
import org.qcri.rheem.latin.plan.operator.OperatorBuilder;
import org.qcri.rheem.latin.plan.operator.OperatorInput;
import org.qcri.rheem.latin.plan.operator.expression.*;
import org.qcri.rheem.latin.plan.operator.logical.ManyOperator;
import org.qcri.rheem.latin.plan.operator.logical.SinkOperator;
import org.qcri.rheem.latin.plan.operator.logical.SourceOperator;

import java.util.*;

/**
 * Created by bertty on 06-04-17.
 */
public class ConvertListener implements LatinParserListener{
    private AbstractPlan plan = null;

    private Stack<LatinExpression> expressions  = null;


    private List<LatinOperator> operators    = null;

    private Stack<ConstantExpression> constants = null;

    private Map<String, LatinOperator> map_alias = null;

    private LatinOperator operator_actual = null;

    private Deque<String> alias = null;

    private String alias_actual = null;

    private List<SinkOperator> sinkOperators = null;

    private List<SourceOperator> sourceOperators = null;

    private String name_sourceOperator;

    private List<String> source_name_var;
    private List<String> source_type_var;

    public ConvertListener(){
        this.plan        = new AbstractPlan();
        this.expressions = new Stack<LatinExpression>();
        this.operators   = new ArrayList<LatinOperator>();
        this.constants   = new Stack<ConstantExpression>();
        this.map_alias   = new HashMap<String, LatinOperator>();
        this.alias       = new LinkedList<String>();
        this.sinkOperators   = new ArrayList<SinkOperator>();
        this.sourceOperators = new ArrayList<SourceOperator>();
    }

    public LatinPlan getPlan(){
        return this.plan;
    }

    @Override
    public void enterQuery(LatinParser.QueryContext ctx) {

    }

    @Override
    public void exitQuery(LatinParser.QueryContext ctx) {
        try {
            for (LatinOperator ele : this.operators) {
                if (ele instanceof SourceOperator) {
                    continue;
                }
                if (ele instanceof OperatorInput) {
                    OperatorInput operator = (OperatorInput) ele;

                    int length = operator.getNinputs();

                    for (int i = 0; i < length; i++) {
                        LatinOperator op = this.map_alias.get(operator.getAliasInput(i));
                        operator.setOperatorInput(i, op);
                        operator.setClassInput(i, op.getClassOutput());
                    }
                    operator.isValid();
                    continue;
                }
            }
            ArrayList<String> list_alias = new ArrayList<>();
            for (String name_alias : this.map_alias.keySet()) {
                list_alias.add(name_alias);
            }
            this.plan.setAlias(list_alias);
            this.plan.setAliasOperators(this.map_alias);
            this.plan.setOperators(this.operators);
            this.plan.setExpressions(this.expressions);
            this.plan.setSinkOperators(this.sinkOperators);
            this.plan.setSourceOperators(this.sourceOperators);
        }catch (Exception ex){
            ex.printStackTrace();
            System.exit(-105);
        }
    }

    @Override
    public void enterBaseStatement(LatinParser.BaseStatementContext ctx) {
        this.alias_actual = ctx.ID().getText();
    }

    @Override
    public void exitBaseStatement(LatinParser.BaseStatementContext ctx) {
        this.alias_actual = null;
    }

    @Override
    public void enterSinkStatement(LatinParser.SinkStatementContext ctx) {
    }

    @Override
    public void exitSinkStatement(LatinParser.SinkStatementContext ctx) {

    }


    @Override
    public void enterOperatorStatement(LatinParser.OperatorStatementContext ctx) {
        ManyOperator operator = OperatorBuilder.getOperatorMany(ctx.OPERATOR_NAME().getText());
        this.map_alias.put(this.alias_actual, operator);
        operator.setAlias(this.alias_actual);
        this.operators.add(operator);
        this.operator_actual = operator;


    }

    @Override
    public void exitOperatorStatement(LatinParser.OperatorStatementContext ctx){
        if(this.alias.size() ==  0){
            return;
        }

        if(!( this.operator_actual instanceof ManyOperator) ){
            return;
        }

        if(this.alias.size() != ((ManyOperator)this.operator_actual).getNinputs()){
            /**
             * GENERARA EXCEPTION para esta situacion
             */
            //throw new Exception("the quantity alias is diferent");
            this.alias.clear();
            return;
        }

        int i = 0;
        ManyOperator tmp = (ManyOperator)this.operator_actual;
        for(String name: this.alias){
            tmp.setAliasInput(i++, name);
        }
        if(tmp.getNinputs() != 0 && this.expressions.size() <= tmp.getNinputs()) {
            int count = (this.expressions.size() < tmp.getNinputs())? this.expressions.size(): tmp.getNinputs();

            while(--count >= 0){
                tmp.setExpressionInput(count, this.expressions.pop());
            }
        }else if(this.expressions.size() > tmp.getNinputs()){
            //throw new RecognitionException("error");
        }
       // this.expressions = null;

        this.alias.clear();

    }



    @Override
    public void enterLambda(LatinParser.LambdaContext ctx) {
        if( ctx.ID() != null ){
            this.alias.add(ctx.ID().getText());
        }
    }

    @Override
    public void exitLambda(LatinParser.LambdaContext ctx) {
    }

    @Override
    public void enterType(LatinParser.TypeContext ctx) {

    }

    @Override
    public void exitType(LatinParser.TypeContext ctx) {

    }


    @Override
    public void enterSource_statement(LatinParser.Source_statementContext ctx) {
        this.name_sourceOperator = ctx.LOAD().getSymbol().getText();
        /** En caso de ser en memoria se debe hacer algo para cambiar el tipo
         *  la ruta de acceso debe entregar algun objeto para poder establecer el link de dicho elemento.
         * */
        //    operator.setClassOutput(String.class);
        SourceOperator operator = OperatorBuilder.getOperatorSource(this.name_sourceOperator);
        this.operator_actual = operator;
    }

    @Override
    public void exitSource_statement(LatinParser.Source_statementContext ctx) {
        SourceOperator operator = (SourceOperator) this.operator_actual;
        operator.setPath_source(getString(ctx.QUOTEDSTRING().getText()));

        if(this.source_name_var != null)
            operator.setName_var(this.source_name_var.toArray( new String[0] ) );

        if(this.source_type_var != null)
            operator.setType_var(this.source_type_var.toArray( new String[0] ) );

        this.sourceOperators.add(operator);
        this.operators.add(operator);
        this.map_alias.put(this.alias_actual, operator);
        operator.setAlias(this.alias_actual);

        this.name_sourceOperator = null;
        this.source_name_var = null;
        this.source_type_var = null;
    }

    @Override
    public void enterAs_clause(LatinParser.As_clauseContext ctx) {
        this.source_name_var = new ArrayList<>();
        this.source_type_var = new ArrayList<>();

    }

    @Override
    public void exitAs_clause(LatinParser.As_clauseContext ctx) {

    }

    @Override
    public void enterType_load(LatinParser.Type_loadContext ctx) {
        if( ctx == null ){
            return;
        }
        this.name_sourceOperator = "LOAD" + ctx.getText();
    }

    @Override
    public void exitType_load(LatinParser.Type_loadContext ctx) {

    }

    @Override
    public void enterPair(LatinParser.PairContext ctx) {
        if(ctx.ID() != null){
            for(TerminalNode node: ctx.ID()) {
                this.source_name_var.add( node.getText() );
            }
            for(LatinParser.TypeContext type: ctx.type()){
                this.source_type_var.add(type.getText());
            }
        }
        if(ctx.QUOTEDSTRING() != null){
            for(TerminalNode node: ctx.QUOTEDSTRING()) {
                this.source_name_var.add( getString(node.getText()) );
            }

        }
    }

    @Override
    public void exitPair(LatinParser.PairContext ctx) {

    }

    @Override
    public void enterSink_statement(LatinParser.Sink_statementContext ctx) {

        SinkOperator operator = OperatorBuilder.getOperatorSink(ctx.OPERATOR_NAME().getText());
        operator.setPath_source(getString(ctx.QUOTEDSTRING().getText()));
        /** En caso de ser en memoria se debe hacer algo para cambiar el tipo
         *  la ruta de acceso debe entregar algun objeto para poder establecer el link de dicho elemento.
         * */
        //    operator.setClassOutput(String.class);
        this.sinkOperators.add(operator);
        this.operators.add(operator);
        String alias = "alias"+this.sinkOperators.size();
        this.map_alias.put(alias, operator);
        operator.setAlias(alias);
        operator.setAliasInput(ctx.ID().getText());
    }

    @Override
    public void exitSink_statement(LatinParser.Sink_statementContext ctx) {

    }

    @Override
    public void enterExpr(LatinParser.ExprContext ctx) {
        if(ctx.op != null) {
            if(ctx.BINOP() != null) {
                return;
            }else if(ctx.POSTOP() != null){
                LatinExpression left = this.expressions.pop();
                UnaryExpression unary = (UnaryExpression) OperatorBuilder.getExpression(ctx.getText());
                unary.setBranch( left );
                this.expressions.push( unary );
            }
            return;
        }
    }

    @Override
    public void exitExpr(LatinParser.ExprContext ctx) {
        if(ctx.op == null){
            return;
        }
        if( ctx.BINOP() != null){
            BinaryExpression binary = (BinaryExpression) OperatorBuilder.getExpression(ctx.BINOP(0).getText());
            LatinExpression right    = this.expressions.pop();
            LatinExpression left    = this.expressions.pop();
            binary.setLeft_branch(left);
            binary.setRight_branch(right);
            this.expressions.push(binary);
        }

    }

    @Override
    public void enterNumberExpression(LatinParser.NumberExpressionContext ctx) {

    }

    @Override
    public void exitNumberExpression(LatinParser.NumberExpressionContext ctx) {

    }

    @Override
    public void enterParenExpression(LatinParser.ParenExpressionContext ctx) {
    }

    @Override
    public void exitParenExpression(LatinParser.ParenExpressionContext ctx) {

    }

    @Override
    public void enterPrefixExpression(LatinParser.PrefixExpressionContext ctx) {

    }

    @Override
    public void exitPrefixExpression(LatinParser.PrefixExpressionContext ctx) {

    }

    @Override
    public void enterFunctionExpression(LatinParser.FunctionExpressionContext ctx) {

    }

    @Override
    public void exitFunctionExpression(LatinParser.FunctionExpressionContext ctx) {
    }

    @Override
    public void enterFunctionExpr(LatinParser.FunctionExprContext ctx) {

    }

    @Override
    public void exitFunctionExpr(LatinParser.FunctionExprContext ctx) {
        if( ctx.FUNC_NAME() != null ){
            if(ctx.expr().size() <= this.expressions.size()) {
                FunctionExpression func = OperatorBuilder.getFunction(ctx.FUNC_NAME().getText());

                func.setNparams(ctx.expr().size());

                int nparams = (func.getNparams() < this.expressions.size()) ? func.getNparams() : this.expressions.size();

                while (--nparams >= 0) {
                    func.setParam(nparams, this.expressions.pop());
                }
                this.expressions.push(func);
            }
        }
    }

    @Override
    public void enterConstant(LatinParser.ConstantContext ctx) {
        if( ctx.ID() != null ){
            this.expressions.push(
                new SubIdExpression(
                    "subID_"+ctx.getText(),
                    ctx.ID().getText()
                )
            );

        }
        if( ctx.NUMBER() != null ){
            this.expressions.push(
                    new ConstantExpression<Double>(
                            "number_"+ctx.NUMBER().getText(),
                            Double.parseDouble( ctx.NUMBER().getText() )
                    )
            );
            return;
        }
        if( ctx.QUOTEDSTRING() != null ){
            this.expressions.push(
                    new ConstantExpression<String>(
                            "string_"+ctx.QUOTEDSTRING().getText(),
                            getString( ctx.QUOTEDSTRING().getText() )
                    )
            );
            return;
        }
    }

    @Override
    public void exitConstant(LatinParser.ConstantContext ctx) {

    }

    @Override
    public void enterSub_id(LatinParser.Sub_idContext ctx) {

    }

    @Override
    public void exitSub_id(LatinParser.Sub_idContext ctx) {
        this.expressions.push(
            new SubIdExpression(
                "subID_"+ctx.getText(),
                    ctx.getText()
            )
        );
    }

    @Override
    public void enterBoolean_const(LatinParser.Boolean_constContext ctx) {
        if(ctx.FALSE() != null){
            this.expressions.push(
                    new ConstantExpression<Boolean>(
                            "bool_"+ctx.getText(),
                            Boolean.FALSE
                    )
            );
            return;
        }
        if(ctx.TRUE() != null){
            this.expressions.push(
                    new ConstantExpression<Boolean>(
                            "bool_"+ctx.getText(),
                            Boolean.TRUE
                    )
            );
            return;
        }
    }

    @Override
    public void exitBoolean_const(LatinParser.Boolean_constContext ctx) {

    }

    @Override
    public void enterNamePlatform(LatinParser.NamePlatformContext ctx) {

    }

    @Override
    public void exitNamePlatform(LatinParser.NamePlatformContext ctx) {
        this.operator_actual.setPlatform(getString(ctx.QUOTEDSTRING().getText()));
    }


    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }

    private String getString(String text){
        return text.substring(1, text.length() - 1);
    }
}
