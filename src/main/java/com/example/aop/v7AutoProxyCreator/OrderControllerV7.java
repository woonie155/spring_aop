package com.example.aop.v7AutoProxyCreator;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV7 {

    private final OrderServiceV7 orderService;


    @GetMapping("/v7/request")
    public String request(String itemId){
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v7/no-log")
    public String noLog() {
        return "ok";
    }
}
