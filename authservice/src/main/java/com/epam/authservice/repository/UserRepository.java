package com.epam.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.authservice.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

	

}
