package org.qcri.rheem.latin.reflexion;

import org.apache.commons.lang3.ClassUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.qcri.rheem.core.plan.rheemplan.Operator;
import org.qcri.rheem.latin.LatinContext;
import org.qcri.rheem.latin.reflexion.rheem.ObjectOperatorRheem;
import org.qcri.rheem.latin.reflexion.rheem.ReflexRheem;
import org.qcri.rheem.latin.util.Pair;
import org.reflections.Reflections;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.*;

/**
 * Created by bertty on 06-04-17.
 */
public class ReflexBuilder {
    private static JSONObject operator_conf         = null;
    private static JSONObject mapping_conf          = null;


    private static Map<String, Reflex> reflexeds;

    private static ReflexRheem rheemflexeds;

    private static Map<String, ParametersTypes> lambdas = null;


    public static void loadReflex(){
        System.err.println("\tLoading Reflex");
        reflexeds = new HashMap<String, Reflex>();
        loadLambdas();
        loadConfOperator();
        loadConfMapping();
        System.err.println("\tReflex Loaded");
    }

    private static void loadConfOperator(){
        System.err.println("\t\tLoading Configuration of the Operator");
        operator_conf = new JSONObject(getContentFile(LatinContext.getConf_operator()));
        convertConfOperator();
        System.err.println("\t\tConfiguration of the operator is loaded");
    }

    private static void loadConfMapping(){
        System.err.println("\t\tLoading Configuration of the Mapping");
        mapping_conf = new JSONObject(getContentFile(LatinContext.getConf_mapping()));
        convertConfMapping();
        System.err.println("\t\tConfiguration of the mapping is loaded");
    }

