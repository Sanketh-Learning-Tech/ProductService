package com.scaler.productservicedemo.dto;

import com.scaler.productservicedemo.model.Category;
import com.scaler.productservicedemo.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setId(this.getId());
        product.setTitle(this.getTitle());
        product.setDescription(this.getDescription());
        product.setPrice(this.getPrice());
        product.setImageUrl(this.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(this.getCategory());

        return product;

    }
}
