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

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 热点规则
 *
 * @author jackphang
 * @version 2020-01-08 16:44
 */
@Component("paramFlowRuleApolloPublisher")
public class ParamFlowRuleApolloPublisher extends AbstractApolloRulePublisher {

    @Override
    public void publish(String app, Object rules) throws Exception {
        List<ParamFlowRuleEntity> paramFlowRuleEntityList = (List<ParamFlowRuleEntity>) rules;
        List<ParamFlowRule> paramFlowRuleList = paramFlowRuleEntityList.stream().map(ParamFlowRuleEntity::getRule).collect(Collectors.toList());
        super.publish(app, paramFlowRuleList);
    }

    @Override
    protected String getDataId() {
        return RuleIdEnum.PARAM_FLOW_DATA_ID_POSTFIX.getDataId();
    }
}
