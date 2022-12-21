package com.example.aop.v1;

import com.example.aop.trace.TraceStatus;
import com.example.aop.v0.helloTrace.HelloTraceV0;
import com.example.aop.v1.helloTrace.LogTrace;
import com.example.aop.v1.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {


    private final OrderServiceV1 orderService;
    private final LogTrace trace;

    @GetMapping("/v1/request")
    public String request(String itemId){
        return new AbstractTemplate<String>(trace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        }.execute("OrderControllerV1.request()");
    }
}
