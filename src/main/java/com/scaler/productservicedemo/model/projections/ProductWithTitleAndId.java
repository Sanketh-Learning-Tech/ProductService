package com.scaler.productservicedemo.model.projections;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scaler.productservicedemo.model.Category;
import com.scaler.productservicedemo.model.Product;

public interface ProductWithTitleAndId {

    Long getId();
    String getTitle();
    @JsonIgnore
    Category getCategory();
}
