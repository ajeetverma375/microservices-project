package com.epam.authservice.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.authservice.exception.UserDoesNotExists;
import com.epam.authservice.model.UserEntity;
import com.epam.authservice.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity>  user= repository.findById(username);
		if(user.isEmpty())
			throw new UserDoesNotExists("user does not exists");
		return new User(user.get().getUserName(),user.get().getPassword(),new ArrayList<>());
	}

}
