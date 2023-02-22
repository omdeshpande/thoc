package com.thoc.frontend.controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thoc.frontend.contract.UserAuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginPost
{
	/**
	 * User authentication service.
	 */
	@Autowired
	private UserAuthService userAuthService;
		
	@PostMapping("/login")
	public String execute(
		@RequestParam String username,
		@RequestParam String password,
		HttpServletResponse response
	) {		 
		if (this.userAuthService.login(username, password).isSuccess()) {
			response.addCookie(new Cookie(
				"Authorization", 
				this.userAuthService.getAuthToken().get(0)));			
			return "redirect:/";
		}
		
		return "redirect:/login";
	}
}
