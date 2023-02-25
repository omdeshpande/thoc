package com.thoc.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.ISpringTemplateEngine;
import org.springframework.beans.factory.annotation.Autowired;

import com.thoc.user.contract.api.ApiResponse;
import com.thoc.user.contract.api.HtmlContent;
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
	 * API Response.
	 */
	@Autowired
	private ApiResponse apiResponse;
	
	/**
	 * API Content.
	 */
	@Autowired
	private HtmlContent htmlContent;

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
	@ResponseBody
	public ApiResponse executeApi(Model model)
	{
		this.apiResponse.setStatus("200");
		this.apiResponse.setDescription("Success");
		
		// Content
		this.context.setVariable("user", this.user); 
		String html = this.templateEngine.process("loginform", this.context);
		this.htmlContent.setHtml(html);
		this.apiResponse.setContent(this.htmlContent);
		
		return this.apiResponse;
	}

}