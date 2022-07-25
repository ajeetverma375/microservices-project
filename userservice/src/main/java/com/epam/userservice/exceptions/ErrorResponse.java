package com.epam.userservice.exceptions;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorResponse {
	private Date timestamp;
	private String message;
	private String details;
	
	public ErrorResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
}