package com.ty.cp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.cp.dto.CounsellorDTO;
import com.ty.cp.dto.LoginDTO;
import com.ty.cp.entity.Counsellor;
import com.ty.cp.entity.Enquiry;
import com.ty.cp.exception.CounsellorNotFound;
import com.ty.cp.repository.CounsellorRepo;
import com.ty.cp.rs.ResponseStructure;

@Service
public class CounsellorService {

	@Autowired
	private CounsellorRepo counsellorRepo;

	/*
	 * Register Counsellor based on email, if email is already registered then don't
	 * save it else save the counsellor.
	 * 
	 * @param: counsellorDTO
	 */
	public ResponseEntity<String> registerCounsellor(CounsellorDTO counsellorDTO) {

		Optional<Counsellor> opt = counsellorRepo.findByEmail(counsellorDTO.getEmail());

		if (opt.isPresent()) {
			// TODO: write logic to return already registered
			return new ResponseEntity<String>("Already Registered", HttpStatus.BAD_REQUEST);
		} else {
			// TODO: write logic to register and return the response

			Counsellor counsellor = new Counsellor();

			BeanUtils.copyProperties(counsellorDTO, counsellor);

			counsellorRepo.save(counsellor);

			return new ResponseEntity<String>("Registered Successfully", HttpStatus.CREATED);
		}

	}

	/*
	 * @param: LogingDTO Responsible to validate username(email) and password, if
	 * validated successfully then return Login succ else return invalid
	 * credentilas.
	 */
	public ResponseEntity<String> login(LoginDTO dto) {

		Optional<Counsellor> opt = counsellorRepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword());

		if (opt.isPresent()) {
			return new ResponseEntity<String>("Logged in successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Invalid Credentials", HttpStatus.BAD_REQUEST);
		}

	}

	public ResponseEntity<ResponseStructure<CounsellorDTO>> updateCounsellor(Integer cid, CounsellorDTO counsellorDTO) {
		Counsellor counsellor = counsellorRepo.findById(cid)
				.orElseThrow(() -> new CounsellorNotFound("counsellor is not registered"));
		
		if(counsellorDTO.getEmail()!=null)
			counsellor.setEmail(counsellorDTO.getEmail());
		if(counsellorDTO.getName()!=null)
			counsellor.setName(counsellorDTO.getName());
		if(counsellorDTO.getPhone()!=null)
			counsellor.setPhone(counsellorDTO.getPhone());
		if(counsellorDTO.getPassword()!=null)
			counsellor.setPassword(counsellorDTO.getPassword());
		
		Counsellor updated = counsellorRepo.save(counsellor);
		
		BeanUtils.copyProperties(updated, counsellorDTO);
		
		ResponseStructure<CounsellorDTO> rs=new ResponseStructure<>();
		rs.setMessage("Updated Successfully");
		rs.setData(counsellorDTO);
		
		return new ResponseEntity<ResponseStructure<CounsellorDTO>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<List<Enquiry>> getEnquiries(Integer cid) {
		Counsellor counsellor = counsellorRepo.findById(cid)
				.orElseThrow(() -> new CounsellorNotFound("counsellor is not registered"));
		List<Enquiry> enquiries = counsellor.getEnquiries();
		
		return new ResponseEntity<List<Enquiry>>(enquiries, HttpStatus.OK);
	}
}
