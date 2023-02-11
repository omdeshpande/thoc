package com.thoc.user.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.thoc.user.contract.UserService;
import org.springframework.ui.Model;

@Controller
public class AccountForm 
{

    /**
     * User service.
     */
    @Autowired
    private UserService userService;

    /**
	 * Handles the rendering of the account edit form.
	 * 
	 * @param model ViewModel to set dynamic variables in the template of instance {@link Model}
	 * @return string
	 */
	@GetMapping("/account/edit")
	public String execute(Model model, Principal principal)
	{
        String username = principal.getName();
        UserDetails user = this.userService.loadUserByUsername(username);
        model.addAttribute("user", user);
		return "accountform";
	}
}
