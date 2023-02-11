package com.thoc.user.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.thoc.user.model.*;

@Configuration
@EnableWebSecurity
public class Authentication
{
    /**
     * Custom implementation of UserServiceDetails that authenticates via the DB.
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
                .requestMatchers("/register/**", "/login/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login")
                .failureUrl("/login/error")
                .and()
            .userDetailsService(this.userService);
        return http.build();

    }
}
