package com.thoc.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.thoc.user.model.data.User;
import com.thoc.user.contract.UserService;

@Controller
public class RegistrationPost 
{

    /**
     * User Service.
     */
    @Autowired
    private UserService userService;

    /**
     * Password encryptor service.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
	 * Handles user registration.
	 * 
	 * @param model ViewModel to set dynamic variables in the template of instance {@link Model}
	 * @return string
	 */
	@PostMapping("/register")
	public String execute(User user, Model model)
	{
        try {
            this.userService.loadUserByUsername(user.getUsername());
            model.addAttribute("auth", "failed");
            model.addAttribute("reason", "Incorrect email or password, please try again");
            model.addAttribute("user", user);
            return "registrationform";
        } catch (UsernameNotFoundException exception) {
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            this.userService.save(user);
		    return "loginsuccess";
        }
	}
}
