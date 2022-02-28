package com.saanvisoft.demo.util;

import lombok.Data;

@Data
public class ErrorResponse {

	
	private String code;
	private String details;
	private String info;
	private String errorText;
	public ErrorResponse(String code, String details, String info, String errorText) {

		this.code = code;
		this.details = details;
		this.info = info;
		this.errorText = errorText;
	}
}
