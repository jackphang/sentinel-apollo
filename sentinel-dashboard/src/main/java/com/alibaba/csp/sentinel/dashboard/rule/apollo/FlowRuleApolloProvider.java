package com.alibaba.csp.sentinel.dashboard.rule.apollo;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 流控规则
 *
 * @author jackphang
 * @version 2020-01-08 16:44
 */
@Component("flowRuleApolloProvider")
public class FlowRuleApolloProvider extends AbstractApolloRuleProvider {

    @Override
    public List<FlowRuleEntity> getRules(String appName) throws Exception {
        return super.getRules(appName);
    }

    @Override
    protected String getDataId() {
        return RuleIdEnum.FLOW_DATA_ID_POSTFIX.getDataId();
    }

    @Override
    protected Class getRuleClazz() {
        return FlowRuleEntity.class;
    }
}
