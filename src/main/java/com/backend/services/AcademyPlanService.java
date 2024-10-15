package com.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entities.AcademyPlan;
import com.backend.repositories.AcademyPlanRepository;

@Service
public class AcademyPlanService {
	
	@Autowired
	private AcademyPlanRepository repository;
	
	public List<AcademyPlan> findAll() {
		return repository.findAll();
	}
	
	public AcademyPlan findById(Long id) {
		Optional<AcademyPlan> plan = repository.findById(id);
		return plan.get();
	}
	
	public AcademyPlan insert(AcademyPlan obj) {
		return repository.save(obj);
	}
	
	public AcademyPlan update(AcademyPlan obj, Long id) {
		AcademyPlan plan = findById(id);
		plan.setDescription(obj.getDescription());
		plan.setDurationDays(obj.getDurationDays());
		plan.setName(obj.getName());
		plan.setPrice(obj.getPrice());
		return repository.save(plan);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
