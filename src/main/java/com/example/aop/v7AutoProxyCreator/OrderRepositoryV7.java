package com.example.aop.v7AutoProxyCreator;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV7 {

    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생!");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
