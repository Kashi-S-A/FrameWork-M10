package com.ty.ca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.ca.dao.ContactDao;

@Service
public class ContactServiceImp implements ContactService{

	@Autowired
	private ContactDao contactDao;
}
