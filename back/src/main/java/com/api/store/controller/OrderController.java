package com.api.store.controller;

import com.api.store.model.Item;
import com.api.store.model.Order;
import com.api.store.service.OrderService;
import com.api.store.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;
    private ProductService productService;

    public OrderController(OrderService orderService, ProductService productService) {
        super();
        this.orderService = orderService;
        this.productService = productService;
    }

    // build get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // build get customer by id
    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long orderId) {
        return new ResponseEntity<Order>(orderService.getOrderById(orderId), HttpStatus.OK);
    }

    // build create order
    @PostMapping()
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {

        // calculating price x quantity
        List<Item> items = order.getItems();
        items.forEach(item ->
                item.setPrice(productService.getProductBySKU(item.getSku()).getPrice() * item.getQuantity()));

        return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED);
    }
}
