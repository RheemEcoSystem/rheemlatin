package org.qcri.rheem.latin.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.qcri.rheem.latin.plan.LatinPlan;
import org.qcri.rheem.latin.plan.addons.enviroment.LatinEnviroment;
import org.qcri.rheem.latin.plan.addons.enviroment.LatinImportClass;
import org.qcri.rheem.latin.plan.addons.structure.Bag.LatinBag;
import org.qcri.rheem.latin.plan.addons.structure.LatinStructure;
import org.qcri.rheem.latin.plan.operator.*;
import org.qcri.rheem.latin.plan.operator.expression.*;
import org.qcri.rheem.latin.plan.operator.logical.ManyOperator;
import org.qcri.rheem.latin.plan.operator.logical.SinkOperator;
import org.qcri.rheem.latin.plan.operator.logical.SourceOperator;
import org.qcri.rheem.latin.util.LatinException;

import java.util.*;

/**
 * Created by bertty on 06-04-17.
 */
public class ConvertListener implements LatinParserListener{
    private AbstractPlan plan = null;
//TODO: ver si se envian a los siguiente step o se pierden
    private Stack<LatinExpression> expressions  = null;

    private Collection<String> all_alias = null;

    private List<LatinOperator> operators    = null;

    private Stack<ConstantExpression> constants = null;

    private Map<String, LatinOperator> map_alias = null;

    private LatinOperator operator_actual = null;

    private Deque<String> input_alias = null;

    private String alias_actual = null;

    private List<SinkOperator> sinkOperators = null;

    private List<SourceOperator> sourceOperators = null;

    private String name_sourceOperator;

    private List<String> source_name_var;

    private List<String> source_type_var;

    private Map<String, LatinEnviroment> enviromentMap = null;

    private Map<String, LatinStructure> structureMap = null;

    private String alias_bag_current = null;

    private LatinStructure structure_curret = null;

    private String type_current = null;

