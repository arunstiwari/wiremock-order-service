package com.tekmentor.orderservice.controller;

import com.tekmentor.orderservice.model.Order;
import com.tekmentor.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<Order> fetchAllOrders(){
        return orderService.fetchAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable("id") String id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/orders/customers/{customerId}")
    public Order getOrdersOfGivenCustomer(@PathVariable("customerId") String customerId){
        return orderService.getOrdersForGivenCustomer(customerId);
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createNewOrder(@RequestBody Order order){
        return orderService.addNewOrder(order);
    }

}
