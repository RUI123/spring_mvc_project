package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;

@RestController
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/createC")
	public String create(@RequestParam String title, @RequestParam String author,
			@RequestParam String description,
			@RequestParam List<String> tags) {
		Article p= articleService.create( title, author,description,tags);
		return p.toString();
	}
	
	@RequestMapping("/getC")
	public Article getArticle(@RequestParam String title) {
		return articleService.getrByTitle(title);
		
	}
	
	@RequestMapping("/getAllC")
	public List<Article> getArticle() {
		return articleService.getAll();
	}
	
	@RequestMapping("/updateC")
	public String update(@RequestParam String title, @RequestParam String author,
			@RequestParam String description,
			@RequestParam List<String> tags) {
		Article p= articleService.update(title, author,description,tags);
		return p.toString();
	}
	
	@RequestMapping("/deleteC")
	public String delete(@RequestParam String title) {
		articleService.delete(title);
		return "deleted"+title;
	}
	
	@RequestMapping("/deleteAllC")
	public String deleteAll() {
		articleService.deleteAll();
		return "delete all records";
	}
}
