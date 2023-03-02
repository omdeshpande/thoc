package com.thoc.frontend.controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoc.frontend.contract.UserAccountService;
import com.thoc.frontend.contract.data.ApiResponse;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserEditForm
{
	/**
	 * User account service.
	 */
	@Autowired
	private UserAccountService userAccountService;
	
	/**
	 * Get the user edit form Html from the user service.
	 * 
	 * @param request Http request of instance {@link HttpServletRequest}
	 * @return Api response of instance {@link ApiResponse}
	 */
	@GetMapping("/getUserEditForm")
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
		
		return this.userAccountService.getUserEditForm(token);
	}
}
