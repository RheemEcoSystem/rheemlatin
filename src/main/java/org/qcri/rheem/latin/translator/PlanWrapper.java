package org.qcri.rheem.latin.translator;


import org.qcri.rheem.core.api.RheemContext;
import org.qcri.rheem.core.plan.rheemplan.RheemPlan;
import org.qcri.rheem.core.plan.rheemplan.UnarySink;
import org.qcri.rheem.java.Java;

import java.util.List;

/**
 * Created by bertty on 14-03-17.
 */
public class PlanWrapper {
    private Translator   translatorPlan = null;
    private RheemPlan rheemPlan      = null;
    private RheemContext rheemContext   = null;

    public PlanWrapper(Translator tranPlan){
        this.translatorPlan = tranPlan;
    }

    public void createPlan(){
        createContext();
        UnarySink[] sinkOperators = getSinkOperator();
        this.rheemPlan = new RheemPlan(sinkOperators);
    }

    public void executePlan(){
        this.rheemContext.execute(this.rheemPlan);
    }

    private void createContext(){
        this.rheemContext = new RheemContext();
       this.rheemContext.with(Java.basicPlugin());
        // Build a Rheem plan.
    /*
        URI path = null;
        try {
            path = Thread.currentThread().getClass().getResource("/Simple").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ;
        TextFileSource textFileSource = new TextFileSource(path.toString());
        LocalCallbackSink<String> sink = LocalCallbackSink.createCollectingSink(collector, String.class);
        textFileSource.connectTo(0, sink, 0);
        RheemPlan rheemPlan = new RheemPlan(sink);

        // Instantiate Rheem and activate the Java backend.
        RheemContext rheemContext = new RheemContext().with(Java.basicPlugin());

        // Have Rheem execute the plan.
        rheemContext.execute(rheemPlan);

        // Verify the plan result.
        for(String word: collector){
            System.out.println(word);
        }*/

    }

    private UnarySink[] getSinkOperator(){
        List<OperatorWrapper> listSink = searchSinkOperator();
        UnarySink[] sinkOperator = new UnarySink[listSink.size()];
        int index = 0;
        for(OperatorWrapper element: listSink){
            sinkOperator[index] = (UnarySink) element.getOperatorRheem();
        }
        return sinkOperator;
    }

    private List<OperatorWrapper> searchSinkOperator(){
        return this.translatorPlan.getOperatorContruct().getListOfSinkOperator();
    }

}
