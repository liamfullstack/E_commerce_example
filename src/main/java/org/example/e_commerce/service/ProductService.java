package org.example.e_commerce.service;

import org.example.e_commerce.constant.ProductCategory;
import org.example.e_commerce.dto.ProductRequest;
import org.example.e_commerce.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getproducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);



}
