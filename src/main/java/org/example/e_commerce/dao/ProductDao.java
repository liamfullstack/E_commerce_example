package org.example.e_commerce.dao;

import org.example.e_commerce.constant.ProductCategory;
import org.example.e_commerce.dto.ProductQueryParams;
import org.example.e_commerce.dto.ProductRequest;
import org.example.e_commerce.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

    Integer countProduct(ProductQueryParams productQueryParamso);
}
