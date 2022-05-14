package com.janwinsoft.springboot.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Error>  handleEmptyResultDataAccessException(UserNotFoundException exception){
		    Error error = Error.builder().code(exception.getErrorCode()).message(exception.getMessage()).build();
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
