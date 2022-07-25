package com.epam.userservice.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.epam.userservice.utility.Constant;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	@Pattern(regexp = Constant.VALIDATE_USER_NAME,message =Constant.VALIDATE_USER_NAME_MESSAGE)
	@NotEmpty
	private String userName;
	
	@NotEmpty
	@Email(message=Constant.EMAIL_MESSAGE)
	private String email;
	
	@Pattern(regexp = Constant.VALIDATE_NAME,message =Constant.NAME_VALIDATION_MESSAGE)
	@NotEmpty
	private String name;
	
	private String password;
	public UserDTO(String userName, String email, String name) {
		super();
		this.userName = userName;
		this.email = email;
		this.name = name;
	}
	@JsonIgnore
	public UserEntity getUser()
	{
		return new UserEntity(this.userName,this.email,this.name,this.password);
	}
}
