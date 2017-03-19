package org.qcri.rheem.latin.translator;

import org.qcri.rheem.latin.exception.MappingException;
import org.qcri.rheem.latin.plan.Operator;

/**
 * Created by bertty on 14-03-17.
 */
public class Mapped {
    private String name;
    private Operator operator;
    private OperatorWrapper operatorMapped;

    public Mapped(String name, Operator operator){
        this.name = name;
        this.operator = operator;
        this.operatorMapped = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public OperatorWrapper getOperatorMapped() {
        return operatorMapped;
    }

    public void setOperatorMapped(OperatorWrapper operatorMapped) {
        this.operatorMapped = operatorMapped;
    }

    public boolean isComplete(){
        return (this.getOperator() != null) && (this.operatorMapped != null);
    }

    public Integer getPositionOperatorWraper(OperatorWrapper operatorWrapper) throws MappingException {
        return this.operatorMapped.getPositionOperatorWrapper(operatorWrapper);
    }

    public boolean equals(OperatorWrapper that) {
        return  this.getOperatorMapped().getOperatorRheem().toString().equalsIgnoreCase( that.getOperatorRheem().toString() );
    }
}
