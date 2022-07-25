package com.epam.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.userservice.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
