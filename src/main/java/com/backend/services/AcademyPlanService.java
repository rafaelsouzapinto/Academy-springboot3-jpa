package com.backend.services;

import java.util.List;

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
}
