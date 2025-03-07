package com.ty.ca.service;

import com.ty.ca.entity.Contact;

public interface ContactService {

	boolean saveContact(Contact contact);

	Contact findById(Integer cid);

	boolean deleteContact(Integer cid);

}
