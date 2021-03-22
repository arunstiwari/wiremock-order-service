package com.tekmentor.orderservice.service;

import com.tekmentor.orderservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public List<Order> fetchAllOrders() {
        return  orders;
    }

    public Order getOrderById(String id) {
        Order order = orders.stream().filter(ord -> ord.getId().equals(id)).findFirst().get();
        System.out.println("order for id = " + order);
        return order;
    }

    public Order addNewOrder(Order order) {
        String orderId = UUID.randomUUID().toString();
        order.setId(orderId);
        orders.add(order);
        System.out.println("new order = " + order);
        return order;
    }

    public Order getOrdersForGivenCustomer(String customerId) {
        Order order = orders.stream().filter(ord -> ord.getCustomerId().equals(customerId)).findFirst().get();
        System.out.println("order for given customer = " + order);
        return order;
    }
}
