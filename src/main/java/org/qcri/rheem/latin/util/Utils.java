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


import java.util.*;

/**
 * Class with utility static methods
 */
public class Utils {
    public static <O> Collection<O> mergeCollection(Collection<O> a, Collection<O> b) {
        if (a==null && b==null)
            return null;
        Collection<O> result = null;
        try {
            if (a!=null)
                result = a.getClass().newInstance();
            else
                result = b.getClass().newInstance();
        } catch (Exception e) {
            // Shall not happen
        }
        if (a==null) {
            result.addAll(b);
        }
        else if (b==null) {
            result.addAll(a);
        }
        else {
            result.addAll(a);
            for (O o : b) {
                if (!result.contains(o)) {
                    result.add(o);
                }
            }
        }

        return result;
    }
}
