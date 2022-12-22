package com.example.aop.v5ProxyFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@RequestMapping
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;

    public OrderControllerV5(OrderServiceV5 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/v5/request")
    public String request(String itemId){
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v5/no-log")
    public String noLog() {
        return "ok";
    }
}
