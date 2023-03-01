package com.thoc.user.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

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
    
    /**
     * Success handler to generate and save a user token post successful login.
     */
    @Autowired
    @Qualifier("thoc_auth_success_handler")
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    
    @Autowired
    @Qualifier("thoc_logout_success_handler")
    private LogoutSuccessHandler logoutSuccessHandler;

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
                .requestMatchers("/register/**", "/login/**", "/api/v1/html/login-form/**", "/api/v1/html/registration-form/**", "/api/v1/user/token/validate/**", "/api/v1/user/create/**").permitAll()
                .anyRequest().authenticated() 
                .and()
            .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login")
                .failureUrl("/login/error")
                .successHandler(this.authenticationSuccessHandler)
                .and()
            .logout().logoutSuccessHandler(this.logoutSuccessHandler)
            	.and()
            .userDetailsService(this.userService)
            .csrf().disable();
        	
        return http.build();

    }
}
