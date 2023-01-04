package com.example.aop.v8;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ControllerV8 {

    private final ServiceV8 serviceV8;

    @GetMapping("/v8/request")
    public String request(String itemId){
        for(int i=0; i<5; i++) serviceV8.request(itemId+i);
        return "ok";
    }
}
