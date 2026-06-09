package org.example.e_commerce.service;

import org.example.e_commerce.dto.CreateOrderRequest;
import org.example.e_commerce.model.Order;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
