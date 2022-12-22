package com.example.aop.v6BeanPostProcessor;

import com.example.aop.v5ProxyFactory.OrderServiceV5;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV6 {

    private final OrderServiceV6 orderService;


    @GetMapping("/v6/request")
    public String request(String itemId){
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v6/no-log")
    public String noLog() {
        return "ok";
    }
}
