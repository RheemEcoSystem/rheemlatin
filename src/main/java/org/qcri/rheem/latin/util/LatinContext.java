package org.qcri.rheem.latin.util;

import org.antlr.runtime.tree.Tree;
import org.qcri.rheem.latin.exception.ExecException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.net.URLClassLoader;
/**
 * Created by bertty on 08-03-17.
 */
public class LatinContext {


    private static Object instantiationLock = new Object();

    public static final String JOB_NAME = "jobName";
    public static final String JOB_NAME_PREFIX= "PigLatin";
    public static final String JOB_PRIORITY = "jobPriority";
    public static final String PIG_CMD_ARGS_REMAINDERS = "pig.cmd.args.remainders";

    transient public Map<String, Tree> macros;

    private Properties properties;

    private List<String> params;
    private List<String> paramFiles;
    private String last_alias = null;

    /*
     * Resources for the job (jars, scripting udf files, cached macro abstract syntax trees)
     */

    // Jar files that are global to the whole Pig script, includes
    // 1. registered jars
    // 2. Jars defined in -Dpig.additional.jars
    transient public List<URL> extraJars = new LinkedList<URL>();

    // original paths each extra jar came from
    // used to avoid redundant imports
    transient private Map<URL, String> extraJarOriginalPaths = new HashMap<URL, String>();


    /**
     * a table mapping names to streaming commands.
     */
    private Map<String, StreamingCommand> definedCommands =
            new HashMap<String, StreamingCommand>();

    // List of paths skipped for automatic shipping
    List<String> skippedShipPaths = new ArrayList<String>();
   // transient private PreprocessorContext preprocessorContext = new PreprocessorContext(50);

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    /**
     * extends URLClassLoader to allow adding to classpath as new jars
     * are registered.
     */
    private static class ContextClassLoader extends URLClassLoader {

        public ContextClassLoader(ClassLoader classLoader) {
            this(new URL[0], classLoader);
        }

        public ContextClassLoader(URL[] urls, ClassLoader classLoader) {
            super(urls, classLoader);
        }

        @Override
        public void addURL(URL url) {
            super.addURL(url);
        }
    };

    static private ContextClassLoader classloader = new ContextClassLoader(LatinContext.class.getClassLoader());

    public static ClassLoader getClassLoader() {
        return classloader;
    }

    public static void setClassLoader(ClassLoader cl) {
        if (cl instanceof ContextClassLoader) {
            classloader = (ContextClassLoader) cl;
        } else {
            classloader = new ContextClassLoader(cl);
        }
    }

    public List<String> getParams() {
        return params;
    }
    public void setParams(List<String> params) {
        this.params = params;
    }

    public List<String> getParamFiles() {
        return paramFiles;
    }
    public void setParamFiles(List<String> paramFiles) {
        this.paramFiles = paramFiles;
    }

  ///  public PreprocessorContext getPreprocessorContext() {
  ///  public PreprocessorContext getPreprocessorContext() {
  ///  public PreprocessorContext getPreprocessorContext() {
  ///  public PreprocessorContext getPreprocessorContext() {
  ///  public PreprocessorContext getPreprocessorContext() {
  ///  public PreprocessorContext getPreprocessorContext() {
  ///  public PreprocessorContext getPreprocessorContext() {
  ///  public PreprocessorContext getPreprocessorContext() {
  ///  public PreprocessorContext getPreprocessorContext() {
  ///  public PreprocessorContext getPreprocessorContext() {
  ///  public PreprocessorContext getPreprocessorContext() {
  //      return preprocessorContext;
  //  }

    public String doParamSubstitution(InputStream in,
                                      List<String> params,
                                      List<String> paramFiles)
            throws IOException {

        return doParamSubstitution(new BufferedReader(new InputStreamReader(in)),
                params, paramFiles);
    }

    public String doParamSubstitution(BufferedReader reader,
                                      List<String> params,
                                      List<String> paramFiles)
            throws IOException {
        this.params = params;
        this.paramFiles = paramFiles;
        return doParamSubstitution(reader);
    }

    public String doParamSubstitution(BufferedReader reader) throws IOException {
    /**    try {
            preprocessorContext.setPigContext(this);
            preprocessorContext.loadParamVal(params, paramFiles);
            ParameterSubstitutionPreprocessor psp
                    = new ParameterSubstitutionPreprocessor(preprocessorContext);
            StringWriter writer = new StringWriter();
            psp.genSubstitutedFile(reader, writer);
            return writer.toString();
        } catch (ParseException e) {
            log.error(e.getLocalizedMessage());
            throw new IOException(e);
        }**/
        return "Problema";
    }

    /**
     * Defines an alias for the given streaming command.
     *
     * This is useful for complicated streaming command specs.
     *
     * @param alias - the new command alias to define.
     * @param command - the command
     */
    public void registerStreamCmd(String alias, StreamingCommand command) {
        if (command == null) {
            definedCommands.remove(alias);
        } else {
            definedCommands.put(alias, command);
        }
    }

    /**
     * Get paths which are to skipped while automatically shipping binaries for
     * streaming.
     *
     * @return paths which are to skipped while automatically shipping binaries
     *         for streaming
     */
    public List<String> getPathsToSkip() {
        return skippedShipPaths;
    }

    public String getLastAlias() {
        return this.last_alias;
    }
    public void setLastAlias(String value) {
        this.last_alias = value;
    }

    /**
     * Get the {@link StreamingCommand} for the given alias.
     *
     * @param alias the alias for the <code>StreamingCommand</code>
     * @return <code>StreamingCommand</code> for the alias
     */
    public StreamingCommand getCommandForAlias(String alias) {
        return definedCommands.get(alias);
    }

    public void addJar(String path) throws MalformedURLException {
        if (path != null) {
            URL resource = (new File(path)).toURI().toURL();
            addJar(resource, path);
        }
    }

    public void addJar(URL resource, String originalPath) throws MalformedURLException{
        if (resource != null && !extraJars.contains(resource)) {
            extraJars.add(resource);
            extraJarOriginalPaths.put(resource, originalPath);
            classloader.addURL(resource);
            Thread.currentThread().setContextClassLoader(LatinContext.classloader);
        }
    }
}
