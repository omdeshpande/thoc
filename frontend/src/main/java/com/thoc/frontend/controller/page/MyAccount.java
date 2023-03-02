package com.thoc.frontend.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyAccount
{
	/**
	 * My account page.
	 * 
	 * @return String
	 */
	@GetMapping("/my-account")
	public String execute()
	{
		return "myaccount";
	}
}
