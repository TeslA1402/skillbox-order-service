package org.example.skillboxorderservice.event;

import org.example.skillboxorderservice.dto.Order;

public record OrderEvent(String product, Integer quantity) {
    public OrderEvent(Order order) {
        this(order.product(), order.quantity());
    }
}
