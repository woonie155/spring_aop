package com.example.aop.v2;

import com.example.aop.v1.helloTrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class V2Config {

    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace) {
        OrderControllerV2 impl = new OrderControllerV2(orderServiceV2(logTrace));
        return new OrderControllerV2Proxy(impl, logTrace);
    }
    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace) {
        OrderServiceV2 impl = new OrderServiceV2(orderRepositoryV2(logTrace));
        return new OrderServiceV2Proxy(impl, logTrace);
    }
    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace) {
        OrderRepositoryV2 impl = new OrderRepositoryV2();
        return new OrderRepositoryV2Proxy(impl, logTrace);
    }

}
