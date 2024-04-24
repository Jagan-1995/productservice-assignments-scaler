package com.ecommerceprojectbyrahul.productservice.repository;

import com.ecommerceprojectbyrahul.productservice.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InstructorRepository extends JpaRepository<Instructor, UUID> {


    List<Instructor> findByName(String name);




}
