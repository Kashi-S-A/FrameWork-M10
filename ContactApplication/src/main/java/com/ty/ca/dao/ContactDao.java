package com.ty.ca.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ca.repository.ContactRepo;

@Repository
public class ContactDao {

	@Autowired
	private ContactRepo contactRepo;
}
