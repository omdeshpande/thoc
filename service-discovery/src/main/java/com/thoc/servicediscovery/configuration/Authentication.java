package com.thoc.servicediscovery.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain; 

@Configuration
public class Authentication
{
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests()
                .anyRequest().permitAll()
        		.and()
        	.csrf()
        		.disable();
        return http.build();

    }
}
