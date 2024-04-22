package com.ecommerceprojectbyrahul.productservice.controllers;


import com.ecommerceprojectbyrahul.productservice.dtos.CreateUserDto;
import com.ecommerceprojectbyrahul.productservice.models.Instructor;
import com.ecommerceprojectbyrahul.productservice.models.User;
import com.ecommerceprojectbyrahul.productservice.service.UserService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/instructor")
    public Instructor createInstructor(@RequestBody CreateUserDto createUserDto){

        return userService.createInstructor(createUserDto.getName(), createUserDto.getEmail());

    }

    @GetMapping("/{name}")
    public List<User> getUserByName(@PathVariable(name = "name") String name){
        return userService.getUserByName(name);
    }

    @GetMapping("/instructor/{name}")
    public List<Instructor> getInstructorByName(@PathVariable(name = "name") String name){
        return userService.getInstructorByName(name);
    }



}
