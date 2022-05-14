package com.janwinsoft.springboot.app.exception;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException{

	
	private int errorCode;
	
	public UserNotFoundException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	
}
