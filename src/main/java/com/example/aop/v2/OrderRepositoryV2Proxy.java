package com.example.aop.v2;

import com.example.aop.trace.TraceStatus;
import com.example.aop.v1.helloTrace.LogTrace;

public class OrderRepositoryV2Proxy extends OrderRepositoryV2{

    private final OrderRepositoryV2 target;
    private final LogTrace trace;

    public OrderRepositoryV2Proxy(OrderRepositoryV2 target, LogTrace trace) {
        this.target = target;
        this.trace = trace;
    }


    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepositoryV2.save()");
            target.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
