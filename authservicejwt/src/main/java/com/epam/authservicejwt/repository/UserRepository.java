package com.epam.authservicejwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.authservicejwt.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

	

}
