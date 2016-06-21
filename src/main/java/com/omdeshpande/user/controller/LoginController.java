package com.omdeshpande.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.omdeshpande.lib.abstracts.BasicBlogControllerAbstract;

@Controller
public class LoginController extends BasicBlogControllerAbstract  {
	
	@RequestMapping("login")
	 public String getLoginForm(
	   @RequestParam(required = false) String authfailed, String logout,
	   String denied, Model m) {
	  String message = "";
		  if (authfailed != null) {
		   message = "Invalid username of password, try again !";
		  } else if (logout != null) {
		   message = "Logged Out successfully, login again to continue !";
		  } else if (denied != null) {
		   message = "Access denied for this user !";
		  }
		  m.addAttribute("message", message);
		  m.addAttribute("css", getLayout().getBlocks().get("head").getCss());
		  m.addAttribute("js", getLayout().getBlocks().get("head").getJs());
		  return "admin-login";
	}

	 @RequestMapping("user")
	 public String geUserPage() {
	  return "user";
	 }

	 @RequestMapping("admin")
	 public String geAdminPage() {
	  return "admin";
	 }

	 @RequestMapping("403")
	 public String ge403denied() {
	  return "redirect:login?denied";
	 }
}
