# Sentinel 控制台
官网 https://github.com/alibaba/Sentinel

##此仓库主要是用于集成Apollo

###改动点，以及后续版本升级问题

#### 1.Controller相关修改 
```properties
AuthorityRuleController
DegradeController
ParamFlowRuleController
SystemController
FlowControllerV2
```

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
        
#### 6.客户端配置
##### 6.1 pom.xml
  <!--sentinel限流-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
            <version>1.5.1.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>com.alibaba.csp</groupId>
            <artifactId>sentinel-datasource-apollo</artifactId>
            <version>1.7.1</version>
        </dependency>
##### 6.2 properties 
```properties

#sentinel配置

apollo.meta=http://10.29.23.84:8080
spring.cloud.sentinel.transport.port=18090
spring.cloud.sentinel.transport.dashboard=http://127.0.0.1:8080
spring.cloud.sentinel.transport.clientIp=10.7.168.16

spring.cloud.sentinel.enabled=true
spring.cloud.sentinel.eager=true


# sentinel datasource apollo
##流控规则
spring.cloud.sentinel.datasource.ds0.apollo.namespaceName=application
spring.cloud.sentinel.datasource.ds0.apollo.rule-type=flow
spring.cloud.sentinel.datasource.ds0.apollo.flowRulesKey=sentinel.flow-rules

##降级规则
spring.cloud.sentinel.datasource.ds1.apollo.namespaceName=application
spring.cloud.sentinel.datasource.ds1.apollo.rule-type=degrade
spring.cloud.sentinel.datasource.ds1.apollo.flowRulesKey=sentinel.degrade-rules

##热点规则
spring.cloud.sentinel.datasource.ds2.apollo.namespaceName=application
spring.cloud.sentinel.datasource.ds2.apollo.rule-type=param_flow
spring.cloud.sentinel.datasource.ds2.apollo.flowRulesKey=sentinel.param-flow-rules

##系统规则
spring.cloud.sentinel.datasource.ds3.apollo.namespaceName=application
spring.cloud.sentinel.datasource.ds3.apollo.rule-type=system
spring.cloud.sentinel.datasource.ds3.apollo.flowRulesKey=sentinel.system-rules

##授权规则
spring.cloud.sentinel.datasource.ds4.apollo.namespaceName=application
spring.cloud.sentinel.datasource.ds4.apollo.rule-type=authority
spring.cloud.sentinel.datasource.ds4.apollo.flowRulesKey=sentinel.authority-rules

feign.sentinel.enabled=true
management.endpoints.web.exposure.include=*

```


##### 6.3自定义限流返回结果
@Slf4j
@Component
public class SentinelConfigurer implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        WebCallbackManager.setUrlBlockHandler((HttpServletRequest request, HttpServletResponse response, BlockException e) -> {
            log.info("blocked: {}", request.getPathInfo());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            ResultData resultData = ResultData.build("FLOW_LIMITED", "流量被限制,请降低访问速度");
            OutUtil.print(response, JSON.toJSONString(resultData));
        });
        WebCallbackManager.setUrlCleaner(originUrl -> {
            if (StringUtils.isEmpty(originUrl)) {
                return originUrl;
            }
            if (originUrl.endsWith(".ico")) {
                return "";
            }
            return originUrl;
        });
    }
}
