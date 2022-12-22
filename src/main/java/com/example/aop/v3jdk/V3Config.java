package com.example.aop.v3jdk;

import com.example.aop.v1.helloTrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class V3Config {

    public static final String[] PATTERNS = {"request*", "order*", "save*"};


    @Bean
    public OrderControllerV3 orderControllerV3(LogTrace logTrace){
        OrderControllerV3 orderController = new OrderControllerV3Impl(orderServiceV3(logTrace));
        Object proxy = Proxy.newProxyInstance(OrderControllerV3.class.getClassLoader(),
                new Class[]{OrderControllerV3.class},
                new LogHandler(orderController, logTrace, PATTERNS));
        return (OrderControllerV3) proxy;
    }

    @Bean
    public OrderServiceV3 orderServiceV3(LogTrace logTrace) {
        OrderServiceV3 orderService = new OrderServiceV3Impl(orderRepositoryV3(logTrace));
        Object proxy = Proxy.newProxyInstance(OrderServiceV3.class.getClassLoader(),
                        new Class[]{OrderServiceV3.class},
                        new LogHandler(orderService, logTrace, PATTERNS)
                );
        return (OrderServiceV3) proxy;
    }
    @Bean
    public OrderRepositoryV3 orderRepositoryV3(LogTrace logTrace) {
        OrderRepositoryV3 orderRepository = new OrderRepositoryV3Impl();
        Object proxy = Proxy.newProxyInstance(OrderRepositoryV3.class.getClassLoader(),
                        new Class[]{OrderRepositoryV3.class},
                        new LogHandler(orderRepository, logTrace, PATTERNS)
                );
        return (OrderRepositoryV3) proxy;
    }
}
