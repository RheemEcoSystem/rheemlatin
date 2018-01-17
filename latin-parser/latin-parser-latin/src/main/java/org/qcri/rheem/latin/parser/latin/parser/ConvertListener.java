package org.qcri.rheem.latin.parser.latin.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.qcri.rheem.latin.core.plan.LatinPlan;
import org.qcri.rheem.latin.core.plan.enviroment.ClassEnviroment;
import org.qcri.rheem.latin.core.plan.enviroment.LatinEnviroment;
import org.qcri.rheem.latin.core.plan.expression.*;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;
import org.qcri.rheem.latin.core.plan.operator.OperatorInput;
import org.qcri.rheem.latin.core.plan.operator.OperatorOutput;
import org.qcri.rheem.latin.core.plan.operator.logical.*;
import org.qcri.rheem.latin.core.plan.structure.BagStructure;
import org.qcri.rheem.latin.core.plan.structure.LatinStructure;
import org.qcri.rheem.latin.core.plan.structure.bag.RecordBag;
import org.qcri.rheem.latin.parser.latin.context.LoadMockupClass;
import org.qcri.rheem.latin.parser.latin.context.ParserLatinContext;
import org.qcri.rheem.latin.parser.latin.exception.ParserLatinException;
import org.qcri.rheem.latin.parser.latin.plan.ParserLatinPlan;


import java.util.*;

public class ConvertListener implements LatinParserListener
{
    private LatinPlan plan;
    //TODO: ver si se envian a los siguiente step o se pierden
    private Stack<LatinExpression> expressions  = null;

    private Collection<String> all_alias = null;

    private List<LatinOperator> operators    = null;
    private List<LatinOperator> operators_wrapper    = null;

    private Stack<ConstantExpression> constants = null;

    private Map<String, LatinOperator> map_alias = null;
    private Map<String, LatinOperator> map_alias_wrapper = null;

    private Map<String, String> map_getAlias = null;

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

    private String alias_structure_current = null;

    private LatinStructure structure_curret = null;

    private String type_current = null;

    private LoadMockupClass operator_builder = null;

