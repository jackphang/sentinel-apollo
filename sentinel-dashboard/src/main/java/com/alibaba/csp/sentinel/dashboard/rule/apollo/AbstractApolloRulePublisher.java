package com.alibaba.csp.sentinel.dashboard.rule.apollo;

import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.fastjson.JSON;
import com.ctrip.framework.apollo.openapi.client.ApolloOpenApiClient;
import com.ctrip.framework.apollo.openapi.dto.NamespaceReleaseDTO;
import com.ctrip.framework.apollo.openapi.dto.OpenItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("flowRuleApolloPublisher")
public abstract class AbstractApolloRulePublisher implements DynamicRulePublisher {

    @Autowired
    private ApolloOpenApiClient apolloOpenApiClient;


    @Autowired
    private ApolloProperties apolloProperties;


    @Override
    public void publish(String app, Object rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }
        String dataId = getDataId();

        pushRulesToApollo(app, dataId, rules);
    }

    protected abstract String getDataId();

    /**
     * 推送规则到apollo
     *
     * @param appName
     * @param dataId
     * @return
     */
    protected void pushRulesToApollo(String appName, String dataId, Object rules) {


        OpenItemDTO openItemDTO = new OpenItemDTO();
        openItemDTO.setKey(dataId);
        openItemDTO.setComment(RuleIdEnum.getComment(dataId));
        openItemDTO.setValue(JSON.toJSONString(rules));
        openItemDTO.setDataChangeCreatedBy(apolloProperties.getUserName());
        apolloOpenApiClient.createOrUpdateItem(appName, apolloProperties.getEnv(), apolloProperties.getClusterName(), apolloProperties.getNamspaceName(), openItemDTO);

        // Release configuration
        NamespaceReleaseDTO namespaceReleaseDTO = new NamespaceReleaseDTO();
        namespaceReleaseDTO.setEmergencyPublish(true);
        namespaceReleaseDTO.setReleasedBy(apolloProperties.getUserName());
        namespaceReleaseDTO.setReleaseTitle("被sentinel修改并发布");
        apolloOpenApiClient.publishNamespace(appName, apolloProperties.getEnv(), apolloProperties.getClusterName(), apolloProperties.getNamspaceName(), namespaceReleaseDTO);
    }

}