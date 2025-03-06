package com.ty.ca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.ca.dao.UserDao;
import com.ty.ca.entity.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean save(User user) {

		Optional<User> opt = userDao.findByEmail(user.getEmail());

		if (opt.isPresent()) {
			return false;
		}

		boolean saved = userDao.save(user);

		return saved;
	}

	@Override
	public boolean login(String email, String password) {

		Optional<User> opt = userDao.findByEmail(email);

		if (opt.isPresent() && opt.get().getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public User getUserByEmail(String email) {
		Optional<User> opt = userDao.findByEmail(email);
		return opt.get();
	}

	@Override
	public User getById(Integer uid) {
		User user = userDao.getByUid(uid);
		return user;
	}
}
