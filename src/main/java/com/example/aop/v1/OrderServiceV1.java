package com.example.aop.v1;

import com.example.aop.trace.TraceId;
import com.example.aop.trace.TraceStatus;
import com.example.aop.v0.helloTrace.HelloTraceV0;
import com.example.aop.v1.helloTrace.LogTrace;
import com.example.aop.v1.template.AbstractTemplate;
import com.example.aop.v1.template.CallbackTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepository;
    private final LogTrace trace;
    private final CallbackTemplate callbackTemplate;

//    public void orderItem(String itemId) {
//        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
//            @Override
//            protected Void call() {
//                orderRepository.save(itemId);
//                return null;
//            }
//        };
//        template.execute("OrderServiceV1.orderItem()");
//    }

    public void orderItem(String itemId) {
        callbackTemplate.execute("OrderServiceV1.request()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }

}
