package org.example.e_commerce.dao.impl;

import org.example.e_commerce.dao.OrderDao;
import org.example.e_commerce.model.Order_item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OderDaoImpl implements OrderDao {
    @Override
    public void createOrderItems(Integer orderId, List<Order_item> orderItemList) {

//        for(Order_item orderItem : orderItemList) {
//            String sql = "INSERT INTO order_item(order_id, product_id, quantity, amount) " +
//                    "VALUES (:orderId, :productId, :quantity, :amount)";
//
//            Map<String, Object> map = new HashMap<>();
//            map.put("orederId", orderId);
//            map.put("productId", orderItem.getProductId());
//            map.put("quantity", orderItem.getQuantity());
//            map.put("amount", orderItem.getAmount());
//
//            namedParameterJdbcTemplate.update(sql, map);
//        }

        String sql = "INSERT INTO order_item(order_id, product_id, quantity, amount) "+
                "VALUES (:orderId, :productId, :quantity, :amount)";

        MapSqlParameterSource[] parameterSource = new MapSqlParameterSource[orderItemList.size()];
            for(int i =0; i< orderItemList.size(); i++){
                Order_item orderItem = orderItemList.get(i);

                parameterSource[i]= new MapSqlParameterSource();
                parameterSource[i].addValue("orderId",orderId);
                parameterSource[i].addValue("productId",orderItem.getProductId());
                parameterSource[i].addValue("quantity",orderItem.getQuantity());
                parameterSource[i].addValue("amount",orderItem.getAmount());
            }
            namedParameterJdbcTemplate.batchUpdate(sql, parameterSource);
    }

    @Override
    public Integer createOrder(Integer userId, Integer totalAmount) {
        String sql = "INSERT INTO `order`(user_id, total_amount, created_date, last_modified_date) " +
                "VALUES (:userId, :totalAmount, :createdDate, :lastModifiedDate)";
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("totalAmount",totalAmount);

        Date now = new Date();
        map.put("createdDate",now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int orderId = keyHolder.getKey().intValue();

        return orderId;
    }

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
}
