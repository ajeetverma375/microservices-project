package com.epam.bookservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.bookservice.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
	
	Optional<BookEntity> findByName(String name);

}
