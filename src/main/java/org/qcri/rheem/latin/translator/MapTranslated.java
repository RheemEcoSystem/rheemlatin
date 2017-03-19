package org.qcri.rheem.latin.translator;

import java.util.List;

/**
 * Created by bertty on 14-03-17.
 */
public abstract class MapTranslated {
    protected List<Translated> operator_translated = null;

    public boolean validateTranslate(){
        return false;
    };

    public void addOperatorTranslated(Translated operator){
        this.operator_translated.add(operator);
    }

    public List<Translated> getOperatorTranslated(){
        return this.operator_translated;
    }

    public boolean searchName(String name){
        for(Translated operator: operator_translated){
            if( operator.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public Mapped findMapped(String name){
        for(Translated operator: operator_translated){
            if( operator.getName().equalsIgnoreCase(name)){
                return operator.getMapped();
            }
        }
        return null;
    }

    public int size(){
        return this.operator_translated.size();
    }


}
