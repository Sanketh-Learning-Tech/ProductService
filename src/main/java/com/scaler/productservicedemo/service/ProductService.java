package com.scaler.productservicedemo.service;

import com.scaler.productservicedemo.exceptions.ProductNotFoundException;
import com.scaler.productservicedemo.model.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(long id) throws ProductNotFoundException;
    Product addProduct(Product product);

    List<Product> getAllProducts();

    Product updateProduct(long id, Product product);
    Product replaceProduct(long id, Product product);

    void deleteProduct(long id);
}
