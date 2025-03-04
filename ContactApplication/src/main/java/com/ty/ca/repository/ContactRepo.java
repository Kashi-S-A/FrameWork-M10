package com.ty.ca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ca.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer>{

}
