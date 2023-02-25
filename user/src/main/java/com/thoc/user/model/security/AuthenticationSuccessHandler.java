package com.thoc.user.model.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoc.user.contract.UserTokenService;
import com.thoc.user.contract.api.ApiResponse;
import com.thoc.user.contract.data.UserToken;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler
{
	
	/**
	 * User token.
	 */
	@Autowired
	private UserToken userToken;
	
	/**
	 * Service to handle user tokens.
	 */
	@Autowired
	private UserTokenService userTokenService;
	
	/**
	 * API Response.
	 */
	@Autowired
	private ApiResponse apiResponse;
	
	/**
	 * Object mapper.
	 */
	@Autowired
	private ObjectMapper objectMapper;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onAuthenticationSuccess(
		HttpServletRequest request, 
		HttpServletResponse response,
		Authentication authentication
	) throws IOException, ServletException {
		
		/** 
		 * Save a new token only if the Authorization header doesn't exit, 
		 * meaning if the authentication has been processed via username / password.
		 */
		if (request.getHeader("Authorization") == null) { 
			// Generate a token to add to the Authorization header.
			String token = this.userTokenService.generateToken();
			response.addHeader("Authorization", token);
			response.addCookie(new Cookie("Authorization", token));
			
			// Save the token, this will be required to validate future requests from clients.
			this.userToken.setId(token);
			this.userToken.setUsername(authentication.getName());
			this.userTokenService.saveToken(this.userToken);
		}
		
		this.setResponse(response);
	}
	
	/**
	 * Set the response for a successful authentication.
	 * 
	 * @param response Response object of instance {@link HttpServletResponse}
	 * @throws JsonProcessingException
	 * @throws IOException
	 * @return void
	 */
	public void setResponse(HttpServletResponse response) throws JsonProcessingException, IOException
	{
		this.apiResponse.setStatus("200");
		this.apiResponse.setDescription("Success");
		this.apiResponse.setContent(null);
		
		response.addHeader("Content-Type", "application/json");
		response.getWriter().append(objectMapper.writeValueAsString(this.apiResponse));
	}
	
}
