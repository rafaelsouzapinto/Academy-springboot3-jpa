package com.backend.services;

import java.util.List;
import java.util.Optional;

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
	
	public Enrollment findById(Long id) {
		Optional<Enrollment> enrollment = repository.findById(id);
		return enrollment.get();
	}
	
	public Enrollment insert(Enrollment obj) {
		return repository.save(obj);
	}
	
	public Enrollment update(Enrollment obj, Long id) {
		Enrollment enrollment = findById(id);
		enrollment.setAcademyPlan(obj.getAcademyPlan());
		enrollment.setClient(obj.getClient());
		enrollment.setEnd(obj.getEnd());
		enrollment.setEnrollmentStatus(obj.getEnrollmentStatus());
		enrollment.setStart(obj.getStart());
		return repository.save(enrollment);	
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
