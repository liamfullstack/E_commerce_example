package org.example.e_commerce.rowmapper;


import org.example.e_commerce.model.Order;
import org.example.e_commerce.model.Order_item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemRowMapper implements RowMapper<Order_item> {
    @Override
    public Order_item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order_item order = new Order_item();
        order.setOrderItemId(rs.getInt("order_item_id"));
        order.setOrderId(rs.getInt("order_id"));
        order.setProductId(rs.getInt("product_id"));
        order.setAmount(rs.getInt("amount"));
        order.setQuantity(rs.getInt("quantity"));
        order.setProductName(rs.getString("product_name"));
        order.setImageUrl(rs.getString("image_url"));

        return order;
    }
}