package org.example.e_commerce.service.impl;

import org.example.e_commerce.dao.OrderDao;
import org.example.e_commerce.dao.ProductDao;
import org.example.e_commerce.dto.BuyItem;
import org.example.e_commerce.dto.CreateOrderRequest;
import org.example.e_commerce.model.Order_item;
import org.example.e_commerce.model.Product;
import org.example.e_commerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<Order_item> orderItemList = new ArrayList<>();;
        for(BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());

            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            //轉換BuyItem to OrderItem
            Order_item orderItem = new Order_item();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;

    }


}
