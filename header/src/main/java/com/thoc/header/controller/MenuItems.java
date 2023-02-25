package com.thoc.header.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class MenuItems
{
    /**
	 * Handles the rendering of the menu items.
	 * 
	 * @return string 
	 */
	@GetMapping("/api/v1/html/menu-items")
	@CrossOrigin(origins = "http://localhost:8081")
	public String execute(Model model, HttpSession session)
	{
		model.addAttribute("id", session.getAttribute("id"));
		return "menu-items";
	}
}
