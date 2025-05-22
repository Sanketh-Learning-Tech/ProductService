package com.scaler.productservicedemo.repositories;

import com.scaler.productservicedemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long id);

    Product save(Product product);

    //@Query(value = "select p from Product p where p.title= :name") : JPQL or HQL
    @Query(value = "select * from product where title= :name", nativeQuery = true) // Native query
    Product findByName(String name);
}
