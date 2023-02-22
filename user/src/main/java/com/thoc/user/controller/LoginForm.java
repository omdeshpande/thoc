package com.thoc.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.ISpringTemplateEngine;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.thoc.user.contract.data.User;

@Controller
public class LoginForm
{

	/**
	 * Credentials posted from the login form.
	 */
	@Autowired
    private User user;
	
	/**
	 * Template engine.
	 */
	@Autowired
	private ISpringTemplateEngine templateEngine;
	
	/**
	 * Application context.
	 */
	@Autowired
	private Context context;

	/**
	 * Handles the rendering of the login form.
	 * 
	 * @param model ViewModel to set dynamic variables in the template of instance {@link Model}
	 * @return string 
	 */
	@GetMapping("/login")
	@CrossOrigin(origins = "http://localhost:8081")
	public String execute(Model model)
	{
		model.addAttribute("user", this.user);
		return "loginform";
	}
	
	/**
	 * Handles the rendering of the login form.
	 * 
	 * @param model ViewModel to set dynamic variables in the template of instance {@link Model}
	 * @return string 
	 */
	@GetMapping("/api/v1/login/form")
	@CrossOrigin(origins = "http://localhost:8081")
	public String executeApi(Model model)
	{
		model.addAttribute("statusCode", "200");
		model.addAttribute("statusDescription", "Success");
		
		// Content
		this.context.setVariable("user", this.user); 
		String html = this.templateEngine.process("loginform", this.context);
		model.addAttribute("content", StringEscapeUtils.escapeJson(html));
		   
		return "api/loginform.json";
	}

}