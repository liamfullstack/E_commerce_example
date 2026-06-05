package org.example.e_commerce.dto;

import org.example.e_commerce.constant.ProductCategory;

public class ProductQueryParams {
    private ProductCategory category;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    private  String search;
}
