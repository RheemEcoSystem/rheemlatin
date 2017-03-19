package org.qcri.rheem.latin.translator;

import org.qcri.rheem.core.plan.rheemplan.OperatorBase;
import org.qcri.rheem.latin.exception.MappingException;
import org.qcri.rheem.latin.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bertty on 14-03-17.
 */
public class OperatorWrapper {
    private OperatorBase   operatorRheem   = null;
    private int            inputSlot       = 0;
    private int            outputSlot      = 0;
    private int            inputSlotOcupe  = 0;
    private int            outputSlotOcupe = 0;
    private List<Pair<Integer, Mapped>> operatorInput  = null;
    private List<Pair<Integer, Mapped>> operatorOutput = null;


    public OperatorWrapper(OperatorBase operatorRheem) {
        this.operatorRheem = operatorRheem;
    }

    public OperatorWrapper() {
        this.operatorRheem  = null;
        this.operatorInput  = new ArrayList<>();
        this.operatorOutput = new ArrayList<>();
    }

    public OperatorBase getOperatorRheem() {
        return operatorRheem;
    }

    public void setOperatorRheem(OperatorBase operatorRheem) {
        this.operatorRheem = operatorRheem;
    }

    public void setParameters(Object ... parameters){

    }

    public int getInputSlot() {
        return inputSlot;
    }

    public void setInputSlot(int inputSlot) {
        this.inputSlot = inputSlot;
    }

    public int getOutputSlot() {
        return outputSlot;
    }

    public void setOutputSlot(int outputSlot) {
        this.outputSlot = outputSlot;
    }

    public void addInputSlot(){
        this.inputSlot++;
    }

    public void addOutputSlot(){
        this.outputSlot++;
    }

    public List<Pair<Integer, Mapped>> getOperatorInput() {
        return operatorInput;
    }

    public void setOperatorInput(List<Pair<Integer, Mapped>> operatorInput) {
        this.operatorInput = operatorInput;
    }

    public void addOperatorInput(Mapped operator){
        Integer position = new Integer(inputSlotOcupe);
        this.operatorInput.add(new Pair<Integer, Mapped>(position, operator));
        inputSlotOcupe++;
    }

    public List<Pair<Integer, Mapped>> getOperatorOutput() {
        return operatorOutput;
    }

    public void setOperatorOutput(List<Pair<Integer, Mapped>> operatorOutput) {
        this.operatorOutput = operatorOutput;
    }

    public void addOperatorOutput(Mapped operator){
        Integer position = new Integer(outputSlotOcupe);
        this.operatorOutput.add(new Pair<Integer, Mapped>(position, operator));
        outputSlotOcupe++;
    }

    public void conect() throws MappingException {
        for(Pair<Integer, Mapped> element: this.operatorOutput){
            Mapped operatorMapped = element.second;
            Integer position      = operatorMapped.getPositionOperatorWraper(this);
            this.operatorRheem.connectTo(element.first.intValue(), operatorMapped.getOperatorMapped().getOperatorRheem(), position.intValue());
        }
    }

    public Integer getPositionOperatorWrapper(OperatorWrapper that) throws MappingException {
        for(Pair<Integer, Mapped> element: this.operatorInput){
            if (element.second.equals(that)){
                return element.first;
            }
        }
        throw new MappingException("The element is not mapping or not has input/output");
    }


}
