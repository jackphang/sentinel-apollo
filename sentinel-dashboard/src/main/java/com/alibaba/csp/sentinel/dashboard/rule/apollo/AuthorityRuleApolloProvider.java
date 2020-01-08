package com.alibaba.csp.sentinel.dashboard.rule.apollo;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 授权规则
 * @author jackphang
 * @version 2020-01-08 16:43
 */
@Component("authorityRuleApolloProvider")
public class AuthorityRuleApolloProvider extends AbstractApolloRuleProvider {

    @Override
    public List<AuthorityRuleEntity> getRules(String appName) throws Exception {
        return super.getRules(appName);
    }

    @Override
    protected String getDataId() {
        return RuleIdEnum.AUTHORITY_DATA_ID_POSTFIX.getDataId();
    }

    @Override
    protected Class getRuleClazz() {
        return AuthorityRuleEntity.class;
    }
}
