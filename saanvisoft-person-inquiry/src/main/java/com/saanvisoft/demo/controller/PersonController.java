package com.saanvisoft.demo.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saanvisoft.demo.dto.Person;

@RestController
public class PersonController {
	
	@GetMapping(path = "/getFirst")
	public String getFirstStatement()
	{
		return "First Call";
	}                                                  
	
	@GetMapping(path = "/getallPersons")
	public ResponseEntity<?> getAllPersons()
	{
		int id =001;
		return new ResponseEntity<>(Arrays.asList(new Person("Rakesh Jena",id, "India","7506495051"),
				new Person("Rakesh Jena",id+1, "India","7506495051"),
				new Person("Rakesh Jena",id+2, "India","7506495051")), HttpStatus.OK);
	}   
	
	@PostMapping(path = "/savePerson", consumes ={MediaType.APPLICATION_JSON_VALUE} , produces ={MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> savePerson(@Valid @RequestBody Person person)
	{
		
		return new ResponseEntity<>(person.getId(), HttpStatus.OK);
	} 
}
