package com.api.store.controller;

import com.api.store.model.Order;
import com.api.store.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        super();
        this.orderService = orderService;
    }

    // build get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // build create order
    @PostMapping()
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED);
    }
}
