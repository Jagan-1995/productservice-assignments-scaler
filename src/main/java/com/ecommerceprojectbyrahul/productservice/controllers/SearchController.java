package com.ecommerceprojectbyrahul.productservice.controllers;

import com.ecommerceprojectbyrahul.productservice.models.GenericProduct;
import com.ecommerceprojectbyrahul.productservice.models.Product;
//import org.hibernate.query.Page;
import com.ecommerceprojectbyrahul.productservice.service.GenerateProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final GenerateProductService generateProductService;

    public SearchController(GenerateProductService generateProductService) {
        this.generateProductService = generateProductService;
    }

    @GetMapping("/generate")
    public ResponseEntity genarateData(){

        return ResponseEntity.ok(generateProductService.generateProductData());

    }

    @GetMapping("/all")
    public ResponseEntity<List<GenericProduct>> searchProducts(
            @RequestParam(value = "q", required = false) String query){
        return ResponseEntity.ok(generateProductService.searchProducts(query));
    }

    @GetMapping("")
    public ResponseEntity<Page<GenericProduct>> searchProductsByPage(
            @RequestParam(value = "q", required = false) String query,
            @RequestParam(value = "pageNo") int pageNumber,
            @RequestParam(value = "pageSize",required = false, defaultValue = "20") int pageSize,
            @RequestParam(value = "s",required = false,defaultValue = "id-asc") String sorting ){
        return ResponseEntity.ok(
                generateProductService.searchProductsByPage(query,pageNumber,pageSize,sorting));
    }


}
