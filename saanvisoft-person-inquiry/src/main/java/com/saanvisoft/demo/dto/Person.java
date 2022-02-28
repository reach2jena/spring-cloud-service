package com.saanvisoft.demo.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Person {

	@NotNull(message = "Name parameter can not be Empty") 
	private String name;
	@Id
	private Integer id;
	private String countryName;
	private String phoneNumber;
}
