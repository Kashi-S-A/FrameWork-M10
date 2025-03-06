package com.ty.ca.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ca.entity.Contact;
import com.ty.ca.repository.ContactRepo;

@Repository
public class ContactDao {

	@Autowired
	private ContactRepo contactRepo;

	public boolean saveContact(Contact contact) {
		Contact saveCantact = contactRepo.save(contact);
		return saveCantact!=null;
	}

	public Contact findById(Integer cid) {
		Contact contact = contactRepo.findById(cid).get();
		return contact;
	}
}
