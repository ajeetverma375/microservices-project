package com.epam.libraryservice.utility;

public class Constant  {
	public static final String EMAIL_MESSAGE = "Invalid email";
	public static final String VALIDATE_NAME = "^[A-Za-z]{2,}";
	public static final String VALIDATE_PUBLISHER = "^[A-Za-z ]+";
	public static final String VALIDATE_PUBLISHER_MESSAGE = "only alphabets";
	public static final String VALIDATE_AUTHOR = "^[A-Za-z ]+";
	public static final String VALIDATE_AUTHOR_MESSAGE = "only alphabets";
	public static final String NAME_VALIDATION_MESSAGE = "Name must contain only alphabets with minimum length 2";
	public static final String VALIDATE_USER_NAME="^[ A-Za-z0-9_@./#&+-]*$";
	public static final String VALIDATE_USER_NAME_MESSAGE="User name can contain alphanumeric charachters and some special characters @,#,&,+,-";
	private Constant() {
		super();
	}
	
}