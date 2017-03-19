package org.qcri.rheem.latin.translator.reflex;

import org.reflections.Reflections;

import java.util.Map;

/**
 * Created by bertty on 16-03-17.
 */
public class Reflactor {

    /**
     * is a map of de name of class with self instance
     *
     * *********
     * ********* DEBE SER MULTI INDEX ESTA VARIABLE PARA AGUANTAR BUSQUEDAS POR NOMBRE DE LA CLASE, EXTENCION O PAQUETE
     * *********
     */
    private static Map<String, OperatorReflex> opConverter = null;

    /**
     * valid that operator of the other platform they are loaded
     */
    private static boolean loadedConverter = false;

    /**
     *
     */
    private static Reflections[] reflections = null;

    /**
     *
     */
    private static String[] packages = {"", ""};

    /**
     *
     */
    private static String[] extendeds = {"", ""};

    public static void loadReflactor(){

    }







    private static void loaded(){
        System.out.println("Error class Reflactor is not load in memory");
        System.exit(1000);
    }


}
