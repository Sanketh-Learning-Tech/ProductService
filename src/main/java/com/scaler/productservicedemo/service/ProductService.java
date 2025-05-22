package com.scaler.productservicedemo.service;

import com.scaler.productservicedemo.exceptions.ProductNotFoundException;
import com.scaler.productservicedemo.model.Product;
import com.scaler.productservicedemo.model.projections.ProductWithTitleAndId;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(long id) throws ProductNotFoundException;
    Product addProduct(Product product);

    List<Product> getAllProducts();

    Product updateProduct(long id, Product product) throws ProductNotFoundException;
    Product replaceProduct(long id, Product product);

    void deleteProduct(long id);

    Product addNewProduct(Product product);

    Product getProductByName(String name);

    List<ProductWithTitleAndId> getProductNameAndId();

}
