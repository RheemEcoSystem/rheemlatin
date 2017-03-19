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

package org.qcri.rheem.latin.exception;

import org.antlr.runtime.IntStream;
import org.qcri.rheem.latin.util.SourceLocation;

public class InvalidCommandException extends LatinRecognitionException {
    private static final long serialVersionUID = 1L;
    
    private String cmd;
    
    public InvalidCommandException(IntStream input, SourceLocation loc, String cmd) {
        super( input, loc );
        this.cmd = cmd;
    }
    
    public String toString() {
        return msgHeader() + "Ill-formed command line: " + cmd;
    }

    public String getCmd() {
        return cmd;
    }

}
