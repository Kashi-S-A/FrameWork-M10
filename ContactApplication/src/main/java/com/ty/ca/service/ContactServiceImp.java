package com.ty.ca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.ca.dao.ContactDao;
import com.ty.ca.entity.Contact;

@Service
public class ContactServiceImp implements ContactService{

	@Autowired
	private ContactDao contactDao;

	@Override
	public boolean saveContact(Contact contact) {
		boolean saved = contactDao.saveContact(contact);
		return saved;
	}

	@Override
	public Contact findById(Integer cid) {
		Contact contact = contactDao.findById(cid);
		return contact;
	}
}
