package com.epam.libraryservice.exceptions;

public class BookCantBeIssuedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BookCantBeIssuedException(String message) {
		super(message);
	}

	public BookCantBeIssuedException() {
		super();
	}
}
