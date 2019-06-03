package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Article;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String>{

	public Article findByTitle(String title);
	public List<Article> findByAuthor(String author);
}
