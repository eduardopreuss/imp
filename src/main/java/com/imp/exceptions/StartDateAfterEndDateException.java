package com.imp.exceptions;

public class StartDateAfterEndDateException extends Exception {

	public StartDateAfterEndDateException() {
		super();
	}
	
	public StartDateAfterEndDateException(String message) {
		super(message);
	}	
}
