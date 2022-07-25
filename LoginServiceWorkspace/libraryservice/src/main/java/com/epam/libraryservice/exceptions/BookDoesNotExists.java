package com.epam.libraryservice.exceptions;

public class BookDoesNotExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookDoesNotExists(String message)
	{
		super(message);
	}
}
