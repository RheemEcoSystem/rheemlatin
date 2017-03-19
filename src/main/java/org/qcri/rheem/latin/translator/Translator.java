package org.qcri.rheem.latin.translator;

import org.json.JSONObject;
import org.qcri.rheem.core.plan.rheemplan.OperatorBase;
import org.qcri.rheem.latin.exception.MappingException;
import org.qcri.rheem.latin.plan.Operator;
import org.qcri.rheem.latin.plan.OperatorPlan;
import org.reflections.Reflections;

import java.io.*;
import java.util.*;

/**
 * Created by bertty on 12-03-17.
 */
public class Translator {
    private OperatorPlan plan = null;
    private Hashtable<String, OperatorBase> operatorsRheemCreated = null;
    private MapTranslated mapTranslated = null;
    private OperatorContruct operatorContruct = null;
    private static HashMap<String, Class> operatorsRheem     = null;
    private static List<String>           operatorsRheemSink = null;
    private static String package_operator    = "org.qcri.rheem.basic.operators";
    private static String name_superClass     = "org.qcri.rheem.core.plan.rheemplan.OperatorBase";
    private static String name_sinkSuperClass = "org.qcri.rheem.core.plan.rheemplan.UnarySink";
    private static String token               = "class ";
    private static String route_mapping       = "conf_mapping.json";
    private static JSONObject mapping         = null;

    public Translator(OperatorPlan plan ){
        this.plan = plan;
        this.operatorsRheemCreated = new Hashtable<>();
        this.mapTranslated = new TableTranslated();
        this.operatorContruct = new OperatorContruct();
        if (operatorsRheem == null){
            loadClass();
        }
        if (mapping == null){
            loadMapping();
        }
    }

    public boolean translate() throws MappingException {
        Iterator<Operator>    operators        = this.plan.getOperators();


        while( operators.hasNext() ){
            Operator operator = operators.next();
            if ( ! this.mapTranslated.searchName(operator.getName()) ) {
                Translated element = new LatinTranslated(operator.getName(), operator);
                this.mapTranslated.addOperatorTranslated(element);
                String mapped = this.sameInRheem(operator);
                OperatorWrapper wrapper = operatorContruct.builderOperator(mapped, operator);
                element.getMapped().setOperatorMapped(wrapper);
            }
        }

        for(Translated item: this.mapTranslated.getOperatorTranslated()){
            List<Operator> predec = this.plan.getPredecessors(item.getOperator());
            if(predec != null && predec.size() > 0) {
                for (Operator op : predec) {
                    Mapped mapped = this.mapTranslated.findMapped(op.getName());
                    item.addPredecessor(mapped);
                }
            }

            List<Operator> successor = this.plan.getSuccessors(item.getOperator());
            if(successor != null && successor.size() > 0) {
                for (Operator operator : successor) {
                    Mapped mapped = this.mapTranslated.findMapped(operator.getName());
                    item.addSuccessor(mapped);
                }
            }
        }

        if( validate() ) {
            List<Translated> firstTraduction = this.mapTranslated.getOperatorTranslated();
            for(Translated opTranslated: firstTraduction){
                buildEdgeTraslated(opTranslated);
            }
            for(Translated opTranslated: firstTraduction){
                conectOperatorTraslated(opTranslated);
            }

            return true;
        }else{
            throw new MappingException("The plan physical could not translate.");
        }
    }


    private String sameInRheem(Operator operator) throws MappingException {
        if (mapping == null){
            throw new MappingException("Mapping of the class is not loaded");
        }
        //agregar exception de no existencia
        String obj = (String) mapping.get(operator.getClass().getName());
        if (obj == null){
            throw new MappingException("Operator "+operator.getClass().getName()+" mapping not found");
        }
        return  obj;
    }

    public static void loadClass(){
        operatorsRheem     = new HashMap<String, Class>();
        operatorsRheemSink = new ArrayList<>();
        Reflections reflextion = new Reflections(package_operator);
        Set tmp;
        try {
            /**
             * Get all class that extends of the superClass of the Operator's
             */
            tmp = reflextion.getSubTypesOf( Class.forName(name_superClass));
            Iterator set_iterator = tmp.iterator();
            while(set_iterator.hasNext()){
                /**
                 * Get the name class that extends of the superClass of the Operator's
                 */
                Object operator_class = set_iterator.next();
                String name  = operator_class.toString();
                int position = name.indexOf(token);
                int length   = token.length();
                name = name.substring(position+length);
                operatorsRheem.put(name, (Class) operator_class);
            }
            /**
             * Get all class that extends od the superClass of the UnarySink
             */
            tmp = reflextion.getSubTypesOf( Class.forName(name_sinkSuperClass));
            set_iterator = tmp.iterator();
            while(set_iterator.hasNext()){
                /**
                 * Get the name class that extends of the superClass of the Operator's
                 */
                Object operator_class = set_iterator.next();
                String name  = operator_class.toString();
                int position = name.indexOf(token);
                int length   = token.length();
                name = name.substring(position+length);
                operatorsRheemSink.add(name);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            loadMapping();

        }
    }

    public static void loadMapping(){
        String content = getMapping();
        mapping = new JSONObject(content);
    }

    public static String getMapping(){
        FileReader file = null;
        String content = "";
        try {

            file = new FileReader( new File( route_mapping ) );
            BufferedReader reader = new BufferedReader(file);

            String line = "";

            while ( (line = reader.readLine()) != null ){
                content += line;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    private void buildEdgeTraslated( Translated element){
        List<Mapped> inputs  = element.getPredecessors();
        List<Mapped> outputs = element.getSuccessors();
        for(Mapped mapIn: inputs){
            element.getMapped().getOperatorMapped().addOperatorInput(mapIn);
        }

        for(Mapped mapOut: outputs){
            element.getMapped().getOperatorMapped().addOperatorOutput(mapOut);
        }
        return;
    }

    private void conectOperatorTraslated(Translated element) throws MappingException {
        element.getMapped().getOperatorMapped().conect();
    }



    private boolean validate(){
        return true;
    }

    public static boolean isSinkOperator(String name){
        for(String sink: operatorsRheemSink){
            if(name.equalsIgnoreCase(sink)){
                return true;
            }
        }
        return false;
    }

    public OperatorContruct getOperatorContruct() {
        return operatorContruct;
    }

    public void setOperatorContruct(OperatorContruct operatorContruct) {
        this.operatorContruct = operatorContruct;
    }
}
