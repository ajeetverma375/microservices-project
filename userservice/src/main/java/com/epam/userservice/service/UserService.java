package com.epam.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.userservice.entity.UserEntity;

@Service
public interface UserService {

	UserEntity addUser(UserEntity user);

	List<UserEntity> getAllUser();

	boolean deleteUser(String name);

	void validateUser(String username, String userName2);

	UserEntity getUserByUserName(String userName);

}
