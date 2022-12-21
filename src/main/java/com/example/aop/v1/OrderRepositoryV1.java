package com.example.aop.v1;

import com.example.aop.trace.TraceId;
import com.example.aop.trace.TraceStatus;
import com.example.aop.v0.helloTrace.HelloTraceV0;
import com.example.aop.v1.helloTrace.LogTrace;
import com.example.aop.v1.template.AbstractTemplate;
import com.example.aop.v1.template.CallbackTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {
    private final LogTrace trace;
    private final CallbackTemplate callbackTemplate;

//    public void save(String itemId){
//        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
//            @Override
//            protected Void call() {
//                //저장 로직
//                if (itemId.equals("ex")) {
//                    throw new IllegalStateException("IllegalStateException 예외: OrderRepositoryV1.save() 중");
//                }
//                sleep(1000);
//                return null;
//            }
//        };
//        template.execute("OrderRepositoryV1.save()");
//    }

    public void save(String itemId) {
        callbackTemplate.execute("OrderRepositoryV1.save()", () -> {
            //저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
