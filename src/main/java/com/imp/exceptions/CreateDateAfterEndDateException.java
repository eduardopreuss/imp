package com.imp.exceptions;

public class CreateDateAfterEndDateException extends Exception {

	public CreateDateAfterEndDateException() {
		super();
	}
	
	public CreateDateAfterEndDateException(String message) {
		super(message);
	}	
}
