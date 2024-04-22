package com.ecommerceprojectbyrahul.productservice.repository;

import com.ecommerceprojectbyrahul.productservice.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {


    List<Instructor> findByName(String name);


}
