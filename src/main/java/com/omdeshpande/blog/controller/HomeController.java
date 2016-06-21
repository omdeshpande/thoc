package com.omdeshpande.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.omdeshpande.blog.model.Article;
import com.omdeshpande.lib.abstracts.BasicBlogControllerAbstract;

@Controller
public class HomeController extends BasicBlogControllerAbstract {

	@RequestMapping("/")
	public String requestHandler(Model model) {
		List<Article> articles = new ArrayList<Article>();
		Article article = new Article();
		article.setAuthor("Om Deshpande");
		article.setContent("Test content....");
		article.setTitle("Test Blog");
		articles.add(article);
		Article article1 = new Article();
		article1.setAuthor("Om Deshpande");
		article1.setContent("Test content....");
		article1.setTitle("Test Blog");
		articles.add(article1);
		model.addAttribute("articles", articles);
		
		model.addAttribute("css", getLayout().getBlocks().get("head").getCss());
		model.addAttribute("js", getLayout().getBlocks().get("head").getJs());
		return "home";
	}
}
