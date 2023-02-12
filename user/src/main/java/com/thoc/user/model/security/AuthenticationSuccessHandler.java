package com.thoc.user.model.security;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.thoc.user.contract.UserTokenService;
import com.thoc.user.contract.data.UserToken;
import jakarta.servlet.ServletException;
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
			
			// Save the token, this will be required to validate future requests from clients.
			this.userToken.setId(token);
			this.userToken.setUsername(authentication.getName());
			this.userTokenService.saveToken(this.userToken);
		}
		
		response.sendRedirect("/");
	}
	
}
