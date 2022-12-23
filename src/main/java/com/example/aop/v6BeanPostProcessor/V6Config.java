package com.example.aop.v6BeanPostProcessor;

import com.example.aop.trace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class V6Config {
    @Bean
    public LogProxyPostProcessor logProxyPostProcessor(LogTrace logTrace) {
        return new LogProxyPostProcessor("com.example.aop.v6", getAdvisor(logTrace));
    }
    private Advisor getAdvisor(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        LogAdvice advice = new LogAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }


}
