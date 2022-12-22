package com.example.aop.v3jdk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping
@ResponseBody
public interface OrderControllerV3 {
    @GetMapping("/v3/request")
    String request(@RequestParam(value = "itemId") String itemId);

    @GetMapping("/v3/no-log")
    String noLog();
}