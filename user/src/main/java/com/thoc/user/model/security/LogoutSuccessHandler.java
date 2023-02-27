package com.thoc.user.model.security;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoc.user.contract.UserTokenService;
import com.thoc.user.contract.api.ApiResponse;
import com.thoc.user.contract.data.UserToken;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("thoc_logout_success_handler")
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler
{
	
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
	public void onLogoutSuccess(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Authentication authentication
	) throws IOException, ServletException {
		
		// Delete authorization token.
		String token = request.getHeader("Authorization");
		Optional<UserToken> userTokenOpt = this.userTokenService.authenticateToken(token);
		if (userTokenOpt.isPresent()) {
			this.userTokenService.delete(userTokenOpt.get());
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
