package com.epam.libraryservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class UserDTO {//extends RepresentationModel<UserDTO>{
	
	private String userName;
	private String email;
	private String name;
	private String password;
	
	public UserDTO(String userName, String email, String name) {
		super();
		this.userName = userName;
		this.email = email;
		this.name = name;
	}

}
