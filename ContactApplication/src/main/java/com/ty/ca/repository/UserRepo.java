package com.ty.ca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ca.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);

}
