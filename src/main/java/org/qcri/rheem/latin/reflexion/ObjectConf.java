package org.qcri.rheem.latin.reflexion;

/**
 * Created by bertty on 09-04-17.
 */
public interface ObjectConf {
    public static final String OP_LOGICAL    = "operator_logical";
    public static final String OP_EXPRESSION = "operator_expression";
    public static final String OP_FUNCTION   = "operator_function";
    public static final String MAPPING_RHEEM = "mapping_rheem";


    public static final String TYPE_OP_BINARY = "BinaryToUnary";
    public static final String TYPE_OP_UNARY  = "UnaryToUnary";
    public static final String TYPE_OP_SINK   = "Sink";
    public static final String TYPE_OP_SOURCE = "Source";

    public static final String TYPE_EX_BINARY = "binary";
    public static final String TYPE_EX_UNARY  = "unary";
    public static final String TYPE_EX_POSTUN = "post_unary";

    public static final String FUNCTION_EXEC  = "function_executor";
    public static final String FUNCTION_EXEC_PACKAGE   = "org.qcri.rheem.latin.util";
    public static final String FUNCTION_EXEC_NAMECLASS = "org.qcri.rheem.latin.util.FunctionsExecute";


    public String getName();

}
