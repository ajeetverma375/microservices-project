package com.epam.authservicejwt.model;


import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity{
	
	@Id
	private String userName;
	private String email;
	private String name;
	@JsonIgnore
    private String password;

	public UserEntity(String userName, String email, String name) {
		super();
		this.userName = userName;
		this.email = email;
		this.name = name;
	}

}
