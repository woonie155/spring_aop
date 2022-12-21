package com.example.aop.v1.callback;

import org.springframework.stereotype.Component;

@Component
public interface TraceCallback<T> {
    T call();
}
