package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Article;
import com.example.demo.model.Person;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.PersonRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	//create operation
	public Article create(String title, String author, String description,
			List<String> tags) {
		return articleRepository.save(new Article(title, author, description, tags));
		
	}
	//retrieve operation
	public List<Article>getAll(){
		return articleRepository.findAll();
	}
	public Article getrByTitle(String title) {
		return articleRepository.findByTitle(title);
	}
	
	//update operation
	public Article update(String title, String author, String description,
			List<String> tags) {
		Article p= articleRepository.findByTitle(title);
		DateTimeFormatter format=DateTimeFormatter.ofPattern("MM.dd.yyyy");
		LocalDate localDate= LocalDate.now();
		p.setUpdated_at(format.format(localDate));
		p.setAuthor(author);
		p.setDescription(description);
		p.setTags(tags);
		
		return articleRepository.save(p);
	}
	
	//delete operation
	public void deleteAll() {
		articleRepository.deleteAll();
	}
	public void delete(String title) {
		Article p= articleRepository.findByTitle(title);
		articleRepository.delete(p);
	}
}
