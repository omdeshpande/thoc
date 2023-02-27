package com.thoc.frontend.controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoc.frontend.contract.HeaderService;
import com.thoc.frontend.contract.data.ApiResponse;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MenuItems
{
	
	/**
	 * Header service.
	 */
	@Autowired
	private HeaderService headerService;
	
	@GetMapping("/getMenuItems")
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
		
		return this.headerService.getMenuItems(token);
	}
}
