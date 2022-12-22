package com.example.aop.v4CGLIB;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class OrderServiceV4 {

    @Autowired private OrderRepositoryV4 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
