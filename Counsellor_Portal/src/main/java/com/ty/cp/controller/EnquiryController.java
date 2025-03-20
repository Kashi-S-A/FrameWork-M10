package com.ty.cp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ty.cp.service.EnquiryService;

@RestController
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;
}
