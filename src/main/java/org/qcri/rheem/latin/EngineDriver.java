package org.qcri.rheem.latin;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qcri.rheem.latin.exception.*;
import org.qcri.rheem.latin.parser.*;
import org.qcri.rheem.latin.plan.Operator;
import org.qcri.rheem.latin.plan.logical.LogicalPlan;
import org.qcri.rheem.latin.plan.logical.LogicalPlanGenerator;
import org.qcri.rheem.latin.plan.logical.LogicalSchema;
import org.qcri.rheem.latin.util.LatinContext;
import org.qcri.rheem.latin.util.FileLocalizer;
import org.qcri.rheem.latin.util.FileLocalizer.FetchFileRet;
import org.qcri.rheem.latin.util.SourceLocation;

import java.io.*;
import java.util.*;

/**
 * Created by bertty on 08-03-17.
 */
public class EngineDriver implements ParserDriver {
    private static final Log LOG = LogFactory.getLog(EngineDriver.class);

    private static final String MACRO_DEF = "MACRO_DEF";
    private static final String MACRO_INLINE = "MACRO_INLINE";
    private static final String IMPORT_DEF = "import";
    private static final String REGISTER_DEF = "register";

    private LatinContext latinContext;
    private String scope;
    private Map<String, String> fileNameMap;
    private Map<String, Operator> operators;
    private String lastRel;
    private Set<String> importSeen;
    private Set<String> macroSeen;

    private static Map<String, FetchFileRet> fnameMap = new HashMap<String, FetchFileRet>();

    public EngineDriver(LatinContext latinContext, String scope, Map<String, String> fileNameMap) {
        this.latinContext = latinContext;
        this.scope = scope;
        this.fileNameMap = fileNameMap;
        importSeen = new HashSet<String>();
        macroSeen = new HashSet<String>();
    }

    private static Tree parseSchema(CommonTokenStream tokens) throws ParserException {
        QueryParser parser = QueryParserUtils.createParser(tokens);

        QueryParser.schema_return result = null;
        try {
            result = parser.schema();
        } catch (RecognitionException e) {
            String msg = parser.getErrorHeader(e) + " "
                    + parser.getErrorMessage(e, parser.getTokenNames());
            throw new ParserException(msg);
        } catch(RuntimeException ex) {
            throw new ParserException( ex.getMessage() );
        }

        Tree ast = (Tree)result.getTree();
        checkError( parser );

        return ast;
    }

    public LogicalSchema parseSchema(String input) throws ParserException {
        CommonTokenStream tokenStream = tokenize( input, null );
        LogicalSchema schema = null;
        Tree ast = parseSchema( tokenStream );

        try{
            CommonTreeNodeStream nodes = new CommonTreeNodeStream( ast );
            AstValidator walker = new AstValidator( nodes );
            ast = (Tree)walker.field_def_list().getTree();
            checkError( walker );

            LogicalPlanGenerator planGenerator =
                    new LogicalPlanGenerator( new CommonTreeNodeStream( ast ), latinContext, scope, fileNameMap );
            schema = planGenerator.field_def_list().schema;
            checkError( planGenerator );
        } catch(RecognitionException ex) {
            throw new ParserException( ex );
        } catch(Exception ex) {
            throw new ParserException( ex.getMessage(), ex );
        }

        return schema;
    }

    private static Tree parseConstant(CommonTokenStream tokens) throws ParserException {
        QueryParser parser = QueryParserUtils.createParser(tokens);

        QueryParser.literal_return result = null;
        try {
            result = parser.literal();
        } catch (RecognitionException e) {
            String msg = parser.getErrorHeader(e) + " "
                    + parser.getErrorMessage(e, parser.getTokenNames());
            throw new ParserException(msg);
        } catch(RuntimeException ex) {
            throw new ParserException( ex.getMessage() );
        }

        Tree ast = (Tree)result.getTree();
        checkError( parser );

        return ast;
    }

