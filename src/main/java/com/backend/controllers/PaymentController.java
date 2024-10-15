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

import com.backend.entities.Payment;
import com.backend.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping
	public ResponseEntity<List<Payment>> findAll() {
		List<Payment> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Payment> findById(@PathVariable Long id) {
		Payment payment = service.findById(id);
		return ResponseEntity.ok().body(payment);
	}
	
	@PostMapping
	public ResponseEntity<Payment> insert(@RequestBody Payment obj) {
		Payment payment = service.insert(obj);
		return ResponseEntity.ok().body(payment);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Payment> update (@RequestBody Payment obj, @PathVariable Long id) {
		Payment payment = service.update(obj, id);
		return ResponseEntity.ok().body(payment);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
