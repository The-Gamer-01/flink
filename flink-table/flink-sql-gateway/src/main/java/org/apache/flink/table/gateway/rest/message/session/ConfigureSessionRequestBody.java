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

package org.apache.flink.table.gateway.rest.message.session;

import org.apache.flink.runtime.rest.messages.RequestBody;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nullable;

/** {@link RequestBody} for configuring a session. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigureSessionRequestBody implements RequestBody {

    private static final String FIELD_NAME_STATEMENT = "statement";
    private static final String FIELD_NAME_EXECUTION_TIMEOUT = "executionTimeout";

    @JsonProperty(FIELD_NAME_STATEMENT)
    private final String statement;

    @JsonProperty(FIELD_NAME_EXECUTION_TIMEOUT)
    @Nullable
    private final Long timeout;

    public ConfigureSessionRequestBody(
            @JsonProperty(FIELD_NAME_STATEMENT) String statement,
            @Nullable @JsonProperty(FIELD_NAME_EXECUTION_TIMEOUT) Long timeout) {
        this.statement = statement;
        this.timeout = timeout;
    }

    public String getStatement() {
        return statement;
    }

    @Nullable
    public Long getTimeout() {
        return timeout;
    }
}
