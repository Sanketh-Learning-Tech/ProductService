package com.scaler.productservicedemo.service;

import com.scaler.productservicedemo.exceptions.ProductNotFoundException;
import com.scaler.productservicedemo.model.Category;
import com.scaler.productservicedemo.model.Product;
import com.scaler.productservicedemo.repositories.CategoryRepository;
import com.scaler.productservicedemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Primary : this is also used to select this service as primary, but would fail if multiple services
 // are made primary, so qualifier is fool-proof.
@Service("selfProductService") //helps in using this name as qualifier to only select this implementation
public class SelfProductService implements ProductService{

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    @Autowired
    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {


        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));

    }

     @Override
     public Product addProduct(Product product) {
         return null;
     }

     @Override
    public Product addNewProduct(Product product) {

         return getProduct(product);
     }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(long id, Product product) throws ProductNotFoundException{

        Product savedProduct = productRepository.findById(id)
                .orElseThrow(() ->  new ProductNotFoundException("Product not found with id " + id));

            if(product.getTitle()!=null){
                savedProduct.setTitle(product.getTitle());
            }
            if(product.getDescription()!=null){
                savedProduct.setDescription(product.getDescription());
            }
            if(product.getPrice()!=null){
                savedProduct.setPrice(product.getPrice());
            }if(product.getCategory()!=null){
                Optional<Category> savedCategory = categoryRepository.findByName(product.getCategory().getName());

                if(savedCategory.isPresent()) {
                    savedProduct.setCategory(savedCategory.get());
                }
                else {
                    categoryRepository.save(product.getCategory());
                    savedProduct.setCategory(product.getCategory());
                }
            }if(product.getImageUrl()!=null){
                savedProduct.setImageUrl(product.getImageUrl());
            }

        return productRepository.save(savedProduct);
    }

    @Override
    public Product replaceProduct(long id, Product product) {
        product.setId(id);

        return getProduct(product);
    }

    @Override
    public void deleteProduct(long id) {

    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    private Product getProduct(Product product) {
        Optional<Category> category = categoryRepository.findByName(product.getCategory().getName());
        if(category.isPresent()) {
            product.setCategory(category.get());
        }else{
            Category savedCategory = categoryRepository.save(product.getCategory());
            product.setCategory(savedCategory);
        }

        return productRepository.save(product);
    }

}
