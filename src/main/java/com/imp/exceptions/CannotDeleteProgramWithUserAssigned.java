package com.imp.exceptions;

public class CannotDeleteProgramWithUserAssigned extends Exception {

	public CannotDeleteProgramWithUserAssigned() {
		super();
	}
	
	public CannotDeleteProgramWithUserAssigned(String message) {
		super(message);
	}	
}
