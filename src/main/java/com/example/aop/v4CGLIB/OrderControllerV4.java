package com.example.aop.v4CGLIB;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequestMapping
public class OrderControllerV4 {

    @Autowired private OrderServiceV4 orderService;

    @GetMapping("/v4/request")
    public String request(String itemId){
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v4/no-log")
    public String noLog() {
        return "ok";
    }
}
