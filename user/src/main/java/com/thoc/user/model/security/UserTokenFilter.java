package com.thoc.user.model.security;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.CompositeLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.thoc.user.contract.UserService;
import com.thoc.user.contract.UserTokenService;
import com.thoc.user.contract.data.UserToken;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class UserTokenFilter extends OncePerRequestFilter
{
	
	/**
	 * User token service.
	 */
	@Autowired
	private UserTokenService userTokenService;
	
	/**
	 * User service.
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * Logout handler.
	 */
	private LogoutHandler handlers = new CompositeLogoutHandler(new SecurityContextLogoutHandler());
	
	/**
	 * Security context.
	 */
	private SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doFilterInternal(
		HttpServletRequest request, 
		HttpServletResponse response, 
		FilterChain filterChain
	) throws ServletException, IOException {
		
		String authToken = this.getAuthenticationToken(request);
		if (authToken != null) {
			this.validateToken(authToken);
		} else if (response.getHeader("Authorization") == null) {
			this.doLogout(request, response);
		}
		
		filterChain.doFilter(request, response);
	}
	
	/**
	 * Validates the token and authenticates the user if valid.
	 * 
	 * @param authToken Auth token of instance {@link String}.
	 * @return void
	 */
	private void validateToken(String authToken)
	{
		Optional<UserToken> userTokenOpt = this.userTokenService.authenticateToken(authToken);
		if (userTokenOpt.isPresent()) {
			UserToken userToken = userTokenOpt.get();
			UserDetails user = this.userService.loadUserByUsername(userToken.getUsername());
			Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
	}
	
	/**
	 * Logs out the user.
	 * 
	 * @param request Request data of instance {@link HttpServletRequest}
	 * @param response Response data of instance {@link HttpServletResponse}
	 * @return void
	 */
	private void doLogout(HttpServletRequest request, HttpServletResponse response) 
	{
		Authentication auth = this.securityContextHolderStrategy.getContext().getAuthentication();
		this.handlers.logout(request, response, auth);
	}
	
	/**
	 * Parses the token from the request. Either from the cookie, or from the Authorization header.
	 * 
	 * @param request Request data of instance {@link HttpServletRequest}.
	 * @return Auth token of instance {@link String} if it exists, else {@link null}.
	 */
	public String getAuthenticationToken(HttpServletRequest request)
	{
		String authToken = null;
		if (request.getHeader("Authorization") != null) {
			authToken = request.getHeader("Authorization");
		} else {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals("Authorization")) {
					authToken = cookie.getValue();
				}
			}
		}
		
		return authToken;
	}
	
}
