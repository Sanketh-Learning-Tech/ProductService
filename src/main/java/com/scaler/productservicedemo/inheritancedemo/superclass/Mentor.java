package com.scaler.productservicedemo.inheritancedemo.superclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_mentor")
public class Mentor extends User{
    private String avgRating;
}
