package com.saanvisoft.microservices.currencyconversionservice;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.saanvisoft.microservices.currencyconversionservice.dto.Person;

@FeignClient(name = "person-service")
public interface PersonServiceProxy {

	
	@GetMapping(path = "/getallPersonsJPA")
	public ResponseEntity<CollectionModel> getAllPersons();

	@PostMapping(path = "/savePersonJPA", consumes ={MediaType.APPLICATION_JSON_VALUE} , produces ={MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> savePersonJPA(@Valid @RequestBody Person person) throws Exception;
 

	@DeleteMapping(path = "/deletePersonJPA/{id}" )
	public ResponseEntity<Object> deletePerson(@PathVariable int id) throws Exception;
	
}
