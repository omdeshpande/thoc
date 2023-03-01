package com.thoc.frontend.controller.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thoc.frontend.contract.UserAccountService;

@Controller
public class RegistrationPost
{
	
	/**
	 * User account service.
	 */
	@Autowired
	private UserAccountService userAccountService;
	
	/**
	 * Handles submits from the registration form.
	 * 
	 * @param params Form fields of instance {@link Map<String, String>}.
	 * @return String
	 */
	@PostMapping("/register")
	public String execute(@RequestParam Map<String, String> params)
	{
		if (this.userAccountService.register(params).isSuccess()) {			
			return "redirect:/login";
		}

		return "redirect:/register";
	}
}
