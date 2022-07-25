package com.epam.userservice.exceptions;

public class NullValueException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullValueException(String message) {
		super(message);
	}

	public NullValueException() {
		super();
	}

}
