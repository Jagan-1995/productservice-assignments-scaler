package com.ecommerceprojectbyrahul.productservice.controllers;

import com.ecommerceprojectbyrahul.productservice.dtos.GetProductByDto;
import com.ecommerceprojectbyrahul.productservice.models.Product;
import com.ecommerceprojectbyrahul.productservice.service.Productservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {



    private Productservice productservice;

    public ProductController(Productservice productservice) {
        this.productservice = productservice;
    }

    @GetMapping("/{id}")
    public @ResponseBody GetProductByDto getProductById(
            @PathVariable("id") Long id) throws Exception {
        return productservice.getProductById(id);

    }

    @GetMapping("")
    public @ResponseBody List<GetProductByDto> getAllProducts(){
        return productservice.getAllProducts();
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
