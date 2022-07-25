package com.epam.libraryservice.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.epam.libraryservice.utility.Constant;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	
	private int id;
	
	@Pattern(regexp = Constant.VALIDATE_NAME,message =Constant.NAME_VALIDATION_MESSAGE)
	@NotEmpty
	private String name;
	
	@Pattern(regexp = Constant.VALIDATE_PUBLISHER,message =Constant.VALIDATE_PUBLISHER_MESSAGE)
	@NotEmpty
	private String publisher;
	
	@Pattern(regexp = Constant.VALIDATE_AUTHOR,message =Constant.VALIDATE_AUTHOR_MESSAGE)
	@NotEmpty
	private String author;
	
	@JsonIgnore
	public BookEntity getBook()
	{
		return new BookEntity(this.name,this.publisher,this.author);
	}

}
