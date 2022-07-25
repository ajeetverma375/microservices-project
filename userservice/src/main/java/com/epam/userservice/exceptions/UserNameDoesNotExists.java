package com.epam.userservice.exceptions;

public class UserNameDoesNotExists extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameDoesNotExists (String message)
	{
		super(message);
	}

}
