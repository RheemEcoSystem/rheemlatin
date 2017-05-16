package org.qcri.rheem.latin.plan.operator;

import org.qcri.rheem.latin.plan.operator.expression.BinaryExpression;
import org.qcri.rheem.latin.plan.operator.expression.FunctionExpression;
import org.qcri.rheem.latin.plan.operator.expression.UnaryExpression;
import org.qcri.rheem.latin.plan.operator.logical.ManyOperator;
import org.qcri.rheem.latin.plan.operator.logical.SinkOperator;
import org.qcri.rheem.latin.plan.operator.logical.SourceOperator;
import org.qcri.rheem.latin.reflexion.*;

/**
 * Created by bertty on 11-04-17.
 */
public class OperatorBuilder {

    public static ManyOperator getOperatorMany(String name){
        ObjectOperator op = (ObjectOperator) ReflexBuilder.getObject(ObjectConf.OP_LOGICAL, name);
        if( op.getType().equals(ObjectConf.TYPE_OP_BINARY) && op.getType().equals(ObjectConf.TYPE_OP_UNARY) ) {
            return null;
        }
        ManyOperator operator = new ManyOperator(op.getName(), op.getNfunction());
        ParametersTypes lambda = op.getLamdba();
        if(lambda != null) {
            operator.setLambdas(op.getLamdba());
        }
        if (op.getOutput() != null){
            operator.setClassOutput(op.getOutput());
        }
        return operator;
    }

    public static SinkOperator getOperatorSink(String name){
        ObjectOperator op = (ObjectOperator) ReflexBuilder.getObject(ObjectConf.OP_LOGICAL, name);
        if( ! op.getType().equals(ObjectConf.TYPE_OP_SINK) ){
            return null;
        }
        SinkOperator sink = new SinkOperator(op.getName(), op.getNfunction());
        if(op.getOutput() != null){
            sink.setClassOutput(op.getOutput());
        }
        return sink;
    }

    public static SourceOperator getOperatorSource(String name){
        ObjectOperator op = (ObjectOperator) ReflexBuilder.getObject(ObjectConf.OP_LOGICAL, name);

        if( ! op.getType().equals( ObjectConf.TYPE_OP_SOURCE) ){
            return null;
        }
        SourceOperator source = new SourceOperator(op.getName());
        if(op.getOutput() != null){
            source.setClassOutput(op.getOutput());
        }
        return source;
    }

    public static FunctionExpression getFunction(String name){
        ObjectFunction obj_fun = (ObjectFunction) ReflexBuilder.getObject(ObjectConf.OP_FUNCTION, name);
        FunctionExpression func = new FunctionExpression(obj_fun.getName(), obj_fun.getNparam());

        func.setType(obj_fun.getType());
        func.setReal_operator(obj_fun.getName());
        return func;
    }

    public static LatinExpression getExpression(String name){
        ObjectExpression obj_exp = (ObjectExpression) ReflexBuilder.getObject(ObjectConf.OP_EXPRESSION, name);

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

        return expr;
    }


}
