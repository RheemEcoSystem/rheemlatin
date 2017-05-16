package org.qcri.rheem.latin.parser;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.qcri.rheem.latin.LatinEngine;
import org.qcri.rheem.latin.plan.LatinPlan;

import java.io.IOException;

/**
 * Created by bertty on 09-04-17.
 */
public class ParserEngine extends LatinEngine {

    public ParserEngine(){
        this.load();
    }

    public void load(){
        super.load();
        LoaderTokens.load();

    }


    @Override
    public LatinPlan execute(LatinPlan plan, Object ... obj) {
        String string_plan = (String) obj[0];
        try {
            CharStream archivo       = new ANTLRFileStream(string_plan);
            CommonTokenStream tokens = new CommonTokenStream(new LatinLexer(archivo));
            LatinParser parser       = new LatinParser(tokens);

            ParserRuleContext ast    = parser.query();

            ConvertListener listener = new ConvertListener();
            ParseTreeWalker walker   = new ParseTreeWalker();

            walker.walk(listener, ast);

            this.plan = listener.getPlan();
            this.plan.print();
            return this.plan;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
