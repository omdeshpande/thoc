package com.thoc.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.ISpringTemplateEngine;

import com.thoc.user.contract.api.ApiResponse;
import com.thoc.user.contract.api.HtmlContent;
import com.thoc.user.contract.data.User;
import org.springframework.ui.Model;

@RestController
public class RegistrationForm
{

    /**
     * User.
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
	 * Handles the rendering of the registration form.
	 * 
	 * @param model ViewModel to set dynamic variables in the template of instance {@link Model}.
	 * @return Api response of instance {@link ApiResponse}.
	 */
	@GetMapping("/api/v1/html/registration-form")
	@CrossOrigin(origins = "http://localhost:8081")
	public ApiResponse execute(Model model)
	{
		this.apiResponse.setStatus("200");
		this.apiResponse.setDescription("Success");
		
		// Content
		this.context.setVariable("user", this.user); 
		String html = this.templateEngine.process("registrationform", this.context);
		this.htmlContent.setHtml(html);
		this.apiResponse.setContent(this.htmlContent);
		
		return this.apiResponse;
	}
    
}
