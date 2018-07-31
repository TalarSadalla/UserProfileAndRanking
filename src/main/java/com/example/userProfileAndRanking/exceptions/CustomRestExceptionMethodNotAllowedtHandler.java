package com.example.userProfileAndRanking.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionMethodNotAllowedtHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>("Method not allowed, please try a different one: GET, PUT, POST, DELETE",
				new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
	}
}
