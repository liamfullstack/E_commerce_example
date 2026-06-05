package org.example.e_commerce.service.impl;

import org.example.e_commerce.dao.ProductDao;
import org.example.e_commerce.dto.ProductRequest;
import org.example.e_commerce.model.Product;
import org.example.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
         productDao.updateProduct(productId, productRequest);
    }
}
