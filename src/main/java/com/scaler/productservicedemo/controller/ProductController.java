package com.scaler.productservicedemo.controller;

import com.scaler.productservicedemo.exceptions.ProductNotFoundException;
import com.scaler.productservicedemo.model.Product;
import com.scaler.productservicedemo.model.projections.ProductWithTitleAndId;
import com.scaler.productservicedemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    @Autowired
    ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") long id) throws ProductNotFoundException {

        return new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductWithTitleAndId>> getAllProducts(){
        return new ResponseEntity<>(productService.getProductNameAndId(), HttpStatus.OK);
    }

   /* @PostMapping
        public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") long id,
                                                  @RequestBody Product product){
        return new ResponseEntity<>(productService.replaceProduct(id, product), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addNewProduct(product), HttpStatus.CREATED);
    }

}
