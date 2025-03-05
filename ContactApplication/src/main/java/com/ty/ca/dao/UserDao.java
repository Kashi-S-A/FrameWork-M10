package com.ty.ca.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ca.entity.User;
import com.ty.ca.repository.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo userRepo;

	public Optional<User> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public boolean save(User user) {
		User save = userRepo.save(user);
		return save!=null;
	}
}
