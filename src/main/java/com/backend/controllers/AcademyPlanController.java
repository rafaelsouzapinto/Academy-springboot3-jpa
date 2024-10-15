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

import com.backend.entities.AcademyPlan;
import com.backend.services.AcademyPlanService;

@RestController
@RequestMapping("/plans")
public class AcademyPlanController {
	
	@Autowired
	private AcademyPlanService service;
	
	@GetMapping
	public ResponseEntity<List<AcademyPlan>> findAll() {
		List<AcademyPlan> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AcademyPlan> findById(@PathVariable Long id) {
		AcademyPlan plan = service.findById(id);
		return ResponseEntity.ok().body(plan);
	}
	
	@PostMapping
	public ResponseEntity<AcademyPlan> insert(@RequestBody AcademyPlan obj) {
		AcademyPlan plan = service.insert(obj);
		return ResponseEntity.ok().body(plan);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AcademyPlan> update(@RequestBody AcademyPlan obj, @PathVariable Long id) {
		AcademyPlan plan = service.update(obj, id);
		return ResponseEntity.ok().body(plan);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
 }
