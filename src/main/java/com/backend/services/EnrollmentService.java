package com.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entities.Enrollment;
import com.backend.repositories.EnrollmentRepository;

@Service
public class EnrollmentService {
	
	@Autowired
	private EnrollmentRepository repository;
	
	public List<Enrollment> findAll() {
		return repository.findAll();
	}
}
