package com.example.aop.v1.helloTrace;

import com.example.aop.trace.TraceStatus;
import org.springframework.stereotype.Component;

@Component
public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
