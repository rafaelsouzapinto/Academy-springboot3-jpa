package com.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.backend.entities.Enrollment;
import com.backend.repositories.EnrollmentRepository;
import com.backend.services.exceptions.DatabaseException;
import com.backend.services.exceptions.ResourceNotFoundException;

@Service
public class EnrollmentService {
	
	@Autowired
	private EnrollmentRepository repository;
	
	public List<Enrollment> findAll() {
		return repository.findAll();
	}
	
	public Enrollment findById(Long id) {
		Optional<Enrollment> enrollment = repository.findById(id);
		return enrollment.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Enrollment insert(Enrollment obj) {
		return repository.save(obj);
	}
	
	public Enrollment update(Enrollment obj, Long id) {
		try {
			if(!repository.existsById(id)) throw new ResourceNotFoundException(id);
			Enrollment enrollment = findById(id);
			enrollment.setAcademyPlan(obj.getAcademyPlan());
			enrollment.setClient(obj.getClient());
			enrollment.setEnd(obj.getEnd());
			enrollment.setEnrollmentStatus(obj.getEnrollmentStatus());
			enrollment.setStart(obj.getStart());
			return repository.save(enrollment);		
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void delete(Long id) {
		try {
			if (!repository.existsById(id)) throw new ResourceNotFoundException(id);
			repository.deleteById(id);			
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
