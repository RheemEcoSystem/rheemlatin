/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * This is helper class for parameter substitution
 */

package org.qcri.rheem.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.util.Shell;
//import org.apache.pig.impl.PigContext;
//import org.apache.pig.impl.logicalLayer.FrontendException;
//import org.apache.pig.validator.BlackAndWhitelistFilter;
//import org.apache.pig.validator.PigCommandFilter;
import org.python.google.common.base.Preconditions;
import org.qcri.rheem.parser.ParseException;
import org.qcri.rheem.util.ParamLoader;

public class PreprocessorContext {

    private Map<String, String> param_val;

    //private PigContext pigContext;
    private Object pigContext;

    public Map<String, String> getParamVal() {
        return param_val;
    }

    private final Log log = LogFactory.getLog(getClass());

    /**
     * @param limit - max number of parameters. Passing
     *                smaller number only impacts performance
     */
    public PreprocessorContext(int limit) {
        param_val = new Hashtable<String, String> (limit);
    }

    public PreprocessorContext(Map<String, String> paramVal) {
        param_val = paramVal;
    }

    public void setPigContext(Object context) {
        this.pigContext = context;
    }


    /*
     * executes the 'cmd' in shell and returns result
     */
    private String executeShellCommand (String cmd)
    {
        Process p;
        String streamData="";
        String streamError="";
        try {
            log.info("Executing command : " + cmd);
            // we can't use exec directly since it does not handle
            // case like foo -c "bar bar" correctly. It splits on white spaces even in presents of quotes
            StringBuffer sb  = new StringBuffer("");
            String[] cmdArgs;
            if (Shell.WINDOWS) {
                cmd = cmd.replaceAll("/", "\\\\");
                sb.append(cmd);
                cmdArgs = new String[]{"cmd", "/c", sb.toString() };
            } else {
                sb.append("exec ");
                sb.append(cmd);
                cmdArgs = new String[]{"bash", "-c", sb.toString() };
            }

            p = Runtime.getRuntime().exec(cmdArgs);

        } catch (IOException e) {
            RuntimeException rte = new RuntimeException("IO Exception while executing shell command : "+e.getMessage() , e);
            throw rte;
        }

        BufferedReader br = null;
        try{
            InputStreamReader isr = new InputStreamReader(p.getInputStream());
            br = new BufferedReader(isr);
            String line=null;
            StringBuilder sb = new StringBuilder();
            while ( (line = br.readLine()) != null){
                sb.append(line);
                sb.append("\n");
            }
            streamData = sb.toString();
        } catch (IOException e){
            RuntimeException rte = new RuntimeException("IO Exception while executing shell command : "+e.getMessage() , e);
            throw rte;
        } finally {
            if (br != null) try {br.close();} catch(Exception e) {}
        }

        try {
            InputStreamReader isr = new InputStreamReader(p.getErrorStream());
            br = new BufferedReader(isr);
            String line=null;
            StringBuilder sb = new StringBuilder();
            while ( (line = br.readLine()) != null ) {
                sb.append(line);
                sb.append("\n");
            }
            streamError = sb.toString();
            log.debug("Error stream while executing shell command : " + streamError);
        } catch (Exception e) {
            RuntimeException rte = new RuntimeException("IO Exception while executing shell command : "+e.getMessage() , e);
            throw rte;
        } finally {
            if (br != null) try {br.close();} catch(Exception e) {}
        }

        int exitVal;
        try {
            exitVal = p.waitFor();
        } catch (InterruptedException e) {
            RuntimeException rte = new RuntimeException("Interrupted Thread Exception while waiting for command to get over"+e.getMessage() , e);
            throw rte;
        }

        if (exitVal != 0) {
            RuntimeException rte = new RuntimeException("Error executing shell command: " + cmd + ". Command exit with exit code of " + exitVal );
            throw rte;
        }

        return streamData.trim();
    }

    public void loadParamVal(List<String> params, List<String> paramFiles)
                throws IOException, ParseException {
        StringReader dummyReader = null; // ParamLoader does not have an empty contructor
        ParamLoader paramLoader = new ParamLoader(dummyReader);
        paramLoader.setContext(this);

        if (paramFiles != null) {
            for (String path : paramFiles) {
                BufferedReader in = new BufferedReader(new FileReader(path));
                paramLoader.ReInit(in);
                while (paramLoader.Parse()) {}
                in.close();
            }
        }
        
        if (params != null) {
            for (String param : params) {
                paramLoader.ReInit(new StringReader(param));
                paramLoader.Parse();
            }
        }
    }

    private Pattern bracketIdPattern = Pattern.compile("\\$\\{([_]*[a-zA-Z][a-zA-Z_0-9]*)\\}");
    private Pattern id_pattern = Pattern.compile("\\$([_]*[a-zA-Z][a-zA-Z_0-9]*)");

}


