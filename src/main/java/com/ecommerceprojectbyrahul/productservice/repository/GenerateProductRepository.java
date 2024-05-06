package com.ecommerceprojectbyrahul.productservice.repository;

import com.ecommerceprojectbyrahul.productservice.models.GenericProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenerateProductRepository extends JpaRepository<GenericProduct, Long> {

    Page<GenericProduct> findAll(Pageable pageable);

    Page<GenericProduct> findAllByName(String name, Pageable pageable);
}
