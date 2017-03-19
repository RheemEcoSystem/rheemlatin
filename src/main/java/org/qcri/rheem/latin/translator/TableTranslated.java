package org.qcri.rheem.latin.translator;

import java.util.ArrayList;

/**
 * Created by bertty on 14-03-17.
 */
public class TableTranslated extends MapTranslated{

    public TableTranslated(){
        this.operator_translated = new ArrayList<Translated>();
    }

    @Override
    public boolean validateTranslate() {
        for( Translated translated: this.operator_translated){
            if ( ! translated.isTranslationComplete() ){
                return false;
            }
        }
        return true;
    }
}
