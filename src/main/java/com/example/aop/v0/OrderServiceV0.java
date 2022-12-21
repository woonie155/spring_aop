package com.example.aop.v0;

import com.example.aop.trace.TraceId;
import com.example.aop.trace.TraceStatus;
import com.example.aop.v0.helloTrace.HelloTraceV0;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 문제점
 * 1. 관련 메소드들이 모두 traceId 파라미터를 의존해야하는 설계가 된다.
 * ex) 다른 곳에서 서비스를 호출하면 traceId가 생성되어 있어야만 한다.  = 재사용성 문제
 * ex) begin, beginSync 호출 구분해서 설계해야한다.
 */
@Service
@RequiredArgsConstructor
public class OrderServiceV0 {

    private final OrderRepositoryV0 orderRepository;
    private final HelloTraceV0 trace;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;

        try {
            status = trace.beginSync(traceId, "OrderServiceV0.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
