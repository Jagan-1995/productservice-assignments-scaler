package com.ecommerceprojectbyrahul.productservice.service;

import com.ecommerceprojectbyrahul.productservice.dtos.GetProductByDto;
import com.ecommerceprojectbyrahul.productservice.exceptions.NotFoundException;
import com.ecommerceprojectbyrahul.productservice.models.Product;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class Productservice {


    public GetProductByDto getProductById(Long id) throws NotFoundException{

        RestTemplate restTemplate = new RestTemplate();

        String url =  "https://fakestoreapi.com/products/" + id;
        Product product = restTemplate.getForObject(url, Product.class);

        System.out.println(product);

        if(product == null){
            throw new NotFoundException();
        }

//    call DB
//    call the fake store api.com
//    https://fakestoreapi.com/products/10
        return convertToDto (product);
    }


    private static GetProductByDto convertToDto(Product product) {
        GetProductByDto obj = new GetProductByDto();
        obj.setName(product.getTitle());
        obj.setPrice(product.getPrice());
        obj.setImageurl(product.getImage());
        return obj;
    }


    public List<GetProductByDto> getAllProducts(){

//        make a call to 3rd party API
//        Deserialize into java object ---> Array of Products
//        convert the Array into array/list of dto objects.

        RestTemplate restTemplate = new RestTemplate();

        String url =  "https://fakestoreapi.com/products/";
        Product[] products = restTemplate.getForObject(url, Product[].class);


        List <GetProductByDto> returnedProducts = new ArrayList<>();

        for(Product product : products){
            returnedProducts.add(convertToDto(product));
        }

        return returnedProducts;

    }

}
