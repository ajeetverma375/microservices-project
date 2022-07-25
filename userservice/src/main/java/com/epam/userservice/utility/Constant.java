package com.epam.userservice.utility;

public class Constant  {
	public static final String VALIDATE_GROUP_NAME = "^[A-Za-z ]{5,}";
	public static final String GROUP_VALIDATION_MESSAGE ="group name must only contain alphabets with length 5";
	public static final String VALIDATE_URL = "((http|https)://)(www.)?" + "[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)";
	public static final String URL_MESSAGE="Url must be proper";
	public static final String URL_VALIDATION_MESSAGE = "Invalid URL";
	public static final String PASSWORD_MESSAGE = "Password is not Strong.It must have Atleast one Capital,small letter,One digit,One Special Character and it must not exceed 20 characters";
	public static final String VALIDATE_NAME = "^[A-Za-z]{2,}";
	public static final String VALIDATE_PASSWORD = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
	public static final String EMAIL_MESSAGE = "Invalid email";
	public static final String NAME_VALIDATION_MESSAGE = "Name must contain only alphabets with minimum length 2";
	public static final String ACCOUNT_PASSWORD_MESSAGE =  "password should have atleast 8-20 charachters";
	public static final String VALIDATE_USER_NAME="^[ A-Za-z0-9_@./#&+-]*$";
	public static final String VALIDATE_USER_NAME_MESSAGE="User name can contain alphanumeric charachters and some special characters @,#,&,+,-";
	private Constant() {
		super();
	}
	
}