package com.ecommerce.ordermanagement.controller;

import com.ecommerce.ordermanagement.dto.LoginRequest;
import com.ecommerce.ordermanagement.dto.LoginResponse;
import com.ecommerce.ordermanagement.dto.UserRequest;
import com.ecommerce.ordermanagement.dto.UserResponse;
import com.ecommerce.ordermanagement.entity.User;
import com.ecommerce.ordermanagement.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    public final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRequest userReq){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.registerUser(userReq));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginRequest userReq){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.login(userReq));
    }
}
