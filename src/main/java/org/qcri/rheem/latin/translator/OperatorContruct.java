package org.qcri.rheem.latin.translator;

import org.qcri.rheem.basic.operators.*;
import org.qcri.rheem.core.plan.rheemplan.OperatorBase;
import org.qcri.rheem.latin.Aclass;
import org.qcri.rheem.latin.exception.MappingException;
import org.qcri.rheem.latin.plan.Operator;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bertty on 14-03-17.
 */
public class OperatorContruct {
    private List<OperatorWrapper> listOfSinkOperator = new ArrayList<>();
    public  List<String> resultado = null;


    public OperatorWrapper builderOperator(String nameOperator, Operator latinOperator) throws MappingException {
        OperatorWrapper wrapper  = new OperatorWrapper();
        OperatorBase    operator = null;
        switch(nameOperator) {
            case "org.qcri.rheem.basic.operators.LoopOperator":
                operator = new LoopOperator(null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.CountOperator":
                operator = new CountOperator(Object.class);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.UnionAllOperator":
                operator = new UnionAllOperator(Object.class);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.PageRankOperator":
                operator = new PageRankOperator(0);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.CartesianOperator":
                operator = new CartesianOperator(null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.MaterializedGroupByOperator":
                operator = new MaterializedGroupByOperator((MaterializedGroupByOperator) null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.ZipWithIdOperator":
                operator = new ZipWithIdOperator(Object.class);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.ReduceOperator":
                operator = new ReduceOperator(null, null, null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.MapOperator":
                operator = new MapOperator((MapOperator) null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.LocalCallbackSink":
                this.resultado = new ArrayList<>();
                operator = LocalCallbackSink.createCollectingSink(this.resultado, String.class);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.GroupByOperator":
                operator = new GroupByOperator(null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.ReduceByOperator":
                operator = new ReduceByOperator(null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.TextFileSource":
                URI path = null;
                String path_string = latinOperator.getParam(String.class);
                try {
                    path = Thread.currentThread().getClass().getResource(path_string).toURI();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                operator = new TextFileSource(path.toString());
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.SampleOperator":
                operator = new SampleOperator(null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.FilterOperator":
              //      ((LOFilter)latinOperator).getFilterPlan();
                Aclass tmp = new Aclass();
                operator = new FilterOperator(a -> tmp.execute(a),  String.class );
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.DistinctOperator":
                operator = new DistinctOperator((Class) null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.TextFileSink":
                operator = new TextFileSink(null, Object.class);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.JoinOperator":
                operator = new JoinOperator(null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.DoWhileOperator":
                operator = new DoWhileOperator(null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.RepeatOperator":
                operator = new RepeatOperator(null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.GlobalMaterializedGroupOperator":
                operator = new GlobalMaterializedGroupOperator((Class) null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.FlatMapOperator":
                operator = new FlatMapOperator((FlatMapOperator) null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.GlobalReduceOperator":
                operator = new GlobalReduceOperator((GlobalReduceOperator) null);
                wrapper.setOperatorRheem(operator);
                break;
    //        case "org.qcri.rheem.basic.operators.MapPartitionsOperator":
    //            operator = new MapPartitionsOperator((MapPartitionsOperator) null);
    //            wrapper.setOperatorRheem(operator);
    //            break;
            case "org.qcri.rheem.basic.operators.CollectionSource":
                operator = new CollectionSource(null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.IntersectOperator":
                operator = new IntersectOperator((Class) null);
                wrapper.setOperatorRheem(operator);
                break;
            case "org.qcri.rheem.basic.operators.SortOperator":
                operator = new SortOperator(String.class);
                wrapper.setOperatorRheem(operator);
                break;
            default:
                throw new MappingException("class \""+nameOperator+"\" not found for create");
        }
        if(Translator.isSinkOperator(nameOperator)){
            this.listOfSinkOperator.add(wrapper);
        }
        return wrapper;
    }

   /* public void builderOperator(String nameOperator, Operator latinOperator){









        return;
    }*/

    public List<OperatorWrapper> getListOfSinkOperator() {
        return listOfSinkOperator;
    }

    public void setListOfSinkOperator(List<OperatorWrapper> listOfSinkOperator) {
        this.listOfSinkOperator = listOfSinkOperator;
    }
}
