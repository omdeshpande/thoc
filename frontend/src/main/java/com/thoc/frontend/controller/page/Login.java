package com.thoc.frontend.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class Login
{
    /**
	 * Handles the rendering of the login page.
	 * 
	 * @return string 
	 */
	@GetMapping("/login")
	public String execute()
	{
		return "loginpage";
	}
}
