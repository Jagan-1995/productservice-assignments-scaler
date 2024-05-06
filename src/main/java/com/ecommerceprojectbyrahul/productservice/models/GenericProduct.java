package com.ecommerceprojectbyrahul.productservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class GenericProduct {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;

    public GenericProduct(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
