package com.example.aop.v7AutoProxyCreator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV7 {
    private final OrderRepositoryV7 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
