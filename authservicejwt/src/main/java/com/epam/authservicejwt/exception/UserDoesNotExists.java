package com.epam.authservicejwt.exception;

public class UserDoesNotExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDoesNotExists(String message)
	{
		super(message);
	}
}
