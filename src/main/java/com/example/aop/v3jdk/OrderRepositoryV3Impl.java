package com.example.aop.v3jdk;



public class OrderRepositoryV3Impl implements OrderRepositoryV3{
    @Override
    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("OrderRepositoryV3Impl 예외");
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
