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

package org.qcri.rheem.latin.parser;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.qcri.rheem.latin.util.SourceLocation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class QueryParserUtils {


    static String generateErrorHeader(RecognitionException ex, String filename) {
        return new SourceLocation( filename, ex.line, ex.charPositionInLine ).toString();
    }

    public static QueryParser createParser(CommonTokenStream tokens) {
        return createParser(tokens, 0);
    }

    static QueryParser createParser(CommonTokenStream tokens, int lineOffset) {
        QueryParser parser = new QueryParser(tokens);
        LatinParserNodeAdaptor adaptor = new LatinParserNodeAdaptor(
                tokens.getSourceName(), lineOffset);
        parser.setTreeAdaptor(adaptor);
        return parser;
    }

    public static void replaceNodeWithNodeList(Tree oldNode, CommonTree newTree,
                                        String fileName) {
        int idx = oldNode.getChildIndex();

        CommonTree parent = (CommonTree) oldNode.getParent();
        int count = parent.getChildCount();

        List childList = new ArrayList(parent.getChildren());
        List macroList = newTree.getChildren();

        while (parent.getChildCount() > 0) {
            parent.deleteChild(0);
        }

        for (int i = 0; i < count; i++) {
            if (i == idx) {
                // add only there is something to add
                if (macroList != null) {
                    parent.addChildren(macroList);
                }
            } else {
                parent.addChild((Tree) childList.get(i));
            }
        }
    }

    public static File getFileFromImportSearchPath(String scriptPath) {
        File f = new File(scriptPath);
        if (f.exists() || f.isAbsolute() || scriptPath.startsWith("./")
                || scriptPath.startsWith("../")) {
            return f;
        }

        return null;
    }

    public static String removeQuotes(String str) {
        if (str.startsWith("\u005c'") && str.endsWith("\u005c'"))
            return str.substring(1, str.length() - 1);
        else
            return str;
    }

}
