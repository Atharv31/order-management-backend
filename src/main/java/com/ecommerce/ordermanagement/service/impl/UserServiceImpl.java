package com.ecommerce.ordermanagement.service.impl;

import com.ecommerce.ordermanagement.dto.LoginRequest;
import com.ecommerce.ordermanagement.dto.LoginResponse;
import com.ecommerce.ordermanagement.dto.UserRequest;
import com.ecommerce.ordermanagement.dto.UserResponse;
import com.ecommerce.ordermanagement.entity.User;
import com.ecommerce.ordermanagement.exception.EmailAlreadyExistsException;
import com.ecommerce.ordermanagement.exception.InvalidCredentialException;
import com.ecommerce.ordermanagement.repository.UserRepository;
import com.ecommerce.ordermanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
   public final UserRepository userRepository;
   public final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse registerUser(UserRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new EmailAlreadyExistsException("Email already exists");
        }
        User user = new User(
                request.getName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword())
        );
        User savedUser = userRepository.save(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getCreatedAt()
        );
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new InvalidCredentialException("Invalid Credential"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialException("Invalid Credential");
        }

        return new LoginResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}

