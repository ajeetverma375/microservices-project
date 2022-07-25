package com.epam.libraryservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDTO {
	private String username;
	private int bookId;
	
	@JsonIgnore
	public LibraryEntity getUser()
	{
		return new LibraryEntity(this.username,this.bookId);
	}
}
