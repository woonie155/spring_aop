package com.example.aop.v0;

import com.example.aop.trace.TraceStatus;
import com.example.aop.v0.helloTrace.HelloTraceV0;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV0 {


    private final OrderServiceV0 orderService;
    private final HelloTraceV0 trace;

    @GetMapping("/v0/request")
    public String request(String itemId){
        TraceStatus status = null;

        try {
            status = trace.begin("OrderControllerV0.request()");
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
