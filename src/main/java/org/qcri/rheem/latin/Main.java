package org.qcri.rheem.latin;

import org.qcri.rheem.latin.plan.logical.LogicalPlan;
import org.qcri.rheem.latin.translator.PlanWrapper;
import org.qcri.rheem.latin.translator.Translator;
import org.qcri.rheem.latin.util.LatinContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Created by bertty on 08-03-17.
 */
public class Main {

    public static void main(String[] args){
        try{
    /*        CharStream archivo = new ANTLRFileStream("rheem_latin_test.pig");

            CommonTokenStream tokens = new CommonTokenStream(new QueryLexer(archivo));

            QueryParser parser = new QueryParser(tokens);

            QueryParser.query_return retorno = parser.query();

            Tree ast = (Tree) retorno.getTree();

            System.out.println(ast.toStringTree());
    */

            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;

            try {
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
    //            archivo = new File ("rheem_latin_test.pig");
    //            archivo = new File ("test_filter.pig");
    //            archivo = new File ("test_sort.pig");
                archivo = new File ("test_sort_filter.pig");
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);

                // Lectura del fichero
                String contenido = "";
                String linea;
                while((linea=br.readLine())!=null)
                    contenido += linea;

                System.out.println(contenido);
                LatinContext latinContext = new LatinContext();
                EngineDriver engine = new EngineDriver(latinContext, "test", new HashMap<String, String>());


                LogicalPlan test = engine.parse(contenido);

                test.explain(System.out, "", true);

     //           RheemContext rheemContext = new RheemContext();
     //           rheemContext.register(JavaPlatform.getPlatformInstance());

                Translator.loadClass();
                Translator translator = new Translator(test);
                if( translator.translate() ){
                    PlanWrapper planFinal = new PlanWrapper(translator);
                    planFinal.createPlan();
                    planFinal.executePlan();
                    for(String word:translator.getOperatorContruct().resultado){
                        System.out.println(word);
                    }
                   // planFinal.executePlan();
                }


            }
            catch(Exception e){
                e.printStackTrace();
            }finally{
                // En el finally cerramos el fichero, para asegurarnos
                // que se cierra tanto si todo va bien como si salta
                // una excepcion.
                try{
                    if( null != fr ){
                        fr.close();
                    }
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }




        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

/*
** Query for execute
**
** va1 = LOAD 'passwd' USING PigStorage(':');  -- load the passwd file
** var2 = FOREACH var1 GENERATE $0 AS id;  -- extract the user IDs
** STORE var2 INTO 'id.out';  -- write the results to a file name id.out
**
** Query after parser, treeAST
**
**(QUERY
**        (STATEMENT va1
**            (LOAD 'passwd'
**                (FUNC PigStorage ':')
**            )
**        )
**        (STATEMENT var2
**            (FOREACH var1
**                (FOREACH_PLAN_SIMPLE
**                    (GENERATE $0
**                        (FIELD_DEF id)
**                    )
**                )
**            )
**        )
**        (STATEMENT
**            (STORE var2 'id.out')
**        )
**)
**
**
**
**
**
**
**
*/