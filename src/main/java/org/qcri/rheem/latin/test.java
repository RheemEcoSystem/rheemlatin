package org.qcri.rheem.latin;

import java.util.ArrayList;
import java.util.List;

public class test {

/**
    public static void main(String[] args){
        int nIteracion = 100000000;
        System.out.println("cantidad de iteracion en \t"+nIteracion);
        System.out.println("memoria en uso Inicio\t"+String.format("%.2f",(float)(Runtime.getRuntime().freeMemory()/(1024*1024)))+"\tMB");
        long start = System.nanoTime();

        //try {
            //testD   Constructor tmp = Class.forName("org.qcri.rheem.basic.operators.TextFileSource").getDeclaredConstructor(String.class);
            //testF   Class tmp =  Class.forName("org.qcri.rheem.latin.Aclass");
            for(int i = 0; i < nIteracion; i++){
             //testA       new Aclass();
             //testB       Class.forName("org.qcri.rheem.latin.Aclass").newInstance();
             //testC       Constructor tmp = Class.forName("org.qcri.rheem.basic.operators.TextFileSource").getDeclaredConstructor(String.class);
             //testC y D   tmp.newInstance("hola mundo");
             //testE       new TextFileSource("hola mundo");
             //testF       tmp.newInstance();
            }

       /* } catch (Exception e) {
            e.printStackTrace();
        }
        * /

        double elapsedTimeInSec = (System.nanoTime() - start) * 1.0e-9;

        System.out.println("memoria en uso Fin \t"+String.format("%.2f",(float)(Runtime.getRuntime().totalMemory()/(1024*1024)))+"\tMB");
        System.out.println("Tiempo transcurrido \t"+String.format("%.10f",elapsedTimeInSec)+"\t[seg]");


    }
*/

    public static void main(String[] args){
        new Cclass("hola", "chao", "sjsjjs");
        List<String> tmp = new ArrayList<>();
        tmp.add("hola2");
        tmp.add("chao2");
        tmp.add("hola2");

        String[] tmp2 = new String[3];
        tmp2[0] = "dasd";
        tmp2[1] = "da";
        tmp2[2] = "das";
        new Cclass( tmp2 );
    }
}
