/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.lib.profiler.wireprotocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Response to the client's request to dump the current rough profiling data contents into the shared-memory file.
 *
 * @author Misha Dmitriev
 * @author Ian Formanek
 */
public class DumpResultsResponse extends Response {
    //~ Instance fields ----------------------------------------------------------------------------------------------------------

    private long dumpAbsTimeStamp;

    //~ Constructors -------------------------------------------------------------------------------------------------------------

    public DumpResultsResponse(boolean yes, long absTimeStamp) {
        super(yes, DUMP_RESULTS);
        this.dumpAbsTimeStamp = absTimeStamp;
    }

    // Custom serialization support
    DumpResultsResponse() {
        super(true, DUMP_RESULTS);
    }

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    public long getDumpAbsTimeStamp() {
        return dumpAbsTimeStamp;
    }

    // For debugging
    public String toString() {
        return "DumpResultsResponse, timeStamp: " + dumpAbsTimeStamp + ", " + super.toString(); // NOI18N
    }

    void readObject(ObjectInputStream in) throws IOException {
        dumpAbsTimeStamp = in.readLong();
    }

    void writeObject(ObjectOutputStream out) throws IOException {
        out.writeLong(dumpAbsTimeStamp);
    }
}
