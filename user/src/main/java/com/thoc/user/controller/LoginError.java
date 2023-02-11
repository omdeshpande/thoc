package com.thoc.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.thoc.user.contract.data.User;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class LoginError
{

    /**
	 * Credentials posted from the login form.
	 */
	@Autowired
    private User user;

    /**
	 * Handles the authentication after the user submits the sign in form.
	 * 
	 * @param model ViewModel to set dynamic variables in the template of instance {@link Model}.
	 * @return string 
	 */
	@GetMapping("/login/error")
	public String execute(Model model)
	{
		model.addAttribute("auth", "failed");
        model.addAttribute("reason", "Incorrect email or password, please try again");
        model.addAttribute("user", this.user);
		return "loginform";
	}
}
