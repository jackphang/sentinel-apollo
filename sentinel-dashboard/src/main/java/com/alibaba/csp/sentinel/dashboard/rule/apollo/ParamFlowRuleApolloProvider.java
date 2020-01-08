package com.alibaba.csp.sentinel.dashboard.rule.apollo;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 热点规则
 *
 * @author jackphang
 * @version 2020-01-08 16:44
 */
@Component("paramFlowRuleApolloProvider")
public class ParamFlowRuleApolloProvider extends AbstractApolloRuleProvider {

    @Override
    public List<ParamFlowRuleEntity> getRules(String appName) throws Exception {
        List<ParamFlowRule> paramFlowRuleList = super.getRules(appName);
        if (CollectionUtils.isEmpty(paramFlowRuleList)) {
            return new ArrayList<>();
        }
        List<ParamFlowRuleEntity> paramFlowRuleEntityList = paramFlowRuleList.stream()
                .map(e -> ParamFlowRuleEntity.fromAuthorityRule(appName, null, null, e)).collect(Collectors.toList());

        return paramFlowRuleEntityList;

    }

    @Override
    protected String getDataId() {
        return RuleIdEnum.PARAM_FLOW_DATA_ID_POSTFIX.getDataId();
    }

    @Override
    protected Class getRuleClazz() {
        return ParamFlowRule.class;
    }
}
