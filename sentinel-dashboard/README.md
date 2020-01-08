# Sentinel 控制台
官网 https://github.com/alibaba/Sentinel

##此仓库主要是用于集成Apollo

###改动点，以及后续版本升级问题

#### 1.Controller相关修改 
###### AuthorityRuleController
###### DegradeController
###### ParamFlowRuleController
###### SystemController
###### FlowControllerV2
搜索 集成apollo-jackphang

#### 2.com.alibaba.csp.sentinel.dashboard.rule.apollo 包下所有的文件

#### 3.html页面 sidebar.html 搜索 apollo集成

#### 4.application.properties配置
    apollo.portalUrl=http://config.tplife.com
    apollo.token=f743530fdc15c7e43f33acd8131548bafdf87904
    apollo.env=DEV
    apollo.namspace=
    apollo.clusterName=

#### 5.pom.xml 增加
     <dependency>
            <groupId>com.ctrip.framework.apollo</groupId>
            <artifactId>apollo-openapi</artifactId>
            <version>1.5.1</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba.csp</groupId>
            <artifactId>sentinel-datasource-apollo</artifactId>
        </dependency>