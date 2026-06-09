package org.example.e_commerce.dao;

import org.example.e_commerce.model.Order;
import org.example.e_commerce.model.Order_item;

import java.util.List;

public interface OrderDao {

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<Order_item> orderItemList);

    Order getOrderById(Integer orderId);

    List<Order_item> getOrderItemByOrderId(Integer orderId);
}
