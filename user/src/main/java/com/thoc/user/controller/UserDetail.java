package com.thoc.user.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.ISpringTemplateEngine;

import com.thoc.user.contract.UserService;
import com.thoc.user.contract.api.ApiResponse;
import com.thoc.user.contract.api.HtmlContent;

import org.springframework.ui.Model;

@RestController
public class UserDetail 
{

    /**
     * User service.
     */
    @Autowired
    private UserService userService;
    
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
	 * Handles the rendering of the account edit form.
	 * 
	 * @param model ViewModel to set dynamic variables in the template of instance {@link Model}
	 * @return string
	 */
	@GetMapping("/api/v1/html/user-edit-form")
	public ApiResponse execute(Principal principal)
	{
        UserDetails user = this.userService.loadUserByUsername(principal.getName());
        
        this.apiResponse.setStatus("200");
		this.apiResponse.setDescription("Success");
		
		// Content
		this.context.setVariable("user", user); 
		String html = this.templateEngine.process("usereditform", this.context);
		this.htmlContent.setHtml(html);
		this.apiResponse.setContent(this.htmlContent);
		
		return this.apiResponse;
	}
}
