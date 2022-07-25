package com.epam.libraryservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookEntity {

	public BookEntity(String name, String publisher, String author) {
		this.name = name;
		this.publisher = publisher;
		this.author = author;
	}

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String publisher;
	private String author;

}
