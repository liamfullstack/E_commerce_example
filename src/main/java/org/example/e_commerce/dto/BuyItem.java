package org.example.e_commerce.dto;

import jakarta.validation.constraints.NotNull;

public class BuyItem {
    @NotNull
    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    @NotNull
    private Integer quantity;
}
