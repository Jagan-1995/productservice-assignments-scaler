package com.ecommerceprojectbyrahul.productservice.service;


import com.ecommerceprojectbyrahul.productservice.models.GenericProduct;
import com.ecommerceprojectbyrahul.productservice.repository.GenerateProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.sun.beans.introspect.PropertyInfo.Name.bound;

@Service
public class GenerateProductService {

    private final GenerateProductRepository generateProductRepository;

    public GenerateProductService(GenerateProductRepository generateProductRepository) {
        this.generateProductRepository = generateProductRepository;
    }

    private static final String[] PRODUCT_NAMES = {
            "TV", "Headphones", "Smartphone", "Laptop", "Tablet",
            "Camera", "Speaker", "Drone", "Gaming Console", "Smartwatch",
            "Fitness Tracker", "External Hard Drive", "Monitor", "Router",
            "Printer", "Keyboard", "Mouse", "Earbuds", "Projector", "Desk"
    };

    public boolean generateProductData(){
        List<GenericProduct> productList = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < 20; i++){
            String productName = PRODUCT_NAMES[i];
            int price = random.nextInt(10000);

            GenericProduct genericProduct = new GenericProduct(productName,price);

            productList.add(genericProduct);

        }
        generateProductRepository.saveAll(productList);

        return true;
    }

    public List<GenericProduct> searchProducts(String query) {
        return generateProductRepository.findAll();
    }

    public Page<GenericProduct> searchProductsByPage(String query, int pageNumber, int pageSize, String sorting) {

        return switch (sorting) {
            case "id-asc" -> generateProductRepository.findAll(
                    PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "id")
            );
            case "name-desc" -> generateProductRepository.findAll(
                    PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "name")
            );
            default -> generateProductRepository.findAll(
                    PageRequest.of(pageNumber, pageSize)
            );
        };
    }
}
