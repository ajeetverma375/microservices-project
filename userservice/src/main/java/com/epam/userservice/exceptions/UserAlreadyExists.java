package com.epam.userservice.exceptions;

public class UserAlreadyExists extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExists(String message)
	{
		super(message);
	}

}
