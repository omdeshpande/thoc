package com.thoc.header.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.ISpringTemplateEngine;

import com.thoc.header.contract.api.ApiResponse;
import com.thoc.header.contract.api.HtmlContent;

@RestController
public class MenuItems
{
	
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
	 * Handles the rendering of the menu items.
	 * 
	 * @return string 
	 */
	@GetMapping("/api/v1/html/menu-items")
	@CrossOrigin(origins = "http://localhost:8081")
	public ApiResponse execute(Model model, Principal principal)
	{
		this.apiResponse.setStatus("200");
		this.apiResponse.setDescription("Success");
		
		// Is user logged in?
		boolean isLoggedIn = false;
		if (principal.getName().isEmpty() == false) {
			isLoggedIn = true;
		}
		
		// Content
		this.context.setVariable("isLoggedIn", isLoggedIn); 
		String html = this.templateEngine.process("menu-items", this.context);
		this.htmlContent.setHtml(html);
		this.apiResponse.setContent(this.htmlContent);
		
		return this.apiResponse;
	}
}
