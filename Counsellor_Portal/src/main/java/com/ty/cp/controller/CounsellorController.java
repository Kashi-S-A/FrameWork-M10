package com.ty.cp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.cp.dto.CounsellorDTO;
import com.ty.cp.service.CounsellorService;

@RestController
public class CounsellorController {

	@Autowired
	private CounsellorService counsellorService;

	@PostMapping("/register")
	public ResponseEntity<String> registerCounsellor(@RequestBody CounsellorDTO counsellorDTO) {

		ResponseEntity<String> registerCounsellor = counsellorService.registerCounsellor(counsellorDTO);

		return registerCounsellor;
	}

}
