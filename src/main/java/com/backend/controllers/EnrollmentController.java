package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Enrollment> findById(@PathVariable Long id) {
		Enrollment enrollment = service.findById(id);
		return ResponseEntity.ok().body(enrollment);
	}
	
	@PostMapping
	public ResponseEntity<Enrollment> insert(@RequestBody Enrollment obj) {
		Enrollment enrollment = service.insert(obj);
		return ResponseEntity.ok().body(enrollment);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Enrollment> update(@RequestBody Enrollment obj, @PathVariable Long id) {
		Enrollment enrollment = service.update(obj, id);
		return ResponseEntity.ok().body(enrollment);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
