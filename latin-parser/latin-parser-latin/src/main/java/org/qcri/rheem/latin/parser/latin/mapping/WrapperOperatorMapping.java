package org.qcri.rheem.latin.parser.latin.mapping;

import org.qcri.rheem.latin.core.plan.enviroment.ClassEnviroment;
import org.qcri.rheem.latin.core.plan.expression.RealFunctionExpression;
import org.qcri.rheem.latin.parser.latin.mapping.enums.FunctionType;
import org.qcri.rheem.latin.parser.latin.mapping.enums.LambdaType;
import org.qcri.rheem.latin.parser.latin.mapping.enums.OperatorType;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class WrapperOperatorMapping implements MappingFinal {

    private String name;
    private int nInputs; // is the same that say the nfunction
    private int nOutput;
    private OperatorType type;
    private List<String> alias_inputs;
    private List<String> alias_outputs;
    private Map<String, OperatorMapping> operatorsWrapped;
    private Map<String, WrapperFunctionMapping> functionsMapping;


    public WrapperOperatorMapping(String name, int nInputs, int nOutput, OperatorType type, List<String> alias_inputs, List<String> alias_outputs, Map<String, OperatorMapping> operatorsWrapped, Map<String, WrapperFunctionMapping> functionsMapping) {
        this.name = name;
        this.nInputs = nInputs;
        this.nOutput = nOutput;
        this.type = type;
        this.alias_inputs = alias_inputs;
        this.alias_outputs = alias_outputs;
        this.operatorsWrapped = operatorsWrapped;
        this.functionsMapping = functionsMapping;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getnInputs() {
        return nInputs;
    }

    public void setnInputs(int nInputs) {
        this.nInputs = nInputs;
    }

    public int getnOutput() {
        return nOutput;
    }

    public void setnOutput(int nOutput) {
        this.nOutput = nOutput;
    }

    public OperatorType getType() {
        return type;
    }

    public void setType(OperatorType type) {
        this.type = type;
    }

    public List<String> getAlias_inputs() {
        return alias_inputs;
    }

    public void setAlias_inputs(List<String> alias_inputs) {
        this.alias_inputs = alias_inputs;
    }

    public List<String> getAlias_outputs() {
        return alias_outputs;
    }

    public void setAlias_outputs(List<String> alias_outputs) {
        this.alias_outputs = alias_outputs;
    }

    public Map<String, OperatorMapping> getOperatorsWrapped() {
        return operatorsWrapped;
    }

    public void setOperatorsWrapped(Map<String, OperatorMapping> operatorsWrapped) {
        this.operatorsWrapped = operatorsWrapped;
    }

    public Map<String, WrapperFunctionMapping> getFunctionsMapping() {
        return functionsMapping;
    }

    public void setFunctionsMapping(Map<String, WrapperFunctionMapping> functionsMapping) {
        this.functionsMapping = functionsMapping;
    }

    @Override
    public Object clone() {
        return new WrapperOperatorMapping(
            this.name,
            this.nInputs,
            this.nOutput,
            this.type,
            this.alias_inputs,
            this.alias_outputs,
            this.operatorsWrapped,
            this.functionsMapping
        );
    }

    public static class WrapperFunctionMapping{
        private String function_name;
        private LambdaType lambda;
        private Class class_function;
        private Method method;
        private boolean udf;
        private int position;

        public WrapperFunctionMapping(String function_name, LambdaType lambda, Class class_function, Method method, boolean udf, int position) {
            this.function_name = function_name;
            this.lambda = lambda;
            this.class_function = class_function;
            this.method = method;
            this.udf = udf;
            this.position = position;
        }

        public String getFunction_name() {
            return function_name;
        }

        public LambdaType getLambda() {
            return lambda;
        }

        public Class getClass_function() {
            return class_function;
        }

        public Method getMethod() {
            return method;
        }

        public boolean isUdf() {
            return udf;
        }

        public int getPosition() {
            return position;
        }

        @Override
        public String toString() {
            return "WrapperFunctionMapping{" +
                    "function_name='" + function_name + '\'' +
                    ", lambda=" + lambda +
                    ", class_function=" + class_function +
                    ", method=" + method +
                    ", udf=" + udf +
                    ", position=" + position +
                    '}';
        }

        public RealFunctionExpression getExpression(){
            ClassEnviroment enviroment = new ClassEnviroment(function_name, class_function);
            return new RealFunctionExpression(function_name, enviroment, method.getName());
        }
    }

    @Override
    public String toString() {
        return "WrapperOperatorMapping{" +
                "name='" + name + '\'' +
                ",\n nInputs=" + nInputs +
                ",\n nOutput=" + nOutput +
                ",\n type=" + type +
                ",\n alias_inputs=" + alias_inputs +
                ",\n alias_outputs=" + alias_outputs +
                ",\n operatorsWrapped=" + operatorsWrapped +
                ",\n functionsMapping=" + functionsMapping +
                "\n}";
    }
}
