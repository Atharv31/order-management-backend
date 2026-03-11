package com.ecommerce.ordermanagement.service;

import com.ecommerce.ordermanagement.entity.User;
import com.ecommerce.ordermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User registerUser(User user);
}
