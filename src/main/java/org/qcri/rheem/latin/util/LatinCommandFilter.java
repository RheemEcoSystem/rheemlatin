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
package org.qcri.rheem.latin.util;

import org.qcri.rheem.latin.exception.FrontendException;

import java.io.IOException;

/**
 * 
 * Interface defining Pig commands and a
 * {@link LatinCommandFilter#validate(Command)} method to operate on it
 * 
 */
public interface LatinCommandFilter {

    public enum Command {
        DEFINE, DECLARE, DEFAULT, EXPLAIN, EXEC, FS, IMPORT, LS, SH, MAPREDUCE, REGISTER, SET, CAT, CD, DUMP, KILL, PWD, MV, CP, COPYTOLOCAL, COPYFROMLOCAL, MKDIR, RM, RMF, RUN, ILLUSTRATE
    }

    /**
     * Validates a Pig command as defined by {@link Command}.
     * 
     * @param command
     * @throws IOException
     */
    public void validate(Command command) throws FrontendException;

}
