package com.saanvisoft.microservices.currencyconversionservice.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@NotNull(message = "Name parameter can not be Empty") 
	private String name;
	
	private Integer id;
	private String countryName;
	private String phoneNumber;
}
