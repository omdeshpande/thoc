package com.thoc.user.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.thoc.user.model.*;
import com.thoc.user.model.security.AuthenticationSuccessHandler;
import com.thoc.user.model.security.LogoutRequestMatcher;

@Configuration
@EnableWebSecurity
public class Authentication
{
    /**
     * Custom implementation of UserServiceDetails that authenticates via the DB.
     */
    @Autowired
    private UserService userService;
    
    /**
     * Success handler to generate and save a user token post successful login.
     */
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    
    /**
     * Custom logout request matcher.
     */
    @Autowired
    private LogoutRequestMatcher logoutRequestMatcher;

    /**
     * Sets the password encoding algorithm to be used by the application.
     * 
     * @return Instance of type {@link PasswordEncoder}
     */
    @Bean 
    public PasswordEncoder passwordEncoder()
    { 
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the application security behavior.
     * 
     * @param http HTTP configuration object of instance {@link HttpSecurity}
     * @return Instance of type {@link SecurityFilterChain}
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
                .successHandler(this.authenticationSuccessHandler)
                .and()
            .userDetailsService(this.userService)
            .logout()
            	.logoutRequestMatcher(this.logoutRequestMatcher);
        return http.build();

    }
}
