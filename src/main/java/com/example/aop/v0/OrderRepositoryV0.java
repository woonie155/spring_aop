package com.example.aop.v0;

import com.example.aop.trace.TraceId;
import com.example.aop.trace.TraceStatus;
import com.example.aop.v0.helloTrace.HelloTraceV0;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {
    private final HelloTraceV0 trace;

    public void save(TraceId traceId, String itemId){
        TraceStatus status = null;

        try {
            status = trace.beginSync(traceId, "OrderRepositoryV0.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("IllegalStateException 예외: OrderRepositoryV0.save() 중");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
