package com.example.aop.v6BeanPostProcessor;

import com.example.aop.trace.TraceStatus;
import com.example.aop.trace.LogTrace;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class LogAdvice implements MethodInterceptor {
    private final LogTrace logTrace;
    public LogAdvice(LogTrace logTrace) {
        this.logTrace = logTrace;
    }
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        TraceStatus status = null;

        try {
            Method method = invocation.getMethod();
            String message = method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()";
            status = logTrace.begin(message);
            Object result = invocation.proceed();
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
