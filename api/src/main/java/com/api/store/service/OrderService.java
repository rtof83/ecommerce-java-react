package com.api.store.service;

import com.api.store.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    Order getOrderById(long id);
    List<Order> getAllOrders();
    void deleteOrder(long id);
}
