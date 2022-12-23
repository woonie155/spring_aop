package com.example.aop;

import com.example.aop.trace.ThreadLocalLogTrace;
import com.example.aop.trace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    //v1 구현체용
    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}