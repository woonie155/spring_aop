package com.example.aop.v2;


import com.example.aop.trace.TraceStatus;
import com.example.aop.trace.LogTrace;

public class OrderServiceV2Proxy extends OrderServiceV2{

    private final OrderServiceV2 target;
    private final LogTrace trace;

    public OrderServiceV2Proxy(OrderServiceV2 target, LogTrace trace) {
        super(null);
        this.target = target;
        this.trace = trace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderServiceV2.orderItem()");
            target.orderItem(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
