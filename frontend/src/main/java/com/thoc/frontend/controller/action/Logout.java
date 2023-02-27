package com.thoc.frontend.controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.thoc.frontend.contract.UserAuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Logout
{
	/**
	 * User auth service.
	 */
	@Autowired
	private UserAuthService userAuthService;
	
	/**
	 * 
	 * @return {@link String}
	 */
	@GetMapping("/logout")
	public String execute(HttpServletRequest request)
	{
		// Logout from the user service.
		String token = this.getAuthToken(request);
		this.userAuthService.logout(token);
		
		// Remove the authorization cookie.
		
		
		return "redirect:/login";
	}
	
	/**
	 * Get auth token from the request object.
	 * 
	 * @param request Request object of instance {@link HttpServletRequest}.
	 * @return Auth token of instance {@link String}.
	 */
	private String getAuthToken(HttpServletRequest request)
	{
		if (request.getCookies() == null) {
			return null;
		}
		
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("Authorization")) {
				return cookie.getValue();
			}
		}
		
		return null;
	}
}
