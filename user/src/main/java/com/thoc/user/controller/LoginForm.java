package com.thoc.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.thoc.user.contract.data.User;

@Controller
@CrossOrigin(origins = "http://localhost:8081")
public class LoginForm
{

	/**
	 * Credentials posted from the login form.
	 */
	@Autowired
    private User user;

	/**
	 * Handles the rendering of the login form.
	 * 
	 * @param model ViewModel to set dynamic variables in the template of instance {@link Model}
	 * @return string 
	 */
	@GetMapping("/login")
	public String execute(Model model)
	{
		model.addAttribute("user", this.user);
		return "loginform";
	}

}