package com.example.aop.v4CGLIB;

import com.example.aop.v1.helloTrace.LogTrace;
import com.example.aop.v3jdk.OrderControllerV3;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class V4Config {
    public static final String[] PATTERNS = {"request*", "order*", "save*"};


    @Bean
    public OrderControllerV4 orderControllerV4(LogTrace logTrace){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderControllerV4.class);
        enhancer.setCallback(new LogHandler(new OrderControllerV4(), logTrace, PATTERNS));
        OrderControllerV4 proxy = (OrderControllerV4)enhancer.create();
        return proxy;
    }

    @Bean
    public OrderServiceV4 orderServiceV4(LogTrace logTrace){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderServiceV4.class);
        enhancer.setCallback(new LogHandler(new OrderServiceV4(), logTrace, PATTERNS));
        OrderServiceV4 proxy = (OrderServiceV4)enhancer.create();
        return proxy;
    }

    @Bean
    public OrderRepositoryV4 orderRepositoryV4(LogTrace logTrace){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderRepositoryV4.class);
        enhancer.setCallback(new LogHandler(new OrderRepositoryV4(), logTrace, PATTERNS));
        OrderRepositoryV4 proxy = (OrderRepositoryV4)enhancer.create();
        return proxy;
    }
}
