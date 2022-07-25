package com.epam.libraryservice.exceptions;

public class NoBookIssuedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoBookIssuedException(String message)
	{
		super(message);
	}

	public NoBookIssuedException() {
		super();
	}
}
