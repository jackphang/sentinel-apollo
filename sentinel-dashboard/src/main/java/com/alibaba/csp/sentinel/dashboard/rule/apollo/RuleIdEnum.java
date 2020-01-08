/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.rule.apollo;


import java.util.Objects;


public enum RuleIdEnum {

    FLOW_DATA_ID_POSTFIX("sentinel.flow-rules", "流控规则"),//
    DEGRADE_DATA_ID_POSTFIX("sentinel.degrade-rules", "降级规则"),//
    PARAM_FLOW_DATA_ID_POSTFIX("sentinel.param-flow-rules", "热点规则"),//
    SYSTEM_DATA_ID_POSTFIX("system.flow-rules", "系统规则"),//
    AUTHORITY_DATA_ID_POSTFIX("sentinel.authority-rules", "授权规则");//

    private String dataId;
    private String comment;

    RuleIdEnum(String dataId, String comment) {
        this.dataId = dataId;
        this.comment = comment;
    }

    public String getDataId() {
        return this.dataId;
    }

    public static String getComment(String dataId) {
        for (RuleIdEnum ruleEnum : values()) {
            if (Objects.equals(ruleEnum.getDataId(), dataId)) {
                return ruleEnum.comment;
            }
        }
        return "";
    }
}




