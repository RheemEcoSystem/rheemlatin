package org.qcri.rheem.latin.translator;

import org.qcri.rheem.core.plan.rheemplan.Operator;
import org.qcri.rheem.latin.plan.operator.LatinOperator;
import org.qcri.rheem.latin.reflexion.ReflexBuilder;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by bertty on 11-04-17.
 */
public class LoaderOperator {




    public static Operator reflectOperator(LatinOperator latinOp){

        Operator rheemOp = null;

        Object[] params =null;//     = new Object[parametres];
        try {

            String[] nameParams = ReflexBuilder.getParametres(latinOp.getName());
            params = latinOp.getParams(nameParams);

  /*         if(latinOp.getName().equals("FILTER")){
                class_input = new Class[2];
                params     = new Object[2];

                Class aux = lambdas.get("predicate");

                class_input[0] = aux;
                class_input[1] = Class.class;

                params[1] = String.class;

                Class x = (Class)params[1];
          //      params[0] = (FunctionDescriptor.SerializablePredicate) a -> true;

                Predicate<String> ayuda = a -> Integer.parseInt(a)%2 == 0;

          //      System.out.println(aux.getSimpleName());

                params[0] = new TESTSP<>(ayuda);


            }else if(latinOp.getName().equals("JOIN")){
                class_input = new Class[5];
                params     = new Object[5];
                class_input[0] = lambdas.get("function");
                class_input[1] = lambdas.get("function");
                class_input[2] = Class.class;
                class_input[3] = Class.class;
                class_input[4] = Class.class;

                params[0] = (TransformationDescriptor.SerializableFunction) a -> a;
                params[1] = (TransformationDescriptor.SerializableFunction) a -> a;
                params[2] = String.class;
                params[3] = String.class;
                params[4] = String.class;
            }else if(latinOp.getName().equals("LOAD")){
                class_input = new Class[1];
                params     = new Object[1];
                class_input[0] = String.class;

                params[0] = "file:///Users/bertty/Qatar/xxxx/file1.txt";
            }else if(latinOp.getName().equals("STORE")){
                class_input = new Class[2];
                params      = new Object[2];
                class_input[0] = String.class;
                class_input[1] = Class.class;

                params[0] = "file:///Users/bertty/Qatar/xxxx/salida.txt";
                params[1] = Tuple2.class;
            }*/

            rheemOp = ReflexBuilder.createOperator(latinOp.getName(), params );
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return rheemOp;
    }







}
