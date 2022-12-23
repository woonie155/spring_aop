package com.example.aop.v1.template;

import com.example.aop.trace.TraceStatus;
import com.example.aop.v1.callback.TraceCallback;
import com.example.aop.trace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CallbackTemplate {
    private final LogTrace trace;

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = callback.call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}