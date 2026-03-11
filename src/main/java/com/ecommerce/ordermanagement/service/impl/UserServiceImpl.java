package com.ecommerce.ordermanagement.service.impl;

import com.ecommerce.ordermanagement.entity.User;
import com.ecommerce.ordermanagement.repository.UserRepository;
import com.ecommerce.ordermanagement.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
   public final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }
}

