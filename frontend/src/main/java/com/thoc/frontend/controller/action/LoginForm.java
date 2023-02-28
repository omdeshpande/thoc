package com.thoc.frontend.controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoc.frontend.contract.UserAuthService;
import com.thoc.frontend.contract.data.ApiResponse;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LoginForm
{
	
	/**
	 * User auth service.
	 */
	@Autowired
	private UserAuthService userAuthService;
	
	/**
	 * Get the form Html from the user service.
	 * 
	 * @param request Http request of instance {@link HttpServletRequest}
	 * @return Api response of instance {@link ApiResponse}
	 */
	@GetMapping("/getLoginForm")
	public ApiResponse execute(HttpServletRequest request)
	{
		String token = "";
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals("Authorization")) {
					token = cookie.getValue();
				}
			}
		}
		
		return this.userAuthService.getLoginForm(token);
	}
}
