package com.ecommerce.ordermanagement.service;

import com.ecommerce.ordermanagement.dto.LoginRequest;
import com.ecommerce.ordermanagement.dto.LoginResponse;
import com.ecommerce.ordermanagement.dto.UserRequest;
import com.ecommerce.ordermanagement.dto.UserResponse;
import com.ecommerce.ordermanagement.entity.User;
import com.ecommerce.ordermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserResponse registerUser(UserRequest request);
    public LoginResponse login(LoginRequest request);
}
