package com.saanvisoft.microservices.currencyconversionservice;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saanvisoft.microservices.currencyconversionservice.dto.Person;
import com.saanvisoft.microservices.currencyconversionservice.util.SuccessResponse;

@RestController
public class PersonServiceController {


	private static final String className = PersonServiceController.class.toString();
	@Autowired
	private PersonServiceProxy proxy;



	@GetMapping(path = "/getFirstJPA")
	public String getFirstStatement()
	{
		return "First Call";
	}                                                  

	@GetMapping(path = "/getallPersonsfromCurrency")
	public ResponseEntity<CollectionModel> getAllPersons()
	{

		ResponseEntity<CollectionModel> model= proxy.getAllPersons();

		return model;
	}   



	@PostMapping(path = "/savePersonFromCurrencyService", consumes ={MediaType.APPLICATION_JSON_VALUE} , produces ={MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> savePersonJPA(@Valid @RequestBody Person person) throws Exception
	{
		ResponseEntity<Object> response=null;
		try {
			response = proxy.savePersonJPA(person);
			if(	Optional.of(response).isPresent())
			{
				if (response.getStatusCode().is2xxSuccessful()) {
					SuccessResponse successResponse = new SuccessResponse("201",className,"Person Created with ID: "+person.getId(),"");
					return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
				}
			}
		}catch(Exception e)
		{
			return new ResponseEntity<Object>("Error Occured-->", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	} 

	@DeleteMapping(path = "/deletePersonFromCurrency/{id}" )
	public ResponseEntity<Object> savePersonJPA(@PathVariable int id) throws Exception
	{
		ResponseEntity<Object> response=null;
		try {
			response =proxy.deletePerson(id);
			if (response.getStatusCode().is2xxSuccessful()) {
				SuccessResponse successResponse = new SuccessResponse("200",className,"Person deleted with ID: "+id,"");
				response = new ResponseEntity<>(successResponse, HttpStatus.CREATED);
			}else if(response.getStatusCode().is5xxServerError())
			{
				response = new ResponseEntity<Object>(response.getBody(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
			//SuccessResponse successResponse = new SuccessResponse("200",className,"Person deleted with ID: "+id,"");
			//return new ResponseEntity<>(successResponse, HttpStatus.OK);
		}catch(Exception e)
		{
			response = new ResponseEntity<Object>("Error Occured-->", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	} 
}
