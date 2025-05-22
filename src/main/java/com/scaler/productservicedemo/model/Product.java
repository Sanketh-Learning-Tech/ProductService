package com.scaler.productservicedemo.model;

import com.scaler.productservicedemo.dto.FakeStoreProductDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String title;
    private Double price;
    private String description;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Category category;
    private String imageUrl;
    private int numOfSales;

    public FakeStoreProductDto fromProduct() {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(this.getId());
        fakeStoreProductDto.setTitle(this.getTitle());
        fakeStoreProductDto.setDescription(this.getDescription());
        fakeStoreProductDto.setPrice(this.getPrice());
        fakeStoreProductDto.setImage(this.getImageUrl());
        fakeStoreProductDto.setCategory(this.getCategory().getName());

        return fakeStoreProductDto;
    }
}
