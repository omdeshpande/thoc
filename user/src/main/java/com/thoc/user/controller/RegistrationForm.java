package com.thoc.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.thoc.user.contract.data.User;
import org.springframework.ui.Model;

@Controller
public class RegistrationForm
{

    /**
     * User.
     */
    @Autowired
    private User user;

    /**
	 * Handles the rendering of the registration form.
	 * 
	 * @param model ViewModel to set dynamic variables in the template of instance {@link Model}
	 * @return string
	 */
	@GetMapping("/register")
	public String execute(Model model)
	{
        model.addAttribute("user", user);
		return "registrationform";
	}
    
}