    private static String getContentFile(URI path_file){
        FileReader file = null;
        StringBuilder content = new StringBuilder();
        try {
            System.out.println(path_file.getPath());
            file = new FileReader( new File( path_file ) );
            BufferedReader reader = new BufferedReader(file);

            String line = "";

            while ( (line = reader.readLine()) != null ){
                content.append(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private static void convertConfOperator(){
        System.err.println("\t\t\tConverting Configuration of the Operator");
        JSONObject operators = operator_conf.getJSONObject("operator");

        System.err.println("\t\t\t\tConverting Operators Logical");
        loadOperatorLogical(operators.getJSONArray("logical"), operators.getString("package_logical"), operators.getString("class_logical"));

        System.err.println("\t\t\t\tConverting Operators Expression");
        loadOperatorExpression(operators.getJSONArray("expression"));

        System.err.println("\t\t\t\tConverting Operators Function");
        loadOperatorFunction(operators.getJSONArray("function"), operators.getString("package_function"));

        System.err.println("\t\t\tConfiguration of the Operator converted");
    }

    private static void loadOperatorLogical(JSONArray operators_lo, String packageClass, String classExtend){
        String nameReflex = ObjectConf.OP_LOGICAL;
        Reflex elements = new Reflex(nameReflex, packageClass, classExtend);
        int length = operators_lo.length();
        for(int i = 0; i < length; i++){
            JSONObject element = operators_lo.getJSONObject(i);
            ObjectOperator op  = new ObjectOperator();
            op.setName(element.getString("name"));
            op.setNfunction(element.getInt("nfunction"));
            op.setType(element.getString("type"));

            if(element.has("output")){
                op.setOutput(element.getString("output"));
            }

            if(element.has("lambda")){
                op.setLamdba(element.getString("lambda"));
            }

            elements.addObject(op.getName(), op);
        }
        reflexeds.put(nameReflex, elements);
    }

    private static void loadOperatorExpression(JSONArray operators_ex){
        String nameReflex = ObjectConf.OP_EXPRESSION;
        Reflex elements = new Reflex(nameReflex, "", "");
        int length = operators_ex.length();
        for(int i = 0; i < length; i++){
            JSONObject element  = operators_ex.getJSONObject(i);
            ObjectExpression ex = new ObjectExpression();
            ex.setName(element.getString("name"));
            ex.setReal_operator(element.getString("real_operator"));
            ex.setType(element.getString("type"));
            ex.setType_class(element.getString("type_class"));
            if(ex.getType_class() == ObjectExpression.TYPE_CLASS_CONST) {
                ex.setValue(element.getString("value"));
            }
            elements.addObject(ex.getName(), ex);
        }
        reflexeds.put(nameReflex, elements);
    }


    private static void loadOperatorFunction(JSONArray operators_fu, String packageClass){
        String nameReflex = ObjectConf.OP_FUNCTION;
        Reflex elements = new Reflex(nameReflex, packageClass, "");
        int length = operators_fu.length();
        for(int i = 0; i < length; i++){
            try {
                JSONObject element = operators_fu.getJSONObject(i);
                ObjectFunction fu = new ObjectFunction();

                fu.setName(element.getString("name"));
                fu.setPackage_function(packageClass);
                fu.setClass_function(element.getString("class"));
                fu.setNparam(element.getInt("nparam"));

                Class[] params = convertType( element.getJSONArray("parameters"));

                fu.setParamters(params);
                fu.setMethod(element.getString("method"));

                fu.setType_return(element.getString("type_return"));

                fu.setType(element.getString("type"));

                elements.addObject(fu.getName(), fu);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        reflexeds.put(nameReflex, elements);


    }

    private static Class[] convertType( JSONArray param ) throws ClassNotFoundException {
        Class[] _class = new Class[param.length()];
        boolean isArray = false;
        for( int i = 0; i < _class.length; i++ ){
            String param_type = param.getString(i);

            if(param_type.contains("[]")){
                param_type = param_type.replace("[", "");
                param_type =param_type.replace("]", "");
                isArray = true;
            }
            _class[i] = ClassUtils.getClass(param_type);
            if(isArray){
                _class[i] = Array.newInstance(_class[i], 0).getClass();
                isArray = false;
            }
        }
        return _class;
    }

    public static Set getKeys(String nameGroup){
        return reflexeds.get(nameGroup).getKeys();
    }

    public static ObjectConf getObject(String nameGroup, String key){
        return reflexeds.get(nameGroup).getObject(key);
    }



    public static void convertConfMapping(){
        ObjectOperatorRheem.load();
        List<Pair<String, String>> otherPackage = new ArrayList<>();
        JSONObject conf = mapping_conf.getJSONObject("mapping").getJSONObject("rheem");
        String package_latin = conf.getString("package_latin");
        String package_rheem = conf.getString("package_rheem");
        String extend_latin  = conf.getString("extend_latin");
        String extend_rheem  = conf.getString("extend_rheem");

        JSONArray mappings = conf.getJSONArray("class_reflex");

        int length = mappings.length();


        HashMap<String, Pair<String, String[]>> map_rheem_latin = new HashMap<>();
        for(int i = 0; i < length; i++){
            JSONObject obj = mappings.getJSONObject(i);
            JSONArray array_params = obj.getJSONArray("parameters");

            String[] string_params = new String[array_params.length()];
            for(int j = 0; j < string_params.length; j++){
                string_params[j] = array_params.getString(j);
            }

            if(obj.has("package")){
                otherPackage.add(new Pair<String, String>(obj.getString("name_rheem"), obj.getString("package")));
            }

            map_rheem_latin.put(
                        obj.getString("name_rheem"),
                        new Pair<String, String[]>(obj.getString("name_latin"), string_params)
            );
        }

        rheemflexeds = new ReflexRheem(ObjectConf.MAPPING_RHEEM, package_rheem, extend_rheem);

        Reflections reflex = new Reflections(package_rheem);

        Set<Class<?>> obj_extends;
        try{
            obj_extends = (Set<Class<?>>) reflex.getSubTypesOf( Class.forName(extend_rheem) );

            if(otherPackage.size() > 0){
                Pair<String, String> _pair;
                for(int i_othePackage = 0; i_othePackage < otherPackage.size(); i_othePackage++) {
                    _pair = otherPackage.get(i_othePackage);
                    obj_extends.add(Class.forName(_pair.second+"."+_pair.first));
                }
            }

            Iterator<Class<?>> iter = obj_extends.iterator();
            while(iter.hasNext()){
                Class<?> operator_class = iter.next();
                if( map_rheem_latin.containsKey(operator_class.getSimpleName()) ){
                    Pair<String, String[]> pair = map_rheem_latin.get(operator_class.getSimpleName());
                    ObjectOperatorRheem opRheem = new ObjectOperatorRheem(pair.first, operator_class);
                    opRheem.setConstructor(pair.second);
                    rheemflexeds.put( pair.first, opRheem);
                }

            }





        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public static Operator createOperator(String name, Object ... params) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return rheemflexeds.createOperator(name, params);
    }

    public static String[] getParametres(String name){
        return rheemflexeds.getParameters(name);
    }



    private static void loadLambdas(){
        lambdas = new HashMap<>();
        lambdas.put("predicate", ParametersTypes.PREDICATE);
        lambdas.put("function" , ParametersTypes.FUNCTION);
        lambdas.put("class"    , ParametersTypes.CLASS);
        lambdas.put("string"   , ParametersTypes.STRING);
    }

    public static ParametersTypes getLambdaName(String name){
        return lambdas.get(name);
    }


    public static Method getFunction(String name){
        return ((ObjectFunction)reflexeds.get(ObjectConf.OP_FUNCTION).getObject(name)).getMethod();
    }
}