    public Object parseConstant(String input) throws ParserException {
        CommonTokenStream tokenStream = tokenize( input, null );
        Object value = null;
        Tree ast = parseConstant( tokenStream );

        try{
            CommonTreeNodeStream nodes = new CommonTreeNodeStream( ast );
            AstValidator walker = new AstValidator( nodes );
            ast = (Tree)walker.literal().getTree();
            checkError( walker );

            LogicalPlanGenerator planGenerator =
                    new LogicalPlanGenerator( new CommonTreeNodeStream( ast ), latinContext, scope, fileNameMap );
            value = planGenerator.literal().value;
            checkError( planGenerator );
        } catch(RecognitionException ex) {
            throw new ParserException( ex );
        } catch(Exception ex) {
            throw new ParserException( ex.getMessage(), ex );
        }

        return value;
    }

    public LogicalPlan parse(String query) throws ParserException {
        LogicalPlan plan = null;

    ///    ScriptState ss = ScriptState.get();
    ///    CommonTokenStream tokenStream = tokenize(query, ss.getFileName());
        CommonTokenStream tokenStream = tokenize(query, "latin_query");

        Tree ast = parse( tokenStream );
        ast = expandMacro( ast );

        try{
            ast = validateAst( ast );
    //            applyRegisters(ast);
    //            applyRegisters(ast);
    //            applyRegisters(ast);
    //            applyRegisters(ast);
    //            applyRegisters(ast);
    //            applyRegisters(ast);
    //            applyRegisters(ast);
    //            applyRegisters(ast);
    //            applyRegisters(ast);
    //            applyRegisters(ast);

            System.out.println(ast.toStringTree());




            LogicalPlanGenerator planGenerator =
                    new LogicalPlanGenerator( new CommonTreeNodeStream( ast ), latinContext, scope, fileNameMap );
            planGenerator.query();
            checkError( planGenerator );

            plan = planGenerator.getLogicalPlan();
            operators = planGenerator.getOperators();
            lastRel = planGenerator.getLastRel();
        } catch(RecognitionException ex) {
            throw new ParserException( ex );
        } catch(Exception ex) {
            throw new ParserException( ex.getMessage(), ex );
        }

        return plan;
    }

    public Map<String, Operator> getOperators() {
        return operators;
    }

    static CommonTokenStream tokenize(String query, String source)
            throws ParserException {
        CharStream input;
        try {
            input = new QueryParserStringStream(query, source);
        } catch (IOException ex) {
            throw new ParserException("Unexpected IOException: "
                    + ex.getMessage());
        }
        QueryLexer lexer = new QueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        checkError(lexer);
        return tokens;
    }

    private static void checkError(BaseRecognizer recognizer)
            throws ParserException {
        int errorCount = recognizer.getNumberOfSyntaxErrors();
        if (0 < errorCount)
            throw new ParserException("Encountered " + errorCount
                    + " parsing errors in the query");
    }

    static Tree parse(CommonTokenStream tokens) throws ParserException {
        QueryParser parser = QueryParserUtils.createParser(tokens);

        QueryParser.query_return result = null;
        try {
            result = parser.query();
        } catch (RecognitionException e) {
            String msg = parser.getErrorHeader(e) + " "
                    + parser.getErrorMessage(e, parser.getTokenNames());
            SourceLocation location = new SourceLocation(null, e.line,e.charPositionInLine);
            throw new ParserException(msg, location);
        } catch(RuntimeException ex) {
            throw new ParserException( ex.getMessage() );
        }

        Tree ast = (Tree) result.getTree();
        checkError(parser);

        return ast;
    }

    private static Tree validateAst(Tree ast) throws RecognitionException, ParserException {
        CommonTreeNodeStream nodes = new CommonTreeNodeStream( ast );
        AstValidator walker = new AstValidator( nodes );
        AstValidator.query_return newResult = walker.query();
        Tree newAst = (Tree)newResult.getTree();

        checkError( walker );

        return newAst;
    }

