package com.ecommerceprojectbyrahul.productservice.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException  extends Exception{

    public NotFoundException(){
        super("product Id was not found");
    }
}
