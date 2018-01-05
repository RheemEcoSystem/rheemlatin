package org.qcri.rheem.latin.parser.latin.engine;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.qcri.rheem.latin.core.Exception.LatinException;
import org.qcri.rheem.latin.core.engine.LatinEngine;
import org.qcri.rheem.latin.core.plan.LatinPlan;
import org.qcri.rheem.latin.parser.latin.context.ParserLatinContext;
import org.qcri.rheem.latin.parser.latin.parser.ConvertListener;
import org.qcri.rheem.latin.parser.latin.parser.LatinLexer;
import org.qcri.rheem.latin.parser.latin.parser.LatinParser;
import org.qcri.rheem.latin.parser.latin.query.plan.FileInputPlan;

import java.io.IOException;
import java.net.URI;

public class ParserLatinEngine extends LatinEngine {
    public ParserLatinEngine(String name) {
        super(name);
        //TODO change the path
        this.context = new ParserLatinContext(URI.create("file:///Users/bertty/Qatar/rheem-latin/latin-parser/latin-parser-latin/src/main/resources/latin.conf.operator.json"));
    }

    @Override
    public LatinPlan preExecute(LatinPlan plan, Object... obj) {
        return plan;
    }

    @Override
    public LatinPlan doexecute(LatinPlan plan, Object... obj) {
        System.out.println("parserLatinEngine");
        if(plan instanceof FileInputPlan){
            FileInputPlan file = (FileInputPlan)plan;
            try {
                CharStream archivo       = new ANTLRFileStream(file.getPath());
                CommonTokenStream tokens = new CommonTokenStream(new LatinLexer(archivo));
                LatinParser parser       = new LatinParser(tokens);

                ParserRuleContext ast    = parser.query();
                ConvertListener listener = new ConvertListener();
                ParseTreeWalker walker   = new ParseTreeWalker();

                walker.walk(listener, ast);

                LatinPlan plan_output = listener.getPlan();
                return plan_output;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LatinException e){
                e.printStackTrace();
                System.exit(1);
            }
            return null;
        }
        return null;
    }

    @Override
    public LatinPlan postExecute(LatinPlan plan, Object... obj) {
        return plan;
    }
}
