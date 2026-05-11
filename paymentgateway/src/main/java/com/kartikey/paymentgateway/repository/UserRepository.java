package com.kartikey.paymentgateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kartikey.paymentgateway.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
