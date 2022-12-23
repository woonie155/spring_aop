package com.example.aop.v1;

import com.example.aop.v1.callback.TraceCallback;
import com.example.aop.trace.LogTrace;
import com.example.aop.v1.template.CallbackTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {


    private final OrderServiceV1 orderService;
    private final LogTrace trace;
    private final CallbackTemplate callbackTemplate;

//    @GetMapping("/v1/request")
//    public String request(String itemId){
//        return new AbstractTemplate<String>(trace) {
//            @Override
//            protected String call() {
//                orderService.orderItem(itemId);
//                return "ok";
//            }
//        }.execute("OrderControllerV1.request()");
//    }

    @GetMapping("/v1/request")
    public String request(String itemId){
        return callbackTemplate.execute("OrderControllerV1.request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }
}
