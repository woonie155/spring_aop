package com.example.aop.v7AutoProxyCreator;

import com.example.aop.trace.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class V7Config {
    @Bean
    public Advisor v7advisor(LogTrace logTrace) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.example.aop.v7AutoProxyCreator..*(..)) " +
                "&& !execution(* com.example.aop.v7AutoProxyCreator..noLog(..))");
        LogAdvice advice = new LogAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
