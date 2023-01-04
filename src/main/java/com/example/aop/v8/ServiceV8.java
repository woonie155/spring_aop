package com.example.aop.v8;

import com.example.aop.v8.annotation.Trace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceV8 {
    private final RepositoryV8 repositoryV8;

    @Trace
    public void request(String itemId) {
        repositoryV8.save(itemId);
    }
}