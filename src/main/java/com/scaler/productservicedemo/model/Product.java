package com.scaler.productservicedemo.model;

import com.scaler.productservicedemo.dto.FakeStoreProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product {
    @Id
    private long id;
    private String title;
    private double price;
    private String description;
    @ManyToOne
    private Category category;
    private String imageUrl;

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
