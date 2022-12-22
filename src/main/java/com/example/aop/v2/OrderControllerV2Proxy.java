package com.example.aop.v2;

import com.example.aop.trace.TraceStatus;
import com.example.aop.v1.helloTrace.LogTrace;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping
@ResponseBody
public class OrderControllerV2Proxy extends OrderControllerV2{

    private final OrderControllerV2 target;
    private final LogTrace trace;

    public OrderControllerV2Proxy(OrderControllerV2 target, LogTrace trace) {
        super(null);
        this.target = target;
        this.trace = trace;
    }
    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderControllerV2.request()");
            String result = target.request(itemId);
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
    @Override
    public String noLog() {
        return target.noLog();
    }
}
