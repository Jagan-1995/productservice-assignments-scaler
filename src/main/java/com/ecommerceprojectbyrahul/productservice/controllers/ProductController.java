package com.ecommerceprojectbyrahul.productservice.controllers;

import com.ecommerceprojectbyrahul.productservice.models.Product;
import com.ecommerceprojectbyrahul.productservice.service.Productservice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

//    https://fakestoreapi.com/products/10



    @GetMapping("/{id}/{temp}")
    public String getProductById(
            @PathVariable("id") Long id, @PathVariable("temp") String x){
        return "Here's your product" + id + x;

    }

//    @RequestBody Product product  ---> Converts the received json into product java object
    @PostMapping("")
    public String createProduct(@RequestBody Product product){
        System.out.println(product.getCategory());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
            return "Product created";
    }


}