    Tree expandMacro(Tree ast) throws ParserException {
        LOG.debug("Original macro AST:\n" + ast.toStringTree() + "\n");

        // first insert the import files
        try {
            while (expandImport(ast))
                ;
        } catch (ImportException e) {
            e.printStackTrace();
        }

        LOG.debug("macro AST after import:\n" + ast.toStringTree() + "\n");

        List<CommonTree> macroNodes = new ArrayList<CommonTree>();
        List<CommonTree> inlineNodes = new ArrayList<CommonTree>();

        // find all macro def/inline nodes
        traverse(ast, macroNodes, inlineNodes);

        Map<String, LatinMacro> seen = new HashMap<String, LatinMacro>();
        List<LatinMacro> macroDefs = new ArrayList<LatinMacro>();

        // gether all the def nodes
        for (CommonTree t : macroNodes) {
            macroDefs.add(makeMacroDef(t, seen));
        }

        // inline macros
        inlineMacro(inlineNodes, macroDefs);

        LOG.debug("Resulting macro AST:\n" + ast.toStringTree() + "\n");

        return ast;
    }

    private void inlineMacro(List<CommonTree> inlineNodes,
                             List<LatinMacro> macroDefs) throws ParserException {
        for (CommonTree t : inlineNodes) {
            Set<String> macroStack = new HashSet<String>();
            CommonTree newTree = LatinMacro.macroInline(t, macroDefs, macroStack, latinContext);

            List<CommonTree> nodes = new ArrayList<CommonTree>();
            traverseInline(newTree, nodes);

            if (nodes.isEmpty()) {
                QueryParserUtils.replaceNodeWithNodeList(t, newTree, null);
            } else {
                inlineMacro(nodes, macroDefs);
            }
        }
    }



    private void traverseInline(Tree t, List<CommonTree> nodes) {
        if (t.getText().equals(MACRO_INLINE)) {
            nodes.add((CommonTree)t);
        }
        int n = t.getChildCount();
        for (int i = 0; i < n; i++) {
            Tree t0 = t.getChild(i);
            traverseInline(t0, nodes);
        }
    }

    private boolean expandImport(Tree ast) throws ParserException, ImportException {
        List<CommonTree> nodes = new ArrayList<CommonTree>();
        traverseImport(ast, nodes);
        if (nodes.isEmpty())
            return false;

        for (CommonTree t : nodes) {
            macroImport(t);
        }

        return true;
    }

    static void traverseImport(Tree t, List<CommonTree> nodes) {
        if (t.getText().equalsIgnoreCase(IMPORT_DEF)) {
            nodes.add((CommonTree)t);
        }
        int n = t.getChildCount();
        for (int i = 0; i < n; i++) {
            Tree t0 = t.getChild(i);
            traverseImport(t0, nodes);
        }
    }

    static void traverse(Tree t, List<CommonTree> macroNodes,
                         List<CommonTree> inlineNodes) {
        if (t.getText().equals(MACRO_DEF)) {
            macroNodes.add((CommonTree) t.getParent());
        } else if (t.getText().equals(MACRO_INLINE)) {
            inlineNodes.add((CommonTree) t);
        }
        int n = t.getChildCount();
        for (int i = 0; i < n; i++) {
            Tree t0 = t.getChild(i);
            traverse(t0, macroNodes, inlineNodes);
        }
    }

