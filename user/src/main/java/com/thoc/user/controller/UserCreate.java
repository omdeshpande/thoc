package com.thoc.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import com.thoc.user.model.data.User;
import com.thoc.user.contract.UserService;
import com.thoc.user.contract.api.ApiResponse;

@RestController
public class UserCreate 
{

    /**
     * User Service.
     */
    @Autowired
    private UserService userService;

    /**
     * Password encryptor service.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    /**
	 * API Response.
	 */
	@Autowired
	private ApiResponse apiResponse;

    /**
	 * Handles user registration.
	 * 
	 * @param model ViewModel to set dynamic variables in the template of instance {@link Model}
	 * @return string
	 */
	@PostMapping("/api/v1/user/create")
	@CrossOrigin(origins = "http://localhost:8081")
	public ApiResponse execute(User user)
	{
        try {
            this.userService.loadUserByUsername(user.getUsername());
            this.apiResponse.setStatus("500");
            this.apiResponse.setDescription("User already exists.");
            this.apiResponse.setContent(null);
        } catch (UsernameNotFoundException exception) {
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            this.userService.save(user);
            this.apiResponse.setStatus("200");
            this.apiResponse.setDescription("Success");
            this.apiResponse.setContent(null);
        }
        
        return this.apiResponse;
	}
}
