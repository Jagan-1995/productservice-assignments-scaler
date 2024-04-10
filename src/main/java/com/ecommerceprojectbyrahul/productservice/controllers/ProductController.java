package com.ecommerceprojectbyrahul.productservice.controllers;

import com.ecommerceprojectbyrahul.productservice.dtos.GetProductByDto;
import com.ecommerceprojectbyrahul.productservice.models.Product;
import com.ecommerceprojectbyrahul.productservice.service.Productservice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {



    private Productservice productservice;

    public ProductController(Productservice productservice) {
        this.productservice = productservice;
    }

    @GetMapping("/{id}")
    public @ResponseBody GetProductByDto getProductById(
            @PathVariable("id") Long id){
        return productservice.getProductById(id);

    }

//    @RequestBody Product product  ---> Converts the received json into product java object
    @PostMapping("")
    public String createProduct(@RequestBody Product product){
        System.out.println(product.getCategory());
        System.out.println(product.getTitle());
        System.out.println(product.getPrice());
            return "Product created";
    }


}
