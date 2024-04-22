package com.ecommerceprojectbyrahul.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// telling hibernate to create a table for you

public class User {
    @Id
    @GeneratedValue
    private UUID id;
//    8aef0a0a-b06e-48d3-9532-cffb037db746
    private String name;
    @Column(name = "email_address", unique = true)
    private String email;
}
