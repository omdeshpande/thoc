package com.thoc.header.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Logo
{
    /**
	 * Handles the rendering of the logo.
	 * 
	 * @return string 
	 */
	@GetMapping("/logo")
	@CrossOrigin(origins = "http://localhost:8081")
	public String execute()
	{
		return "logo";
	}
}
