package com.scaler.productservicedemo.service;

import com.scaler.productservicedemo.dto.FakeStoreProductDto;
import com.scaler.productservicedemo.model.Category;
import com.scaler.productservicedemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;

    @Autowired
    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(long id) {
        FakeStoreProductDto fakeStoreProductDto= restTemplate
                .getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);

        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product addProduct(Product product) {

        FakeStoreProductDto fakeStoreProductDto = product.fromProduct();

        return restTemplate
                .postForObject("https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class).toProduct();
    }

    @Override
    public List<Product> getAllProducts() {

       /*List<LinkedHashMap>  response= restTemplate.getForObject("https://fakestoreapi.com/products", List.class);

       List<Product> products = new ArrayList<>();

       for (LinkedHashMap hm : response) {
           Product product = new Product();
           product.setId(Long.parseLong(hm.get("id").toString()));
           product.setTitle((String)hm.get("title"));
           product.setDescription((String)hm.get("description"));
           product.setPrice(Double.parseDouble(hm.get("price").toString()));
           product.setCategory(new Category());
           product.getCategory().setName(hm.get("category").toString());
           products.add(product);
       }*/

        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(fakeStoreProductDto.toProduct());
        }

       return products;

    }

    @Override
    public Product updateProduct(long id, Product product) {
       FakeStoreProductDto fakeStoreProductDto = restTemplate.patchForObject("https://fakestoreapi.com/products/"+id,
                product.fromProduct(), FakeStoreProductDto.class);

       return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product replaceProduct(long id, Product product) {

        RequestCallback requestCallback = restTemplate.httpEntityCallback(product.fromProduct(), FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class,
                restTemplate.getMessageConverters());
        return restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.POST, requestCallback, responseExtractor).toProduct();
    }

    @Override
    public void deleteProduct(long id) {
        restTemplate.delete("https://fakestoreapi.com/products/"+id);
    }
}
