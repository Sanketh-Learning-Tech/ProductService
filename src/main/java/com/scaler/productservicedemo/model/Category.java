package com.scaler.productservicedemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {

    @OneToMany(mappedBy = "category")
    List<Product> products;
    private String name;
}
