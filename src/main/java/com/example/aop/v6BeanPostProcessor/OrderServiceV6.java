package com.example.aop.v6BeanPostProcessor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV6 {
    private final OrderRepositoryV6 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
