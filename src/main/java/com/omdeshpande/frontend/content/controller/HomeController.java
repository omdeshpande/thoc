package com.omdeshpande.frontend.content.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.omdeshpande.lib.abstracts.BasicBlogControllerAbstract;

@Controller
public class HomeController extends BasicBlogControllerAbstract {

	@RequestMapping("/")
	public String requestHandler(Model model) {
		
		model.addAttribute("css", getLayout().getBlocks().get("head").getCss());
		model.addAttribute("js", getLayout().getBlocks().get("head").getJs());
		return "home";
	}
}
