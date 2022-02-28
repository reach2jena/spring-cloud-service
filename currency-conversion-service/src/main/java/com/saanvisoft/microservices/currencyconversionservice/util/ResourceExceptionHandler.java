package com.saanvisoft.microservices.currencyconversionservice.util;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler{


	@Override

	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String errorMessage = ex.getBindingResult().getFieldErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.joining(":"));

		return new ResponseEntity<Object>(new ErrorResponse("500","","",errorMessage),HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(Exception.class)
	private ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
		System.out.println(" Error -- >");
		return new ResponseEntity<ErrorResponse>(new ErrorResponse("500",ex.getMessage(),ex.getLocalizedMessage(),ex.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
