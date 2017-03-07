package org.qcri.rheem.translate;

import org.json.*;
import org.qcri.rheem.core.plan.rheemplan.Operator;

import java.io.*;

public class TransformerClass {

    public static String route = "conf_mapping.json";
    public JSONObject conf = null;

    public TransformerClass(){
        FileReader archivo = null;
        try {
            archivo = new FileReader( new File( route ) );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader lector = new BufferedReader(archivo);

        String cadena = "";
        String contenido = "";
        try {
            while ( (cadena = lector.readLine()) != null ){
                contenido += cadena;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        conf = new JSONObject(contenido);
    }

    public org.qcri.rheem.core.plan.rheemplan.Operator trans(LogicalRelationalOperator obj) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String name_class = obj.getClass().getCanonicalName();

        String mapping = this.conf.getString(name_class);

        Class<?> class_shell = Class.forName(mapping);

        Operator new_class = (org.qcri.rheem.core.plan.rheemplan.Operator) class_shell.newInstance();

        return  new_class;
    }

}
