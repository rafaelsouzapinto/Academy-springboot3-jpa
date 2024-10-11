package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entities.Enrollment;
import com.backend.services.EnrollmentService;

@RestController
@RequestMapping(value = "/enrollments")
public class EnrollmentController {
	@Autowired
	private EnrollmentService service;
	
	@GetMapping
	public ResponseEntity<List<Enrollment>> findAll() {
		List<Enrollment> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
