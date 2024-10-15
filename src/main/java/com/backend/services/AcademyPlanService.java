package com.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.backend.entities.AcademyPlan;
import com.backend.repositories.AcademyPlanRepository;
import com.backend.services.exceptions.DatabaseException;
import com.backend.services.exceptions.ResourceNotFoundException;

@Service
public class AcademyPlanService {
	
	@Autowired
	private AcademyPlanRepository repository;
	
	public List<AcademyPlan> findAll() {
		return repository.findAll();
	}
	
	public AcademyPlan findById(Long id) {
		Optional<AcademyPlan> plan = repository.findById(id);
		return plan.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public AcademyPlan insert(AcademyPlan obj) {
		return repository.save(obj);
	}
	
	public AcademyPlan update(AcademyPlan obj, Long id) {
		try {
			if(!repository.existsById(id)) throw new ResourceNotFoundException(id);
			AcademyPlan plan = findById(id);
			plan.setDescription(obj.getDescription());
			plan.setDurationDays(obj.getDurationDays());
			plan.setName(obj.getName());
			plan.setPrice(obj.getPrice());
			return repository.save(plan);	
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void delete(Long id) {
		try {
			if(!repository.existsById(id)) throw new ResourceNotFoundException(id);
			repository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
