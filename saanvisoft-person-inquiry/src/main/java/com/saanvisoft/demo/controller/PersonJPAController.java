package com.saanvisoft.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saanvisoft.demo.dto.Person;
import com.saanvisoft.demo.reposityory.PersonJPARepository;
import com.saanvisoft.demo.util.SuccessResponse;


@RestController
public class PersonJPAController {
	private static final String className = PersonJPAController.class.toString();
	@Autowired
	private PersonJPARepository repo;



	@GetMapping(path = "/getFirstJPA")
	public String getFirstStatement()
	{
		return "First Call";
	}                                                  

	@GetMapping(path = "/getallPersonsJPA")
	public ResponseEntity<CollectionModel> getAllPersons()
	{
		List<Person> personLiist =repo.findAll();
		CollectionModel model = CollectionModel.of(personLiist);

		WebMvcLinkBuilder linkToPersons = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
				this.getClass()).getAllPersons());
		model.add(linkToPersons.withRel("all-persons"));

		return new ResponseEntity<>(model, HttpStatus.OK);
	}   



	@PostMapping(path = "/savePersonJPA", consumes ={MediaType.APPLICATION_JSON_VALUE} , produces ={MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> savePersonJPA(@Valid @RequestBody Person person) throws Exception
	{
		Person personObj = repo.save(person);
		if(	Optional.of(personObj).isPresent())
		{
			SuccessResponse successResponse = new SuccessResponse("201",className,"Person Created with ID: "+personObj.getId(),"");
			return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
		}else {
			throw new Exception("Error Occured while inserting data -->");
		}

	} 

	@DeleteMapping(path = "/deletePersonJPA/{id}" )
	public ResponseEntity<Object> savePersonJPA(@PathVariable int id) throws Exception
	{
		try {
			repo.deleteById(id);
			SuccessResponse successResponse = new SuccessResponse("200",className,"Person deleted with ID: "+id,"");
			return new ResponseEntity<>(successResponse, HttpStatus.OK);
		}catch(Exception e)
		{
			throw new Exception("Error Occured while inserting data -->");
		}



	} 
}
