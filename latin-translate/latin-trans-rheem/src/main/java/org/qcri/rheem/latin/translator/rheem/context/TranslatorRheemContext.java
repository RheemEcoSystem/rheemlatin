package org.qcri.rheem.latin.translator.rheem.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.qcri.rheem.latin.core.context.LatinContext;
import org.qcri.rheem.latin.translator.rheem.exception.TranslatorRheemException;
import org.qcri.rheem.latin.translator.rheem.mapping.RheemClassMapping;
import org.qcri.rheem.latin.translator.rheem.mapping.transition.RheemContextTransition;

import java.io.IOException;
import java.net.URI;

public class TranslatorRheemContext extends LatinContext{

    private static TranslatorRheemReflexion RHEEMMAPPING = null;
    public TranslatorRheemContext(URI location_configuration) {
        super(location_configuration);
    }

    @Override
    protected void initVariables() {
        if(RHEEMMAPPING == null){
            RHEEMMAPPING = new TranslatorRheemReflexion();
        }
    }

    @Override
    public void loadContext() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            RheemContextTransition mapping = mapper.readValue(this.location_configuration.toURL(), RheemContextTransition.class);

            for(RheemClassMapping rheem_obj: mapping.transform()){
                RHEEMMAPPING.put(rheem_obj.getLatinOperator(), rheem_obj);
            }
        }catch (IOException e) {
            throw new TranslatorRheemException(e);
        }

    }

    public static TranslatorRheemReflexion getReflexion(){
        return RHEEMMAPPING;
    }

}
