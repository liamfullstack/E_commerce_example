package org.example.e_commerce.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.apache.coyote.Response;
import org.example.e_commerce.constant.ProductCategory;
import org.example.e_commerce.dto.ProductQueryParams;
import org.example.e_commerce.dto.ProductRequest;
import org.example.e_commerce.model.Product;
import org.example.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
            //查詢條件Filtering
         @RequestParam(required = false)   ProductCategory category,
         @RequestParam(required = false)  String search,
            //排序Sorting
         @RequestParam(defaultValue = "created_date") String orderby,
         @RequestParam(defaultValue = "desc") String sort,
            //分頁Pagination
          @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
          @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ){
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderby(orderby);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);
       List<Product> productList =  productService.getproducts(productQueryParams);
        return ResponseEntity.status(HttpStatus.OK).body(productList);

    }

@GetMapping("/products/{productId}")
public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
    Product product = productService.getProductById(productId);

    if(product!= null){
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid  ProductRequest productRequest){
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest){

        //檢查Product是否存在
        Product product = productService.getProductById(productId);

        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //修改商品的數據
        productService.updateProduct(productId, productRequest);

        Product updatedProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
