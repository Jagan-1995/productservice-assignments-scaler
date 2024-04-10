package com.ecommerceprojectbyrahul.productservice.service;

import com.ecommerceprojectbyrahul.productservice.dtos.GetProductByDto;
import com.ecommerceprojectbyrahul.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Productservice {


    public GetProductByDto getProductById(Long id){

        RestTemplate restTemplate = new RestTemplate();

        String url =  "https://fakestoreapi.com/products/" + id;
        Product product = restTemplate.getForObject(url, Product.class);

        System.out.println(product);

//    call DB
//    call the fake store api.com
//    https://fakestoreapi.com/products/10
        GetProductByDto obj = new GetProductByDto();
        obj.setName(product.getTitle());
        obj.setPrice(product.getPrice());
        obj.setImageurl(product.getImage());
        return obj;
    }


}
