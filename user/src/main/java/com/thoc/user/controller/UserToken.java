package com.thoc.user.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoc.user.contract.UserTokenService;
import com.thoc.user.contract.api.ApiResponse;

@RestController("UserTokenController")
public class UserToken
{
	/**
	 * User token service.
	 */
	@Autowired
	private UserTokenService userTokenService;
	
	/**
	 * API Response.
	 */
	@Autowired
	private ApiResponse apiResponse;
	
	/**
	 * Validates user authentication token.
	 * 
	 * @param principal Logged in user details of instance {@link Principal}
	 * @return string
	 */
	@GetMapping("/api/v1/user/token/validate")
	public ApiResponse execute(Principal principal)
	{
		// Initialize API response.
		this.apiResponse.setStatus("401");
		this.apiResponse.setDescription("Unauthorized");
		this.apiResponse.setContent(null);
		
		Optional<com.thoc.user.contract.data.UserToken> userTokenOpt = this.userTokenService.findByUsername(principal.getName());
		if (userTokenOpt.isPresent()) {
			this.apiResponse.setStatus("200");
			this.apiResponse.setDescription("Success");
			this.apiResponse.setContent(userTokenOpt.get());
		}
		
		return this.apiResponse;
	}
}
