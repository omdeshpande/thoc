package com.thoc.user.controller;

import org.springframework.web.bind.annotation.PostMapping;

import com.thoc.user.contract.UserService;
import com.thoc.user.model.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AccountSave 
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
	@PostMapping("/account/save")
	public String execute(User user, Model model)
	{
        this.userService.save(user);
        model.addAttribute("user", user);
		return "redirect:/account/edit";
	}
}
