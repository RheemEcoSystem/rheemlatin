package org.qcri.rheem.latin.parser.latin.context;

import org.qcri.rheem.latin.core.plan.expression.FunctionExpression;
import org.qcri.rheem.latin.core.plan.expression.LatinExpression;
import org.qcri.rheem.latin.core.plan.operator.logical.ManyOperator;
import org.qcri.rheem.latin.core.plan.operator.logical.SinkOperator;
import org.qcri.rheem.latin.core.plan.operator.logical.SourceOperator;
import org.qcri.rheem.latin.parser.latin.mapping.FunctionMapping;
import org.qcri.rheem.latin.parser.latin.mapping.MappingFinal;
import org.qcri.rheem.latin.parser.latin.mapping.OperatorMapping;
import org.qcri.rheem.latin.parser.latin.mapping.enums.LambdaType;
import org.qcri.rheem.latin.parser.latin.mapping.enums.OperatorType;

import java.util.HashMap;
import java.util.Map;

public class LoadMockupClass {

    private Map<String, MappingFinal> operators;
    private Map<String, MappingFinal> functions;
    private Map<String, MappingFinal> expressions;


    public LoadMockupClass(){
        this.operators = new HashMap<>();
        this.functions = new HashMap<>();
        this.expressions = new HashMap<>();
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


    public ManyOperator getOperatorMany(String name){
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
        //TODO: terminar la implementacion de las lambdas y la recuperacion
        if(lambda != null) {
            //operator.setExpressionInput(op.getLamdba());
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

}
