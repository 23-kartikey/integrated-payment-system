package com.kartikey.paymentgateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http
            .csrf(csrf->csrf.disable())

            .authorizeHttpRequests(auth->auth
                .requestMatchers("/auth/**")
                .permitAll()

            .requestMatchers(
                "/admin/**"
            ).hasRole("ADMIN")
            .anyRequest().authenticated()
        
            )
            .formLogin(login->login
                .loginPage("/login")
                .permitAll()
            )

        ;

        return http.build();
    }
    
}
