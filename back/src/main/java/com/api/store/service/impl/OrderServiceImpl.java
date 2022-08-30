package com.api.store.service.impl;

import com.api.store.exception.ResourceNotFoundException;
import com.api.store.model.Order;
import com.api.store.repository.OrderRepository;
import com.api.store.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(long id) {
        Optional<Order> order = orderRepository.findById(id);

        return orderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Order", "Id", id));
    }
}
