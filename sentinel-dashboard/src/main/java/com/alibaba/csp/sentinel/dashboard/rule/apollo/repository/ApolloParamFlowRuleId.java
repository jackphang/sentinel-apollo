package com.alibaba.csp.sentinel.dashboard.rule.apollo.repository;

import com.alibaba.csp.sentinel.dashboard.repository.rule.InMemParamFlowRuleStore;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 重写nextId()方法
 *
 * @author jackphang
 * @version 2020-01-08 19:38
 */
@Component
@Primary
public class ApolloParamFlowRuleId extends InMemParamFlowRuleStore {

    /**
     * sentinel 重启后，再增加规则时，id是从1开始的，也就是说会覆盖之前的规则
     * 所以使用时间戳作为ID，保证sentinel重启后数据依然存在
     */
    @Override
    protected long nextId() {
        return System.currentTimeMillis();
    }
}
