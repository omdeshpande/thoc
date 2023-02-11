package com.thoc.user.controller;

import java.security.Principal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserToken
{
	/**
	 * Handles user registration.
	 * 
	 * @param model ViewModel to set dynamic variables in the template of instance {@link Model}
	 * @return string
	 */
	@GetMapping("/token")
	public String execute(Principal principal)
	{
		principal.getName();
		return null;
        
	}
}
