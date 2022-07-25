package com.epam.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.userservice.entity.UserEntity;
import com.epam.userservice.exceptions.AccountAlreadyExistsException;
import com.epam.userservice.exceptions.UserAlreadyExists;
import com.epam.userservice.exceptions.UserDoesNotExists;
import com.epam.userservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServcieImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserEntity addUser(UserEntity user) {
		log.info("Create Service started");
		Optional<UserEntity> userAccount =userRepository.findById(user.getUserName());
		if (userAccount.isPresent()) {
			throw new AccountAlreadyExistsException("Account Already exists with User Name "+ user.getUserName() );
		} 
		userRepository.save(user);
		log.info("Create Service ended");
		return user;
	}

	@Override
	public List<UserEntity> getAllUser() {
		return userRepository.findAll();
	}
 
	@Override
	public UserEntity getUserByUserName(String userName) {
		Optional<UserEntity> user = userRepository.findById(userName);
		if (!user.isPresent()) {
			throw new UserDoesNotExists("User Does not exists");
		}
		return user.get();
	}

	@Override
	public boolean deleteUser(String userName) {
		boolean isDeleted = false;
		if (userRepository.findById(userName).isPresent()) {
			userRepository.deleteById(userName);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public void validateUser(String existingUserName, String newUserName) {
		if ((!existingUserName.equals(newUserName)) && userRepository.findById(newUserName).isPresent())
			throw new UserAlreadyExists("The name you trying to change already exists. please try different User Name");
		deleteUser(existingUserName);
	}
	
//	public Link getSelfLink(UserEntity user)
//	{
//		return WebMvcLinkBuilder.linkTo(UserController.class).slash(user.getUserName()).withSelfRel();
//	}
//	
//	public Link getAllUserLink()
//	{
//		return WebMvcLinkBuilder.linkTo(UserController.class).withRel("AllUsers");
//	}
}
