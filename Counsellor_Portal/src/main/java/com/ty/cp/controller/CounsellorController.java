package com.ty.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.cp.dto.CounsellorDTO;
import com.ty.cp.dto.LoginDTO;
import com.ty.cp.entity.Enquiry;
import com.ty.cp.rs.ResponseStructure;
import com.ty.cp.service.CounsellorService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/counsellor")
public class CounsellorController {

	@Autowired
	private CounsellorService counsellorService;

	@PostMapping("/register")
	public ResponseEntity<String> registerCounsellor(@RequestBody CounsellorDTO counsellorDTO) {

		ResponseEntity<String> registerCounsellor = counsellorService.registerCounsellor(counsellorDTO);

		return registerCounsellor;
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {

		return counsellorService.login(loginDTO);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<CounsellorDTO>> updateCounsellor(@PathVariable Integer id,
			@RequestBody CounsellorDTO counsellorDTO) {

		return counsellorService.updateCounsellor(id, counsellorDTO);
	}
	
	@GetMapping("/enq")
	public ResponseEntity<List<Enquiry>> getEnquiries(@RequestParam Integer cid) {
	
		return counsellorService.getEnquiries(cid);
	}
	
//	@DeleteMapping("/delete/{cid}")
//	public ResponseEntity<String> deleteCounsellor(@PathVariable Integer cid){
//		//TODO : Logic to delete counsellor by id
//	}
	
}
