package com.ty.ca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.ca.dao.UserDao;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;
}
