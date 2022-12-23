package com.example.aop.v4CGLIB;

import com.example.aop.trace.TraceStatus;
import com.example.aop.trace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.util.PatternMatchUtils;

import java.lang.reflect.Method;

@Slf4j
public class LogHandler implements MethodInterceptor {
    private final Object target;
    private final LogTrace logTrace;
    private final String[] patterns;

    public LogHandler(Object target, LogTrace logTrace, String[] patterns){
        this.target = target;
        this.logTrace = logTrace;
        this.patterns = patterns;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        String methodName = method.getName();

        if (!PatternMatchUtils.simpleMatch(patterns, methodName)) {
            return method.invoke(target, args);
        }

        TraceStatus status = null;
        try {
            String message = method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()";
            status = logTrace.begin(message);
            Object result = proxy.invoke(target, args);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
