package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entities.AcademyPlan;
import com.backend.services.AcademyPlanService;

@RestController
@RequestMapping(value = "/plans")
public class AcademyPlanController {
	
	@Autowired
	private AcademyPlanService service;
	
	@GetMapping
	public ResponseEntity<List<AcademyPlan>> findAll() {
		List<AcademyPlan> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
 }
