package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	//create operation
	public Person create(String firstName, String lastName, int age) {
		return personRepository.save(new Person(firstName, lastName, age));
		
	}
	//retrieve operation
	public List<Person>getAll(){
		return personRepository.findAll();
	}
	public Person getrByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}
	
	//update operation
	public Person update(String firstName, String lastName, int age) {
		Person p= personRepository.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return personRepository.save(p);
	}
	
	//delete operation
	public void deleteAll() {
		personRepository.deleteAll();
	}
	public void delete(String firstName) {
		Person p= personRepository.findByFirstName(firstName);
		personRepository.delete(p);
		
	}
}
