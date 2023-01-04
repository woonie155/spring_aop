package com.example.aop.v8;

import com.example.aop.v8.annotation.Retry;
import com.example.aop.v8.annotation.Trace;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryV8 {

    private static int seq=0;

    @Trace
    @Retry
    public String save(String itemId) {
        seq++;
        if (seq % 5 == 0) {
            throw new IllegalStateException("예외 발생");
        }
        return "ok";
    }
}
