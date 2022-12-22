package com.example.aop.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

@Slf4j
@RestController
public class TmpController {

//    @Autowired private AnnotationConfigServletWebServerApplicationContext applicationContext;
//    @Autowired private OrderControllerV2 proxy;
//
//    @GetMapping("/tmp")
//    public String test() {
//        String[] data = applicationContext.getBeanDefinitionNames();
//        log.info("-----");
//        for (String s : data)
//            if (s.indexOf("V2") > 0) log.info("{}", s);
//        log.info("-----");
//        proxy.request("test1");
//        return "o";
//    }
}
