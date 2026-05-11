package com.kartikey.paymentgateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kartikey.paymentgateway.dto.LoginRequest;
import com.kartikey.paymentgateway.dto.RegisterRequest;
import com.kartikey.paymentgateway.service.AuthService;

@RestController
public class AuthController{

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req){
        authService.loginUser(req);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req){
        return ResponseEntity.status(201).body(authService.registerUser(req));
    }

}