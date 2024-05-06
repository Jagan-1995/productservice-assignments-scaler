package com.ecommerceprojectbyrahul.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Batch {

    @Id
    private Long id;

    private String name;

    private Integer strength;

    @ManyToOne
    @JoinColumn(name = "instructor id")
    private Instructor instructor;
}
