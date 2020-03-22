package com.rebwon.shop.model.order.domain;

public class Order {
    public enum OrderStatus{ ORDERED, PAYED, CANCELD }

    private Long id;
    private Long customerId;
    private OrderStatus orderStatus;
}
