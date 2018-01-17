package org.qcri.rheem.latin.parser.latin.context;

import org.qcri.rheem.latin.core.plan.expression.FunctionExpression;
import org.qcri.rheem.latin.core.plan.expression.LatinExpression;
import org.qcri.rheem.latin.core.plan.operator.LatinOperator;
import org.qcri.rheem.latin.core.plan.operator.logical.ManyOperator;
import org.qcri.rheem.latin.core.plan.operator.logical.SinkOperator;
import org.qcri.rheem.latin.core.plan.operator.logical.SourceOperator;
import org.qcri.rheem.latin.core.plan.operator.logical.WrapperOperator;
import org.qcri.rheem.latin.parser.latin.exception.ParserLatinException;
import org.qcri.rheem.latin.parser.latin.mapping.FunctionMapping;
import org.qcri.rheem.latin.parser.latin.mapping.MappingFinal;
import org.qcri.rheem.latin.parser.latin.mapping.OperatorMapping;
import org.qcri.rheem.latin.parser.latin.mapping.WrapperOperatorMapping;
import org.qcri.rheem.latin.parser.latin.mapping.enums.LambdaType;
import org.qcri.rheem.latin.parser.latin.mapping.enums.OperatorType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LoadMockupClass {

    private Map<String, MappingFinal> operators;
    private Map<String, MappingFinal> functions;
    private Map<String, MappingFinal> expressions;
    private Map<String, MappingFinal> wrappers;


    public LoadMockupClass(){
        this.operators = new HashMap<>();
        this.functions = new HashMap<>();
        this.expressions = new HashMap<>();
        this.wrappers = new HashMap<>();
    }

    public void addOperatorMapping(String key, MappingFinal mappingFinal){
        this.operators.put(key, mappingFinal);
    }

    public void addFunctionMapping(String key, MappingFinal mappingFinal){
        this.functions.put(key, mappingFinal);
    }

    public void addExpressionsMapping(String key, MappingFinal mappingFinal){
        this.expressions.put(key, mappingFinal);
    }

    public void addWrapperMapping(String key, MappingFinal mappingFinal){
        this.wrappers.put(key, mappingFinal);
    }

    public ManyOperator getOperatorMany(String name){
        if(this.wrappers.containsKey(name)){
            return getWrapper(name);
        }

        OperatorMapping op = (OperatorMapping) this.operators.get(name);
        int inputs = -1;
        int outputs = -1;
        if(op.getType() == OperatorType.BINARY_TO_UNARY){
            inputs = 2;
            outputs = 1;
        }

        if( op.getType() == OperatorType.UNARY_TO_UNARY){
            inputs = 1;
            outputs = 1;
        }

        if(inputs == -1 || outputs == -1){
            return null;
        }
        ManyOperator operator = new ManyOperator(op.getName(), inputs, outputs);

        LambdaType lambda = op.getLambda();
        //TODO: terminar la implementacion de las lambdas y la recuperacion ademas de los output mas genericos
        if(lambda != null) {
            //operator.setExpressionInput(op.get());
        }

        if (op.getOutput() != null){
            operator.setTypeOutput(0, op.getOutput());
        }
        return operator;
    }

    public SinkOperator getOperatorSink(String name){
        OperatorMapping op = (OperatorMapping) this.operators.get(name);
        if( op.getType() != OperatorType.SINK ){
            return null;
        }

        SinkOperator sink = new SinkOperator(op.getName(), 1,0);
        /*TODO verificar si se utiliza
        if(op.getOutput() != null){
            sink.setClassOutput(op.getOutput());
        }*/
        return sink;
    }

    public SourceOperator getOperatorSource(String name){
        OperatorMapping op = (OperatorMapping) this.operators.get(name);
        if( op.getType() != OperatorType.SOURCE ){
            return null;
        }
        SourceOperator source = new SourceOperator(op.getName(), 0, 1);

        if(op.getOutput() != null){
            source.setTypeOutput(0, op.getOutput());
        }
        return source;
    }

    public FunctionExpression getFunction(String name){
        FunctionMapping obj_fun = (FunctionMapping) this.functions.get(name);
        FunctionExpression func = new FunctionExpression(obj_fun.getName(), obj_fun.getNparam());

        func.setType(obj_fun.getType().getText());
        func.setReal_operator(obj_fun.getName());
        return func;
    }

    public LatinExpression getExpression(String name){

        //TODO: ver que como re estructurar esta parte
        /*ObjectExpression obj_exp = (ObjectExpression) ReflexBuilder.getObject(ObjectConf.OP_EXPRESSION, name);

        LatinExpression expr = null;

        if( obj_exp.getType_class().equalsIgnoreCase( ObjectConf.TYPE_EX_BINARY ) ){
            expr = new BinaryExpression(obj_exp.getName());
        }else if( obj_exp.getType_class().equalsIgnoreCase( ObjectConf.TYPE_EX_UNARY ) ||
                obj_exp.getType_class().equalsIgnoreCase( ObjectConf.TYPE_EX_POSTUN ) ){
            expr = new UnaryExpression(obj_exp.getName());
        }

        if(expr != null){
            expr.setType(obj_exp.getType());
            expr.setReal_operator(obj_exp.getReal_operator());
        }

        return expr;*/ return null;
    }

    public WrapperOperator getWrapper(String name){
        WrapperOperatorMapping wop = (WrapperOperatorMapping) this.wrappers.get(name);

        Set<Map.Entry<String, OperatorMapping>> setEntry = wop.getOperatorsWrapped().entrySet();

        HashMap<String, LatinOperator> mapLatinOperators = new HashMap<>();
        WrapperOperator wrapperOperator = new WrapperOperator(name, wop.getnInputs(), wop.getnOutput());

        for(Map.Entry<String, OperatorMapping> entry: setEntry){
            String opm_alias = entry.getKey();
            OperatorMapping opm = entry.getValue();
            LatinOperator lop = null;
            if( opm.getType() == OperatorType.BINARY_TO_UNARY || opm.getType() == OperatorType.UNARY_TO_UNARY){
                lop = this.getOperatorMany(opm.getName());
                ManyOperator many = (ManyOperator) lop;

                for(int i = 0; i < opm.getInputs_alias().size(); i++) {
                    many.setAliasInput(i, opm.getInputs_alias().get(i));
                }

                for(int i = 0; i < opm.getFunction_alias().size(); i++) {
                    many.setExpressionAliasInput(i, opm.getFunction_alias().get(i));
                }

            }else if(opm.getType() == OperatorType.SOURCE){
                lop = this.getOperatorSource(opm.getName());
                SourceOperator many = (SourceOperator) lop;
                //TODO completar este caso de los source
            }else if(opm.getType() == OperatorType.SINK){
                lop = this.getOperatorSink(opm.getName());
                SinkOperator many = (SinkOperator) lop;
                //TODO completar este caso de los sink
            }

            if(lop == null){
                //TODO colocar un mehor mensaje
                throw new ParserLatinException("the Type of the operator is bad");
            }

            lop.setAlias(opm.getAlias());
            lop.setWrapper(wrapperOperator);
            mapLatinOperators.put(opm.getAlias(), lop);
        }


        Set<Map.Entry<String, WrapperOperatorMapping.WrapperFunctionMapping>> entrys = wop.getFunctionsMapping().entrySet();

        for(Map.Entry<String, WrapperOperatorMapping.WrapperFunctionMapping> entry: entrys){
            WrapperOperatorMapping.WrapperFunctionMapping functionMapping = entry.getValue();
            if(functionMapping.isUdf()) {
                wrapperOperator.setExpressionAliasInput(functionMapping.getPosition(), functionMapping.getFunction_name());
            }else{
                wrapperOperator.putExpressionMap(functionMapping.getFunction_name(), functionMapping.getExpression());
            }
        }

        wrapperOperator.setOperators(mapLatinOperators);
        wrapperOperator.setAlias_inputs(wop.getAlias_inputs());
        wrapperOperator.setAlias_output(wop.getAlias_outputs());


        return wrapperOperator;
    }

    public OperatorType getTypeOperator(String name){
        if(this.operators.containsKey(name)){
            OperatorMapping op = (OperatorMapping)this.operators.get(name);
            return op.getType();
        }
        if(this.wrappers.containsKey(name)){
            return OperatorType.WRAPPER;
        }
        throw new ParserLatinException(
            String.format(
                "the operator \"%s\" not exist in the configuration, please look your configuration file or query",
                name
            )
        );
    }

    public MappingFinal getOperatorMapping(String name){
        if(! this.operators.containsKey(name)){
            throw new ParserLatinException(
                String.format(
                    "the operator \"%s\" not exist in the configuration, "
                    + "please look in your configuration file the variable \"operator_mapping\"",
                    name
                )
            );
        }
        return this.operators.get(name);
    }
}
