package com.ty.cp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.cp.entity.Counsellor;
import com.ty.cp.entity.Enquiry;
import com.ty.cp.enums.ClassMode;
import com.ty.cp.enums.Course;
import com.ty.cp.enums.Status;
import com.ty.cp.exception.CounsellorNotFound;
import com.ty.cp.exception.EnquiryNotFound;
import com.ty.cp.repository.CounsellorRepo;
import com.ty.cp.repository.EnquriyRepo;

@Service
public class EnquiryService {

	@Autowired
	private EnquriyRepo enquriyRepo;

	@Autowired
	private CounsellorRepo counsellorRepo;

	public ResponseEntity<String> addEnquiry(Integer cid, Enquiry enquiry) {
		Counsellor counsellor = counsellorRepo.findById(cid)
				.orElseThrow(() -> new CounsellorNotFound("Counsellor is not registered"));
		enquiry.setCounsellor(counsellor);
		enquriyRepo.save(enquiry);
		return new ResponseEntity<>("Enquiry is added", HttpStatus.CREATED);
	}

	public ResponseEntity<String> updateClassMode(Integer id, ClassMode classMode) {
		Enquiry enquriy = enquriyRepo.findById(id).orElseThrow(() -> new EnquiryNotFound("Enquiry is not added"));
		enquriy.setClassMode(classMode);
		enquriyRepo.save(enquriy);
		return new ResponseEntity<>("ClassMode is udpated", HttpStatus.OK);
	}

	public ResponseEntity<List<Enquiry>> getByCourse(Course course) {
		List<Enquiry> enqs = enquriyRepo.findByCourse(course);
		return new ResponseEntity<>(enqs, HttpStatus.OK);
	}

	public ResponseEntity<List<Enquiry>> getByStatus(Status status) {
		List<Enquiry> enqs = enquriyRepo.findByStatus(status);
		return new ResponseEntity<>(enqs, HttpStatus.OK);
	}

	public ResponseEntity<String> deleteEnq(Integer id) {
		Enquiry enq = enquriyRepo.findById(id).orElseThrow(() -> new EnquiryNotFound("Enquiry not exist"));
		enquriyRepo.delete(enq);
		return new ResponseEntity<String>("Enq is deleted", HttpStatus.OK);
	}
}
