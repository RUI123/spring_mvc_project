package com.example.demo.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Article {

	@Id
	String id;
	String title;
	String author;
	String description;
	String created_at;
	String updated_at;
	List<String> tags;
	
	public Article(String title, String author, String description,
			List<String> tags) {
		
		DateTimeFormatter format=DateTimeFormatter.ofPattern("MM.dd.yyyy");
		LocalDate localDate= LocalDate.now();
		this.title=title;
		this.author=author;
		this.description=description;
		this.created_at= format.format(localDate);
		this.updated_at=format.format(localDate);
		this.tags=tags;
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	public String toStrong() {
		return "artilce title:"+title+" name:"+author+" content:"+description;
	}
	
	
}
