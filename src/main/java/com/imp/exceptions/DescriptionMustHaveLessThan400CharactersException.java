package com.imp.exceptions;

public class DescriptionMustHaveLessThan400CharactersException extends Exception {

	public DescriptionMustHaveLessThan400CharactersException() {
		super();
	}
	
	public DescriptionMustHaveLessThan400CharactersException(String message) {
		super(message);
	}	
}
