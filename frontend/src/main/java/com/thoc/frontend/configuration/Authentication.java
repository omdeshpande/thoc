package com.thoc.frontend.configuration;

import org.springframework.context.annotation.*; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Authentication
{

    @Bean 
    public PasswordEncoder passwordEncoder()
    { 
        return new BCryptPasswordEncoder();
    }

    /**
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests()
                .anyRequest().permitAll();
        return http.build();

    }
}
