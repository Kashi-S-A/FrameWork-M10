package com.ty.cp.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.cp.dto.CounsellorDTO;
import com.ty.cp.entity.Counsellor;
import com.ty.cp.repository.CounsellorRepo;

@Service
public class CounsellorService {

	@Autowired
	private CounsellorRepo counsellorRepo;

	public ResponseEntity<String> registerCounsellor(CounsellorDTO counsellorDTO) {
		
		Optional<Counsellor> opt = counsellorRepo.findByEmail(counsellorDTO.getEmail());
		
		if (opt.isPresent()) {
			//TODO: write logic to return already registered
			return new ResponseEntity<String>("Already Registered", HttpStatus.BAD_REQUEST);
		} else {
			//TODO: write logic to register and return the response
			
			Counsellor counsellor=new Counsellor();
			
			BeanUtils.copyProperties(counsellorDTO, counsellor);
			
			counsellorRepo.save(counsellor);
			
			return new ResponseEntity<String>("Registered Successfully", HttpStatus.CREATED);
		}
		
	}
}
