package com.example.aop.v3jdk;


public class OrderServiceV3Impl implements OrderServiceV3{

    private final OrderRepositoryV3 orderRepository;

    public OrderServiceV3Impl(OrderRepositoryV3 orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
