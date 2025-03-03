package com.ty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.dao.UserDao;
import com.ty.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public boolean saveUser(User user) {
		
		Optional<User> byEmail = dao.findByEmail(user.getEmail());
		
		if (byEmail.isPresent()) {
			return false;
		}
		return dao.saveUser(user);
	}
}
