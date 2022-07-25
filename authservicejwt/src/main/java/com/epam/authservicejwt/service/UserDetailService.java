package com.epam.authservicejwt.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.authservicejwt.exception.UserDoesNotExists;
import com.epam.authservicejwt.model.UserEntity;
import com.epam.authservicejwt.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("/n/n"+username);
		Optional<UserEntity>  user= repository.findById(username);
		if(user.isEmpty())
			throw new UserDoesNotExists("user does not exists");
		return new User(user.get().getUserName(),user.get().getPassword(),new ArrayList<>());
	}

}
