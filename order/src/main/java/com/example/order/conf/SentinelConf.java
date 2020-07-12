package com.example.order.conf;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SentinelConf {
    @PostConstruct
    public void initDegradeRule() {
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
//        rule.setResource(KEY);
        rule.setResource("blockHandler");
        // set threshold RT, 10 ms
        rule.setCount(4);
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        rule.setTimeWindow(20);

        DegradeRule rule1 = new DegradeRule();
//        rule.setResource(KEY);
        rule1.setResource("blockHandlerClass");
        // set threshold RT, 10 ms
        rule1.setCount(4);
        rule1.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        rule1.setTimeWindow(20);

        rules.add(rule);
        rules.add(rule1);
        DegradeRuleManager.loadRules(rules);
    }

    @PostConstruct
    public void initFlowRule() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("limitThreadCount");
        rule.setCount(5);
        rule.setGrade(RuleConstant.FLOW_GRADE_THREAD);
        rule.setLimitApp("default");
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);

        FlowRule rule1 = new FlowRule();
        rule1.setResource("limitQps");
        rule1.setCount(5);
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule1.setLimitApp("default");
        rule1.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);

        rules.add(rule);
        rules.add(rule1);
        FlowRuleManager.loadRules(rules);
    }

}
