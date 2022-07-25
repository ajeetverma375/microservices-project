package com.epam.userservice.exceptions;


public class InvalidUserName extends RuntimeException {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public InvalidUserName() {
	}

	public InvalidUserName(String msg) {
		super(msg);
	}
}
