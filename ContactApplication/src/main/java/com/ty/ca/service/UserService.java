package com.ty.ca.service;

import com.ty.ca.entity.User;

public interface UserService {

	boolean save(User user);

	boolean login(String email, String password);

	User getUserByEmail(String email);
}
