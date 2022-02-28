package com.saanvisoft.demo.util;

import lombok.Data;

@Data
public class SuccessResponse {
	private String responseCode;
	private String details;
	private String info;
	private String responseText;
	public SuccessResponse(String responseCode, String details, String info, String responseText) {
	
		this.responseCode = responseCode;
		this.details = details;
		this.info = info;
		this.responseText = responseText;
	}
}