    private FetchFileRet getMacroFile(String fname) {
        FileLocalizer.FetchFileRet localFileRet = null;
        try {
            if (fnameMap.get(fname) != null) {
                localFileRet = fnameMap.get(fname);
            } else {
                try {
                    File localFile = QueryParserUtils.getFileFromImportSearchPath(fname);
                    if (localFile == null){
                        throw new FileNotFoundException("file not found in route :"+ fname);
                    }
                    localFileRet =  new FetchFileRet(localFile.getCanonicalFile(), false);
                } catch (FileNotFoundException e) {
                    // ignore this since we'll attempt to load as a resource before failing
                    LOG.debug(String.format("Macro file %s was not found", fname));
                }

                // try loading the macro file as a resource in case it is packaged in a registered jar
                if (localFileRet == null) {
                    LOG.debug(String.format("Attempting to load macro file %s as a resource", fname));

                    try
                    {
                        localFileRet = FileLocalizer.fetchResource(fname);
                        LOG.debug(String.format("Found macro file %s as resource", fname));
                    }
                    catch (ResourceNotFoundException e)
                    {
                        LOG.debug(String.format("Macro file %s was not found as resource either", fname));
                        LOG.error(String.format("Failed to find macro file %s", fname));
                        throw new ExecException("file '" + fname + "' does not exist.", 101, LatinException.INPUT);
                    }
                }

                fnameMap.put(fname, localFileRet);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to fetch macro file '" + fname + "'", e);
        }
        return localFileRet;
    }

    /*
     * MacroDef node has two child nodes:
     *      1. name
     *      2. MACRO_DEF (PARAMS, RETURN_VAL, MACRO_BODY)
     */
    private LatinMacro makeMacroDef(CommonTree t, Map<String, LatinMacro> seen)
            throws ParserException {
        String mn = t.getChild(0).getText();

        if (!macroSeen.add(mn)) {
            String msg = getErrorMessage(null, t, null,
                    "Duplicated macro name '" + mn + "'");
            throw new ParserException(msg);
        }

        if (seen != null) {
            for (String s : seen.keySet()) {
                macroSeen.add(s);
            }
        }

        String fname = ((LatinParserNode)t).getFileName();

        Tree defNode = t.getChild(1);

        // get parameter markers
        ArrayList<String> params = new ArrayList<String>();
        Tree paramNode = defNode.getChild(0);
        int n = paramNode.getChildCount();
        for (int i = 0; i < n; i++) {
            params.add(paramNode.getChild(i).getText());
        }

        // get return alias markers
        ArrayList<String> returns = new ArrayList<String>();
        Tree retNode = defNode.getChild(1);
        int m = retNode.getChildCount();
        for (int i = 0; i < m; i++) {
            returns.add(retNode.getChild(i).getText());
        }

        // get macro body
        Tree bodyNode = defNode.getChild(2);
        String body = bodyNode.getChild(0).getText();

        body = body.substring(1, body.length() - 1);

        // sometimes the script has no filename, like when a string is passed to PigServer for
        // example. See PIG-2866.
        if (!fname.isEmpty()) {
            FetchFileRet localFileRet = getMacroFile(fname);
            fname = localFileRet.file.getAbsolutePath();
        }

        LatinMacro pm = new LatinMacro(mn, fname, params, returns, body, seen);

        try {
            pm.validate();
        } catch (IOException e) {
            String msg = getErrorMessage(null, t,
                    "Invalid macro definition: ", e.getMessage());
            throw new ParserException(msg);
        }

        // set the starting line number of the macro
        LatinParserNode pnode = (LatinParserNode)bodyNode.getChild(0);
        pm.setStartLine(pnode.getStartLine());

        seen.put(mn, pm);

        // delete this node
        Tree defineNode = t.getParent();
        Tree stmtNode = defineNode.getParent();
        stmtNode.deleteChild(defineNode.getChildIndex());

        return pm;
    }

    private void macroImport(CommonTree t) throws ImportException {
        // remove quote
        String fname = t.getChild(0).getText();
        fname = QueryParserUtils.removeQuotes(fname);
        if (!importSeen.add(fname)) {
            // we've already imported this file, so just skip this import statement
            LOG.debug("Ignoring duplicated import " + fname);
            t.getParent().deleteChild(t.getChildIndex());
            return;
        }

        Tree macroAST = null;
        if (latinContext.macros.containsKey(fname)) {
            macroAST = latinContext.macros.get(fname);
        } else {
            throw new ImportException("Macro Not Found");
        }

        QueryParserUtils.replaceNodeWithNodeList(t, (CommonTree)macroAST, fname);
    }

    private String getErrorMessage(String importFile, CommonTree t, String header, String reason) {
        StringBuilder sb = new StringBuilder();
        LatinParserNode node = (LatinParserNode)t;
        String file = node.getFileName();
        sb.append("<");
        if (file == null) {
            file = "<<null>>";
        }
        if (!file.isEmpty() && !file.equals(importFile)) {
            sb.append("at ").append(file).append(", ");
        }
        sb.append("line ").append(t.getLine()).append("> ").append(header);
        if (reason != null) {
            sb.append(". Reason: ").append(reason);
        }
        return sb.toString();
    }

    public String getLastRel() {
        return lastRel;
    }

}
