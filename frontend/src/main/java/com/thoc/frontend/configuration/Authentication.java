package com.thoc.frontend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.thoc.frontend.model.UserService;

@Configuration
@EnableWebSecurity
public class Authentication
{
	
	/**
     * Custom implementation of UserServiceDetails that authenticates via the User Service.
     */
    @Autowired
    private UserService userService;

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
                .anyRequest().permitAll()
        		.and()
        	.userDetailsService(this.userService)
        	.csrf().disable();
        return http.build();

    }
}
