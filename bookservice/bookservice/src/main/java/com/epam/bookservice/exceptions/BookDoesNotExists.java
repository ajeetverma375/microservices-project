package com.epam.bookservice.exceptions;

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
