package com.ty.ca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ca.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
