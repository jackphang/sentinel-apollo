package com.alibaba.csp.sentinel.dashboard.rule.apollo;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统规则
 *
 * @author jackphang
 * @version 2020-01-08 16:44
 */
@Component("systemRuleApolloProvider")
public class SystemRuleApolloProvider extends AbstractApolloRuleProvider {

    @Override
    public List<SystemRuleEntity> getRules(String appName) throws Exception {
        return super.getRules(appName);
    }

    @Override
    protected String getDataId() {
        return RuleIdEnum.SYSTEM_DATA_ID_POSTFIX.getDataId();
    }

    @Override
    protected Class getRuleClazz() {
        return SystemRuleEntity.class;
    }
}
