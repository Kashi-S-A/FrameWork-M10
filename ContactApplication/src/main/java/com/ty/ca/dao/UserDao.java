package com.ty.ca.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ca.repository.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo userRepo;
}
