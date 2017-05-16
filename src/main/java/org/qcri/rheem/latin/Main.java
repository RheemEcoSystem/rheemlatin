package org.qcri.rheem.latin;

import org.qcri.rheem.basic.data.RecordDinamic;
import org.qcri.rheem.latin.parser.ParserEngine;
import org.qcri.rheem.latin.translator.TranslatorEngine;

/**
 * Created by bertty on 03-04-17.
 */
public class Main {

    public static void main(String ... args) throws Exception {

        RecordDinamic.stadistic = true;

        HandlerEngine handler = new HandlerEngine();

        handler.registrerEngine(new ParserEngine(), args[0]);

        handler.registrerEngine(new TranslatorEngine());

        handler.run();

    }

}