    public ConvertListener(){
        this.plan        = new AbstractPlan();
        this.expressions = new Stack<LatinExpression>();
        this.operators   = new ArrayList<LatinOperator>();
        this.constants   = new Stack<ConstantExpression>();
        this.map_alias   = new HashMap<String, LatinOperator>();
        this.input_alias      = new LinkedList<String>();
        this.sinkOperators   = new ArrayList<SinkOperator>();
        this.sourceOperators = new ArrayList<SourceOperator>();
        this.all_alias     = new ArrayList<String>();
        this.enviromentMap = new HashMap<String, LatinEnviroment>();
        this.structureMap  = new HashMap<String, LatinStructure>();
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
            this.plan.setEnviroments(this.enviromentMap);
            //TODO: agregar el ambiente y los estructureas
        }catch (Exception ex){
            ex.printStackTrace();
            System.exit(-105);
        }
    }

    @Override
    public void enterBaseStatement(LatinParser.BaseStatementContext ctx) {
        this.alias_actual = ctx.ID().getText();
        addAlias(this.alias_actual);
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
    public void enterBagStatement(LatinParser.BagStatementContext ctx) {

        if( this.alias_bag_current != null ){
            //TODO: make a good exception description
            throw new LatinException("the alias bag have a problem");
        }
        String alias = ctx.ID().getText();
       // System.out.println("entrando BAG: "+alias);
        this.alias_bag_current = alias;
        addAlias(this.alias_bag_current);
        this.structure_curret = new LatinBag(this.alias_bag_current);
    }

    @Override
    public void exitBagStatement(LatinParser.BagStatementContext ctx) {
        this.structureMap.put(this.alias_bag_current, this.structure_curret);
        this.structure_curret = null;
        this.alias_bag_current = null;
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
        if(this.input_alias.size() ==  0){
            return;
        }

        if(!( this.operator_actual instanceof ManyOperator) ){
            return;
        }

        if(this.input_alias.size() != ((ManyOperator)this.operator_actual).getNinputs()){
            /**
             * TODO: GENERARA EXCEPTION para esta situacion
             */
            //throw new Exception("the quantity alias is diferent");
            this.input_alias.clear();
            return;
        }

        int i = 0;
        ManyOperator tmp = (ManyOperator)this.operator_actual;
        for(String name: this.input_alias){
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

        this.input_alias.clear();

    }



    @Override
    public void enterLambda(LatinParser.LambdaContext ctx) {
        if( ctx.ID() != null ){
            this.input_alias.add(ctx.ID().getText());
        }
    }

    @Override
    public void exitLambda(LatinParser.LambdaContext ctx) {
    }

    @Override
    public void enterReal_function(LatinParser.Real_functionContext ctx) {
        String alias       = ctx.ID().get(0).toString();
        String class_name  = ctx.ID().get(1).toString();
        String method_name = ctx.ID().get(2).toString();

        String _alias  = class_name+"#"+method_name;

        if( ! this.expressions.empty() ){
            //TODO: create a good description
            throw new LatinException("error with the function");
        }

        if( !this.enviromentMap.containsKey(class_name)){
            //TODO: create a good description
            throw new LatinException("la clase no es clase");
        }

        LatinImportClass clazz = (LatinImportClass) this.enviromentMap.get(class_name);

        RealFunctionExpression real = new RealFunctionExpression(_alias, clazz, method_name );

        this.expressions.push(real);
        this.input_alias.push(alias);

    }

    @Override
    public void exitReal_function(LatinParser.Real_functionContext ctx) {

    }

    @Override
    public void enterType(LatinParser.TypeContext ctx) {

    }

    @Override
    public void exitType(LatinParser.TypeContext ctx) {
        String real_type = null;
        if(ctx.ID() != null){
            real_type = ctx.ID().getText();

        }else  if(ctx.BOOLEAN() != null){
            real_type = ctx.BOOLEAN().getText();

        }else  if(ctx.INT() != null){
            real_type = ctx.INT().getText();

        }else  if(ctx.LONG() != null){
            real_type = ctx.LONG().getText();

        }else  if(ctx.FLOAT() != null){
            real_type = ctx.FLOAT().getText();

        }else  if(ctx.BIGDECIMAL() != null){
            real_type = ctx.BIGDECIMAL().getText();

        }else  if(ctx.BIGINTEGER() != null){
            real_type = ctx.BIGINTEGER().getText();

        }else  if(ctx.DOUBLE() != null){
            real_type = ctx.DOUBLE().getText();

        }else  if(ctx.DATETIME() != null){
            real_type = ctx.DATETIME().getText();

        }else  if(ctx.STRING() != null){
            real_type = ctx.STRING().getText();
        }

        if(this.type_current != null){
            throw new LatinException("the type \""+this.type_current+"\" is never used");
        }
        this.type_current = real_type;
       // System.out.println("tu type sexy: "+this.type_current);
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
    public void enterWith_broadcast(LatinParser.With_broadcastContext ctx) {
        this.operator_actual.setBroadcast(ctx.ID().toString());
    }

    @Override
    public void exitWith_broadcast(LatinParser.With_broadcastContext ctx) {

    }

    @Override
    public void enterBag_stattement(LatinParser.Bag_stattementContext ctx) {
        String alias_input = ctx.ID().getText();
        if(!existAlias(alias_input)){
            //TODO: create a best description to the exception
            throw new LatinException("Alias not found in the previous elements");
        }
       // System.out.println("?===== "+alias_input);
        ((LatinBag)this.structure_curret).setAliasInput(alias_input);
    }

    @Override
    public void exitBag_stattement(LatinParser.Bag_stattementContext ctx) {
    }

    @Override
    public void enterBag_header(LatinParser.Bag_headerContext ctx) {

    }

    @Override
    public void exitBag_header(LatinParser.Bag_headerContext ctx) {

    }

    @Override
    public void enterBag_header_titles(LatinParser.Bag_header_titlesContext ctx) {
        if( this.structure_curret == null ){
            //TODO: Write a exception that explain more the problem
            throw new LatinException("is not posible assign the parametres");
        }
        ((LatinBag)this.structure_curret).openStage();
    }

    @Override
    public void exitBag_header_titles(LatinParser.Bag_header_titlesContext ctx) {
        if( this.structure_curret == null ){
            //TODO: Write a exception that explain more the problem
            throw new LatinException("is not posible assign the parametres");
        }
        ((LatinBag)this.structure_curret).closeStage();
    }

    @Override
    public void enterBag_header_element(LatinParser.Bag_header_elementContext ctx) {
        //System.out.println(ctx.QUOTEDSTRING());
        if( this.type_current != null ){
            //TODO: Write a exception that explain more the problem
            throw new LatinException("The Type is not null for this processing "+this.type_current);
        }
    }

    @Override
    public void exitBag_header_element(LatinParser.Bag_header_elementContext ctx) {
      //  System.out.println(ctx.QUOTEDSTRING());
        if( this.type_current == null ){
            this.type_current = "STRING";
        }
       // System.out.println("type is: "+this.type_current);
        if( this.structure_curret == null ){
            //TODO: Write a exception that explain more the problem
            throw new LatinException("is not posible assign the parametres");
        }
        ((LatinBag)this.structure_curret).addHeader(ctx.QUOTEDSTRING().toString(), this.type_current);
        this.type_current = null;
    }

    @Override
    public void enterBag_header_params(LatinParser.Bag_header_paramsContext ctx) {

    }

    @Override
    public void exitBag_header_params(LatinParser.Bag_header_paramsContext ctx) {

    }

    @Override
    public void enterBag_set_param(LatinParser.Bag_set_paramContext ctx) {
        if(this.alias_bag_current != null){
            throw new LatinException("The current bag is not null, the parameters is not setting how correspond");
        }
        this.alias_bag_current = ctx.ID(0).getText();
        this.structure_curret = this.structureMap.get(this.alias_bag_current);
     //   System.out.println("ajhaskjhdakjsdjkashdkjashdljashjd");
   //     System.out.println(this.alias_bag_current);

        //if(this.structure_curret != null)
       //     System.out.println("tengo algo");
    }

    @Override
    public void exitBag_set_param(LatinParser.Bag_set_paramContext ctx) {
        System.out.println("new BAG "+((LatinBag)this.structure_curret));
        this.structure_curret = null;
        this.alias_bag_current = null;
    }


    @Override
    public void enterClassDefine(LatinParser.ClassDefineContext ctx) {
        String name = ctx.ID().getText();
        String path  = getString(ctx.QUOTEDSTRING().getText());
        addAlias(name);
        LatinImportClass importClass = new LatinImportClass(name, path);
        this.enviromentMap.put(name, importClass);
    }

    @Override
    public void exitClassDefine(LatinParser.ClassDefineContext ctx) {

    }

    @Override
    public void enterInclude_statement(LatinParser.Include_statementContext ctx) {
    }

    @Override
    public void exitInclude_statement(LatinParser.Include_statementContext ctx) {

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

    private void addAlias(String alias){
        if( this.all_alias.contains(alias) ) {
            //TODO: add exception for alias repetida
            throw new LatinException("error the alias "+alias);
        }
        this.all_alias.add(alias);
    }

    private boolean existAlias(String alias){
        return this.all_alias.contains(alias);
    }
}
