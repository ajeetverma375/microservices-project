package com.epam.libraryservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class UserEntity{
	
	@Id
	private String userName;
	private String email;
	private String name;
	@JsonIgnore
    private String password;
}
