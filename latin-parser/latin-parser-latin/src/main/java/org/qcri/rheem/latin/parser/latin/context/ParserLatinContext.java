package org.qcri.rheem.latin.parser.latin.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.qcri.rheem.latin.core.context.LatinContext;
import org.qcri.rheem.latin.core.context.ParserImportClass;
import org.qcri.rheem.latin.parser.latin.exception.ParserLatinException;
import org.qcri.rheem.latin.parser.latin.mapping.ExpressionMapping;
import org.qcri.rheem.latin.parser.latin.mapping.MappingFinal;
import org.qcri.rheem.latin.parser.latin.mapping.enums.ExpressionTypeClass;
import org.qcri.rheem.latin.parser.latin.mapping.transition.MappingTransform;
import org.qcri.rheem.latin.parser.latin.mapping.transition.ParserLatinTransition;
import org.qcri.rheem.latin.parser.latin.parser.LatinLexer;

import java.io.IOException;
import java.net.URI;

public class ParserLatinContext extends LatinContext {

    private static LoadMockupClass LOADER = null;
    private static ParserImportClass IMPORTS = null;

    public ParserLatinContext(URI location_configuration) {
        super(location_configuration);
    }

    @Override
    protected void initVariables() {
        if(LOADER == null) {
            LOADER = new LoadMockupClass();
            IMPORTS = new ParserImportClass();
            putConfiguration("mockupClass", LOADER);
            putConfiguration("imports", IMPORTS);
        }
    }

    @Override
    public void loadContext() {
        loadOperators();

    }

    public static LoadMockupClass getLoaderClass(){
        return LOADER;
    }

    public static ParserImportClass getImportClass() {
        return IMPORTS;
    }


    public void loadOperators(){
        try {
            ObjectMapper mapper = new ObjectMapper();

            ParserLatinTransition mapping = mapper.readValue(this.location_configuration.toURL(), ParserLatinTransition.class);

            for(MappingTransform trans: mapping.getOperator_mapping()){
                MappingFinal trans_final = trans.transform();
                LOADER.addOperatorMapping(trans_final.getName(), trans_final);
                LatinLexer.addOperator(trans_final.getName());
            }

            for(MappingTransform trans: mapping.getExpression_mapping()){
                MappingFinal trans_final = trans.transform();
                LOADER.addExpressionsMapping(trans_final.getName(), trans_final);
                ExpressionTypeClass et = ((ExpressionMapping)trans_final).getType_class();
                switch (et){
                    case UNARY:
                        LatinLexer.addPrefixOperator(trans_final.getName());
                        break;
                    case BINARY:
                        LatinLexer.addBinaryOperator(trans_final.getName());
                        break;
                    default:
                        throw new ParserLatinException("Problems with the type of the class");
                }
            }

            for(MappingTransform trans: mapping.getFunction_mapping()){
                MappingFinal trans_final = trans.transform();
                LOADER.addFunctionMapping(trans_final.getName(), trans_final);
                LatinLexer.addFunction(trans_final.getName());
            }

            for(MappingTransform trans: mapping.getWrapper_mapping()){
                MappingFinal trans_final = trans.transform();
                LOADER.addWrapperMapping(trans_final.getName(), trans_final);
                LatinLexer.addOperator(trans_final.getName());
            }
        } catch (IOException e) {
            throw new ParserLatinException(e);
        }
    }
}
