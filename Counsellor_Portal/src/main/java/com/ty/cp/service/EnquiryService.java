package com.ty.cp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.cp.repository.EnquriyRepo;

@Service
public class EnquiryService {

	@Autowired
	private EnquriyRepo enquriyRepo;
}
