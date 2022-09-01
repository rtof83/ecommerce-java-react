package com.api.store.controller;

import com.api.store.model.Item;
import com.api.store.model.Order;
import com.api.store.model.Product;
import com.api.store.service.OrderService;
import com.api.store.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

        List<Item> items = order.getItems();
        order.setTotal(0F);

        // check for insufficient product
        for (int i = 0; i < items.size(); i++) {
            Product updateProdQty = productService.getProductBySKU(items.get(i).getSku());
            if (updateProdQty.getQuantity() < items.get(i).getQuantity()) {
                return new ResponseEntity("insufficient amount of product '" +
                        updateProdQty.getName() + "'", HttpStatus.NOT_FOUND);
            }
        }

        // calculating price x quantity
        // updating product quantity
        for (int i = 0; i < items.size(); i++) {
            Product updateProdQty = productService.getProductBySKU(items.get(i).getSku());

            // update unity price and total price
            items.get(i).setPrice(updateProdQty.getPrice());
            items.get(i).setTotal(updateProdQty.getPrice() * items.get(i).getQuantity());

            // update total order
            order.setTotal(order.getTotal() + items.get(i).getTotal());

            // created at
            order.setDate(new Date());

            // update product quantity
            updateProdQty.setQuantity(updateProdQty.getQuantity() - items.get(i).getQuantity());
            productService.updateProduct(updateProdQty, items.get(i).getSku());
        }

        return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<String>("Order deleted successfully", HttpStatus.OK);
    }
}
