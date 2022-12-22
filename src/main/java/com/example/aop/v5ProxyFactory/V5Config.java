package com.example.aop.v5ProxyFactory;

import com.example.aop.v1.helloTrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class V5Config {

    @Bean
    public OrderControllerV5 orderControllerV5(LogTrace logTrace) {
        OrderControllerV5 orderController = new OrderControllerV5(orderServiceV5(logTrace));
        ProxyFactory factory = new ProxyFactory(orderController);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderControllerV5 proxy = (OrderControllerV5) factory.getProxy();
        log.info("ProxyFactory proxy={}, target={}", proxy.getClass(), orderController.getClass());
        return proxy;
    }
    @Bean
    public OrderServiceV5 orderServiceV5(LogTrace logTrace) {
        OrderServiceV5 orderService = new OrderServiceV5(orderRepositoryV5(logTrace));
        ProxyFactory factory = new ProxyFactory(orderService);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderServiceV5 proxy = (OrderServiceV5) factory.getProxy();
        log.info("ProxyFactory proxy={}, target={}", proxy.getClass(), orderService.getClass());
        return proxy;
    }
    @Bean
    public OrderRepositoryV5 orderRepositoryV5(LogTrace logTrace) {
        OrderRepositoryV5 orderRepository = new OrderRepositoryV5();
        ProxyFactory factory = new ProxyFactory(orderRepository);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderRepositoryV5 proxy = (OrderRepositoryV5) factory.getProxy();
        log.info("ProxyFactory proxy={}, target={}", proxy.getClass(), orderRepository.getClass());
        return proxy;
    }
    private Advisor getAdvisor(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        LogAdvice advice = new LogAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
