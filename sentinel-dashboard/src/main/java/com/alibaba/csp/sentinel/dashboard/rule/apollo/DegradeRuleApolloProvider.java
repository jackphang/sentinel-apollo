package com.alibaba.csp.sentinel.dashboard.rule.apollo;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 降级规则
 *
 * @author jackphang
 * @version 2020-01-08 16:43
 */
@Component("degradeRuleApolloProvider")
public class DegradeRuleApolloProvider extends AbstractApolloRuleProvider {

    @Override
    public List<DegradeRuleEntity> getRules(String appName) throws Exception {
        return super.getRules(appName);
    }

    @Override
    protected String getDataId() {
        return RuleIdEnum.DEGRADE_DATA_ID_POSTFIX.getDataId();
    }

    @Override
    protected Class getRuleClazz() {
        return DegradeRuleEntity.class;
    }
}
