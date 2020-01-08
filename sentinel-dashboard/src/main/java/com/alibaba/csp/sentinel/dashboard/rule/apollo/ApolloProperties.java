package com.alibaba.csp.sentinel.dashboard.rule.apollo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApolloProperties {

    @Value("${apollo.portalUrl}")
    private String portalUrl;

    @Value("${apollo.token}")
    private String token;


    @Value("${apollo.env}")
    private String env;

    @Value("${apollo.namspace:application}")
    private String namspaceName;

    @Value("${apollo.clusterName:}")
    private String clusterName;

    @Value("${apollo.userName:apollo}")
    private String userName;

    public String getPortalUrl() {
        return portalUrl;
    }

    public String getToken() {
        return token;
    }


    public String getEnv() {
        return env;
    }


    public String getNamspaceName() {
        return namspaceName;
    }

    public String getClusterName() {
        return clusterName;
    }

    public String getUserName() {
        return userName;
    }
}