    public ConvertListener(){
        this.plan              = new ParserLatinPlan();
        this.expressions       = new Stack<LatinExpression>();
        this.operators         = new ArrayList<LatinOperator>();
        this.operators_wrapper = new ArrayList<LatinOperator>();
        this.constants         = new Stack<ConstantExpression>();
        this.map_alias         = new HashMap<String, LatinOperator>();
        this.map_alias_wrapper = new HashMap<String, LatinOperator>();
        this.map_getAlias      = new HashMap<String, String>();
        this.input_alias       = new LinkedList<String>();
        this.sinkOperators     = new ArrayList<SinkOperator>();
        this.sourceOperators   = new ArrayList<SourceOperator>();
        this.all_alias         = new ArrayList<String>();
        this.enviromentMap     = new HashMap<String, LatinEnviroment>();
        this.structureMap      = new HashMap<String, LatinStructure>();
        this.operator_builder  = ParserLatinContext.getLoaderClass();
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
                    OperatorInput op_current = (OperatorInput) ele;
                    int length = op_current.getSizeInput();

                    for (int i = 0; i < length; i++) {

                        String key = this.map_getAlias.get(op_current.getAliasInput(i));
                        key = (key == null || key.compareTo( ele.getAlias()) == 0)? op_current.getAliasInput(i): key;

                        if(key != op_current.getAliasInput(i)){
                            op_current.setAliasInput(i, key);
                        }

                        LatinOperator op_next = this.map_alias.get(key);

                        if( !(op_next instanceof OperatorOutput) ){
                            throw new ParserLatinException(
                                    String.format("the Operator (%s) not have outputs", op_next)
                            );
                        }

                        if(op_next instanceof WrapperOperator){
                            //TODO: hacerlo generico para los casos en que es mas de uno
                            op_current.setAliasInput(i, ((WrapperOperator)op_next).getAlias_output().get(0));
                            op_next = this.map_alias_wrapper.get(op_current.getAliasInput(i));
                        }

                        if(op_next == null){
                            //TODO: hacer un mensaje mas descriptivo
                            throw new ParserLatinException(
                                    String.format("the Operator (%s) not existe the", op_current)
                            );
                        }

                        op_current.setOperatorInput(i, op_next);
                        //TODO: ver como hacer que sea parametrico para el caso de los outputs
                        ((OperatorOutput)op_next).setOperatorOutput(0, ele);
                        ((OperatorOutput)op_next).setAliasOutput(0, ele.getAlias());

                        op_current.setTypeInput(i, ((OperatorOutput)op_next).getTypeOutput(0));
                    }
                    ele.changeTypes();
                    //TODO: hacer parametrico
                    if(ele instanceof OperatorOutput){
                        OperatorInput input = (OperatorInput) ((OperatorOutput) ele).getOperatorOutput(0);
                        if(input != null) {
                            for (int i = 0; i < input.getSizeInput(); i++) {
                                if (input.getOperatorInput(i) == ele) {
                                    input.setTypeInput(i, ((OperatorOutput) ele).getTypeOutput(0));
                                }
                            }
                        }
                    }
                    continue;
                }
            }
            ArrayList<LatinOperator> rm_operators= new ArrayList<>();

            for(LatinOperator ele: this.operators_wrapper){
                if( ! ele.isWrapped() ){
                    throw new ParserLatinException(
                            String.format("the Operator (%s) is wrapped for othre operator", ele)
                    );
                }

                WrapperOperator myWrapper = (WrapperOperator) ele.getWrapper();
                this.map_alias.put(ele.getAlias(), ele);
                if (ele instanceof SourceOperator) {
                    continue;
                }
                if (ele instanceof OperatorInput){
                    OperatorInput op_current = (OperatorInput) ele;

                    //set function udf
                    String[] expressions_alias = op_current.getExpressionsAliasInput();
                    String[] expressions_MyWrapper = myWrapper.getExpressionsAliasInput();

                    int length = expressions_alias.length;
                    for(int i = 0; i < length; i++){
                        for(int j = 0; j < expressions_MyWrapper.length; j++){
                            if (expressions_MyWrapper[j] == null){
                                continue;
                            }
                            if(expressions_MyWrapper[j].compareTo(expressions_alias[i]) == 0 ){
                                op_current.setExpressionInput(i, myWrapper.getExpressionInput(j));
                            }
                        }
                    }

                    //set function statics
                    for(int i = 0; i < length; i++){
                        if( op_current.getExpressionInput(i) != null){
                            continue;
                        }
                        LatinExpression expre = myWrapper.getExpressionMap(op_current.getExpressionAliasInput(i));
                     /*   if(expre == null){
                            //TODO mensaje mas descriptivo
                            throw new ParserLatinException(
                                    String.format("No existe funcion para el operador")
                            );
                        }*/
                        op_current.setExpressionInput(i, expre);
                    }

                    //set operators
                    length = op_current.getSizeInput();
                    for (int i = 0; i < length; i++) {
                        String current_alias_input =  op_current.getAliasInput(i);
                        LatinOperator op_next = this.map_alias_wrapper.get(current_alias_input);

                        if(op_next == null){
                            op_next = this.map_alias.get(myWrapper.getAliasInputReal(current_alias_input));
                        }

                        op_current.setOperatorInput(i, op_next);
                        op_current.setAliasInput(i, op_next.getAlias());
                        if( !(op_next instanceof OperatorOutput) ){
                            throw new ParserLatinException(
                                    String.format("the Operator (%s) not have outputs", op_next)
                            );
                        }
                        ((OperatorOutput)op_next).setOperatorOutput(0, ele);
                        ((OperatorOutput)op_next).setAliasOutput(0, ele.getAlias());
                        //TODO: ver como hacer que sea parametrico para el caso de los outputs
                        op_current.setTypeInput(i, ((OperatorOutput)op_next).getTypeOutput(0));
                    }

                }
                ele.changeTypes();
                //TODO: hacer parametrico
                if(ele instanceof OperatorOutput){

                    String output_alias = ((OperatorOutput) ele).getAliasOutput(0);
                    if(output_alias != null) {
                        OperatorInput op_prev = (OperatorInput) this.map_alias_wrapper.get(output_alias);
                        if (op_prev == null) {
                            op_prev = (OperatorInput) this.map_alias.get(output_alias);
                        }


                        for (int i = 0; i < op_prev.getSizeInput(); i++) {
                            if (op_prev.getAliasInput(i).compareTo(ele.getAlias()) == 0) {
                                op_prev.setTypeInput(i, ((OperatorOutput) ele).getTypeOutput(0));
                            }
                        }
                    }
                }

                if( ! rm_operators.contains(myWrapper)){
                    rm_operators.add(myWrapper);
                }
            }

            this.operators.removeAll(rm_operators);
            this.operators.addAll(this.operators_wrapper);

            for(LatinOperator operator: this.operators){
                if(operator instanceof OperatorInput){
                    OperatorInput op = (OperatorInput) operator;
                    for(int i = 0; i < op.getSizeInput(); i++){
                        if(op.getTypeInput(i) == null){
                            OperatorOutput previuos = (OperatorOutput) this.map_alias.get(op.getAliasInput(i));
                            //TODO hacerlo para que sea generico
                            if(previuos.getTypeOutput(0) == null){
                                ((LatinOperator)previuos).changeTypes();
                                op.setTypeInput(0, previuos.getTypeOutput(0));
                            }

                            //TODO hacerlo para que sea generico
                            if(previuos.getTypeOutput(0) == null){
                                throw new ParserLatinException(
                                        String.format("Not exist class for conexion beetween %s and %s", operator, previuos)
                                );
                            }

                            op.setTypeInput(i, previuos.getTypeOutput(0));
                        }
                    }
                }
            }

            //TODO eliminar tambien del map para que sea consistente  y agregar los nuevos elementos



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
            System.exit(-1);
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
        if( this.alias_structure_current != null ){
            //TODO: make a good exception description
            throw new ParserLatinException("the alias bag have a problem");
        }

        if(this.operator_actual != null ){
            //TODO: make a good exception description
            throw new ParserLatinException("the alias bag have a problem22"+this.operator_actual);
        }
        String alias = ctx.ID().getText();
        this.alias_structure_current = alias;
        addAlias(this.alias_structure_current);
        this.structure_curret = new BagStructure(this.alias_structure_current);
    }

    @Override
    public void exitBagStatement(LatinParser.BagStatementContext ctx) {
        String alias = ctx.ID().getText();
        if( alias.compareTo(this.alias_structure_current) != 0){
            //TODO: create a good message for the exception
            throw new ParserLatinException("existe un problema con las BAG");
        }

        if(this.operator_actual != null ){
            //TODO: make a good exception description
            throw new ParserLatinException("the alias bag have a problem22");
        }

        this.structureMap.put(this.alias_structure_current, this.structure_curret);
        //convert the bag in operator
        BagOperator bagOperator = new BagOperator("BAG", 1, 1);
        bagOperator.setAlias(this.alias_structure_current);
        bagOperator.setStructure_info(this.structure_curret);

        bagOperator.setAliasInput(0, ((BagStructure)this.structure_curret).getAlias_input());
        bagOperator.setTypeOutput(0, RecordBag.class);


        bagOperator.setExpressionInput(0,((BagStructure)this.structure_curret).getExpressionSplit());

        this.map_alias.put(this.alias_structure_current, bagOperator);
        this.operators.add(bagOperator);

        this.structure_curret = null;
        this.alias_structure_current = null;
    }


    @Override
    public void enterOperatorStatement(LatinParser.OperatorStatementContext ctx) {
        ManyOperator operator = this.operator_builder.getOperatorMany(ctx.OPERATOR_NAME().getText());
        operator.setAlias(this.alias_actual);

        this.map_alias.put(this.alias_actual, operator);
        this.operators.add(operator);

        if(operator instanceof WrapperOperator){
            Map<String, LatinOperator> operators = ((WrapperOperator)operator).getWrapped();
            for(Map.Entry<String, LatinOperator> op: operators.entrySet()){
                this.map_alias_wrapper.put(op.getKey(), op.getValue());
                this.operators_wrapper.add(op.getValue());;
                this.addAlias(op.getKey());
            }
        }

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

        if(this.input_alias.size() != ((ManyOperator)this.operator_actual).getSizeInput()){
            //TODO: GENERARA EXCEPTION para esta situacion
            //throw new exception("the quantity alias is diferent");
            this.input_alias.clear();
            return;
        }
        int i = 0;
        ManyOperator tmp = (ManyOperator)this.operator_actual;
        for(String name: this.input_alias){
            tmp.setAliasInput(i++, name);
        }

        if(tmp.getSizeInput() != 0 && this.expressions.size() <= tmp.getSizeInput()) {
            int count = (this.expressions.size() < tmp.getSizeInput())? this.expressions.size(): tmp.getSizeInput();

            while(--count >= 0){
                LatinExpression expression_tmp = this.expressions.pop();
                if(expression_tmp instanceof SubIDExpression){
                    SubIDExpression subIDexpre = (SubIDExpression) expression_tmp;
                    String key = subIDexpre.getReference();

                    LatinStructure structure = this.structureMap.get(key);
                    if(structure == null){
                        structure = new BagStructure("tmp");
                    }
                    if(structure != null && (structure instanceof BagStructure) ) {
                        expression_tmp = ((BagStructure)structure).getExpressionKey(subIDexpre.getComponente());
                    }
                }
                tmp.setExpressionInput(count, expression_tmp);
            }
        }else if(this.expressions.size() > tmp.getSizeInput()){
            //TODO: colocar mensaje significativo
            throw new ParserLatinException("error");
        }


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

      /*  if( ! this.expressions.empty() ){
            //TODO: create a good description
            System.out.println(_alias);
            throw new ParserLatinException("error with the function");
        }*/

        if( !this.enviromentMap.containsKey(class_name)){
            //TODO: create a good description
            throw new ParserLatinException("la clase no es clase "+class_name);
        }

        ClassEnviroment clazz = (ClassEnviroment) this.enviromentMap.get(class_name);

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
            throw new ParserLatinException("the type \""+this.type_current+"\" is never used");
        }
        this.type_current = real_type;

    }


    @Override
    public void enterSource_statement(LatinParser.Source_statementContext ctx) {
        this.name_sourceOperator = ctx.LOAD().getSymbol().getText();
        // En caso de ser en memoria se debe hacer algo para cambiar el tipo
        //  la ruta de acceso debe entregar algun objeto para poder establecer el link de dicho elemento.
        //    operator.setClassOutput(String.class);
        SourceOperator operator = this.operator_builder.getOperatorSource(this.name_sourceOperator);
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

        if(this.structure_curret != null){
            operator.setOperatorOutput(0, this.map_alias.get(this.structure_curret.getName()+"_op"));
            operator.setAliasOutput(0, this.structure_curret.getName()+"_op");
            this.map_getAlias.put(this.alias_actual, this.structure_curret.getName()+"_op");
        }


        this.name_sourceOperator = null;
        this.source_name_var = null;
        this.source_type_var = null;
        this.operator_actual = null;
        this.structure_curret = null;
    }

    @Override
    public void enterAs_clause(LatinParser.As_clauseContext ctx) {
        this.source_name_var = new ArrayList<>();
        this.source_type_var = new ArrayList<>();
        if(ctx.type_load() == null){

            if(this.structure_curret != null){
                //TODO agregar un mensaje mas descriptivo
                throw new ParserLatinException("Error");
            }

            this.structure_curret = new BagStructure(this.alias_actual +"_BAG");


        }
    }

    @Override
    public void exitAs_clause(LatinParser.As_clauseContext ctx) {
        if(ctx.type_load() == null){

            BagOperator bagOperator = new BagOperator("BAG", 1, 1);

            this.addAlias(this.alias_actual +"_BAG_op");
            bagOperator.setAlias(this.alias_actual +"_BAG_op");
            bagOperator.setStructure_info(this.structure_curret);

            bagOperator.setAliasInput(0, ((BagStructure)this.structure_curret).getAlias_input());
            bagOperator.setTypeOutput(0, RecordBag.class);

            bagOperator.setAliasInput(0, this.alias_actual);
            bagOperator.setExpressionInput(0,((BagStructure)this.structure_curret).getExpressionSplit());

            this.map_alias.put(bagOperator.getAlias(), bagOperator);

            this.operators.add(bagOperator);
        }
    }

    @Override
    public void enterDelimiter(LatinParser.DelimiterContext ctx) {

    }

    @Override
    public void exitDelimiter(LatinParser.DelimiterContext ctx) {
        if(this.structure_curret != null && ctx.DELIMITER() != null){
            ((BagStructure)this.structure_curret).setRegex(getString( ctx.QUOTEDSTRING().getText() ));
        }
    }

    @Override
    public void enterKey(LatinParser.KeyContext ctx) {
        if(this.structure_curret != null && ctx.KEY() != null){
            List<TerminalNode> primitive = ctx.QUOTEDSTRING();
            List<String> keys = new ArrayList<>(primitive.size());

            for(TerminalNode node: primitive){
                keys.add(getString(node.getText()));
            }


            ((BagStructure)this.structure_curret).setKeys(keys);
        }
    }

    @Override
    public void exitKey(LatinParser.KeyContext ctx) {

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
        if(this.operator_actual instanceof SourceOperator){
            if(this.structure_curret instanceof BagStructure){
                ((BagStructure)this.structure_curret).openStage();
                for(String value: this.source_name_var){
                    ((BagStructure)this.structure_curret).addHeader(value, "STRING");
                }
                ((BagStructure)this.structure_curret).closeStage();
            }
        }
    }

    @Override
    public void enterSink_statement(LatinParser.Sink_statementContext ctx) {

        SinkOperator operator = this.operator_builder.getOperatorSink(ctx.OPERATOR_NAME().getText());
        operator.setPath_source(getString(ctx.QUOTEDSTRING().getText()));
        // En caso de ser en memoria se debe hacer algo para cambiar el tipo
        //  la ruta de acceso debe entregar algun objeto para poder establecer el link de dicho elemento.
        //    operator.setClassOutput(String.class);
        this.sinkOperators.add(operator);
        this.operators.add(operator);
        String alias = "alias"+this.sinkOperators.size();
        this.map_alias.put(alias, operator);
        operator.setAlias(alias);
        operator.setAliasInput(0, ctx.ID().getText());
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
                UnaryExpression unary = (UnaryExpression) this.operator_builder.getExpression(ctx.getText());
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
            BinaryExpression binary = (BinaryExpression) this.operator_builder.getExpression(ctx.BINOP(0).getText());
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
                FunctionExpression func = this.operator_builder.getFunction(ctx.FUNC_NAME().getText());

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
                    new SubIDExpression(
                            "subID##"+ctx.getText(),
                            ctx.ID().getText()
                    )
            );

        }
        if( ctx.NUMBER() != null ){
            this.expressions.push(
                    new ConstantExpression<Double>(
                            "number##"+ctx.NUMBER().getText(),
                            Double.parseDouble( ctx.NUMBER().getText() )
                    )
            );
            return;
        }
        if( ctx.QUOTEDSTRING() != null ){
            this.expressions.push(
                    new ConstantExpression<String>(
                            "string##"+ctx.QUOTEDSTRING().getText(),
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
                new SubIDExpression(
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
        this.operator_actual = null;
    }

    @Override
    public void enterWith_broadcast(LatinParser.With_broadcastContext ctx) {
        this.operator_actual.addBroadcast(ctx.ID().toString());
    }

    @Override
    public void exitWith_broadcast(LatinParser.With_broadcastContext ctx) {

    }

    @Override
    public void enterBag_stattement(LatinParser.Bag_stattementContext ctx) {
        String alias_input = ctx.ID().getText();
        if(!existAlias(alias_input)){
            //TODO: create a best description to the exception
            throw new ParserLatinException("Alias not found in the previous elements");
        }

        ((BagStructure)this.structure_curret).setAliasInput(alias_input);
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
            throw new ParserLatinException("is not posible assign the parametres");
        }
        ((BagStructure)this.structure_curret).openStage();
    }

    @Override
    public void exitBag_header_titles(LatinParser.Bag_header_titlesContext ctx) {
        if( this.structure_curret == null ){
            //TODO: Write a exception that explain more the problem
            throw new ParserLatinException("is not posible assign the parametres");
        }
        ((BagStructure)this.structure_curret).closeStage();
    }

    @Override
    public void enterBag_header_element(LatinParser.Bag_header_elementContext ctx) {

        if( this.type_current != null ){
            //TODO: Write a exception that explain more the problem
            throw new ParserLatinException("The Type is not null for this processing "+this.type_current);
        }
    }

    @Override
    public void exitBag_header_element(LatinParser.Bag_header_elementContext ctx) {

        if( this.type_current == null ){
            this.type_current = "STRING";
        }

        if( this.structure_curret == null ){
            //TODO: Write a exception that explain more the problem
            throw new ParserLatinException("is not posible assign the parametres");
        }
        ((BagStructure)this.structure_curret).addHeader(getString(ctx.QUOTEDSTRING().toString()), this.type_current);
        this.type_current = null;
    }

    @Override
    public void enterBag_header_params(LatinParser.Bag_header_paramsContext ctx) {
        if(this.structure_curret == null){
            //TODO: Write a exception that explain more the problem
            throw new ParserLatinException("is not posible assign the parametres");
        }

        ((BagStructure)this.structure_curret).setRegex(getString(ctx.constant().QUOTEDSTRING().getText()));

    }

    @Override
    public void exitBag_header_params(LatinParser.Bag_header_paramsContext ctx) {
        this.expressions.pop();
    }

    @Override
    public void enterBag_set_param(LatinParser.Bag_set_paramContext ctx) {
        if(this.alias_structure_current != null){
            throw new ParserLatinException("The current bag is not null, the parameters is not setting how correspond");
        }
        this.alias_structure_current = ctx.ID(0).getText();
        this.structure_curret = this.structureMap.get(this.alias_structure_current);

    }

    @Override
    public void exitBag_set_param(LatinParser.Bag_set_paramContext ctx) {
        this.structure_curret = null;
        this.alias_structure_current = null;
    }


    @Override
    public void enterClassDefine(LatinParser.ClassDefineContext ctx) {
        String name = ctx.ID().getText();
        String path  = getString(ctx.QUOTEDSTRING().getText());
        addAlias(name);
        ClassEnviroment importClass = new ClassEnviroment(name, path);
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
        text = text.substring(1, text.length() - 1);
        if(text.compareToIgnoreCase("\\\\t")== 0){
            return "\t";
        }
        return text;
    }

    private void addAlias(String alias){
        if( this.all_alias.contains(alias) ) {
            //TODO: add exception for alias repetida
            throw new ParserLatinException("error the alias "+alias);
        }
        this.all_alias.add(alias);
    }

    private boolean existAlias(String alias){
        return this.all_alias.contains(alias);
    }

}
