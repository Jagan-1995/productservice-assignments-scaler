package com.ecommerceprojectbyrahul.productservice.dtos;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductByDto {

    private String name;
    private Double price;
    private String imageurl;
}
