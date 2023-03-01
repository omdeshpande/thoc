package com.thoc.frontend.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Registration
{
	
	/**
	 * Registration page.
	 * 
	 * @return String
	 */
	@GetMapping("/register")
	public String execute()
	{
		return "registrationpage";
	}
}
