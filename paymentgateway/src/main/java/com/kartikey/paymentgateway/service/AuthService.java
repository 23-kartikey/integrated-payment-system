package com.kartikey.paymentgateway.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kartikey.paymentgateway.dto.LoginRequest;
import com.kartikey.paymentgateway.dto.RegisterRequest;
import com.kartikey.paymentgateway.entity.User;
import com.kartikey.paymentgateway.repository.UserRepository;

@Service
public class AuthService {
    
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo=userRepo;
        this.passwordEncoder=passwordEncoder;
    }

    public void loginUser(LoginRequest req){
        
    }

    public User registerUser(RegisterRequest req){
        return userRepo.save(toUser(req));
    }

    private User toUser(RegisterRequest req){
        return User.builder()
                .name(req.name())
                .email(req.email())
                .password(passwordEncoder.encode(req.password()))
                .build();
    }

}
