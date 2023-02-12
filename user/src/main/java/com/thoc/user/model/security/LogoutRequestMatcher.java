package com.thoc.user.model.security;

import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class LogoutRequestMatcher implements RequestMatcher
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(HttpServletRequest request)
	{
		if (this.hasAuthorizationHeader(request) == false
			&& this.hasUsernameAndPassword(request) == false
		) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if the request contains the 'Authorization' header.
	 * 
	 * @param request Request object of instance {@link HttpServletRequest}
	 * @return boolean
	 */
	private boolean hasAuthorizationHeader(HttpServletRequest request)
	{
		if (request.getHeader("Authorization") != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if the request contains the username & password parameters.
	 * 
	 * @param request Request object of instance {@link HttpServletRequest}
	 * @return boolean
	 */
	private boolean hasUsernameAndPassword(HttpServletRequest request)
	{
		if (request.getParameter("password") == null
			|| request.getParameter("username") == null
		) {
			return false;
		}
		return true;
	}
	
}
