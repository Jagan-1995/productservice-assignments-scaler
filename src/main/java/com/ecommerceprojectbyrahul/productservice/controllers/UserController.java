package com.ecommerceprojectbyrahul.productservice.controllers;


import com.ecommerceprojectbyrahul.productservice.dtos.CreateUserDto;
import com.ecommerceprojectbyrahul.productservice.models.User;
import com.ecommerceprojectbyrahul.productservice.service.UserService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public User createUser(@RequestBody CreateUserDto createUserDto){

        return userService.createUser(createUserDto.getName(), createUserDto.getEmail());

    }

    @GetMapping("/{name}")
    public User getUserByName(@PathVariable(name = "name") String name){
        return userService.getUserByName(name);
    }



}
