package com.example.aop.helloTrace;

import com.example.aop.trace.TraceStatus;
import com.example.aop.v0.helloTrace.HelloTraceV0;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class V1Test {

    @Test
    void begin_end(){
        HelloTraceV0 trace = new HelloTraceV0();
        TraceStatus status = trace.begin("message1");
        trace.end(status);
    }

    @Test
    void begin_exception(){
        HelloTraceV0 trace = new HelloTraceV0();
        TraceStatus status = trace.begin("message1");
        trace.exception(status, new IllegalStateException());
    }

}
