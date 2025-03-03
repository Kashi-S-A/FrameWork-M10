package com.ty.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.entity.User;
import com.ty.repo.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo userRepo;

	public Optional<User> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public boolean saveUser(User user) {
		return userRepo.save(user)!=null;
	}
}
