package com.example.aop.v5ProxyFactory;

public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    public OrderServiceV5(OrderRepositoryV5 orderRepository){
        this.orderRepository=orderRepository;
    }

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
