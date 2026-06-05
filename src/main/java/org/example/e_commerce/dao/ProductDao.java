package org.example.e_commerce.dao;

import org.example.e_commerce.dto.ProductRequest;
import org.example.e_commerce.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
