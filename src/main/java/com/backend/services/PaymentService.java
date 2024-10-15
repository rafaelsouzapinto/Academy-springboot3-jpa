package com.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.backend.entities.Payment;
import com.backend.repositories.PaymentRepository;
import com.backend.services.exceptions.DatabaseException;
import com.backend.services.exceptions.ResourceNotFoundException;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository repository;
	
	public List<Payment> findAll() {
		return repository.findAll();
	}
	
	public Payment findById(Long id) {
		Optional<Payment> payment = repository.findById(id);
		return payment.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Payment insert(Payment obj) {
		return repository.save(obj);
	}
	
	public Payment update (Payment obj, Long id) {
		try {
			if (!repository.existsById(id)) throw new ResourceNotFoundException(id);
			Payment payment = findById(id);
			payment.setEnrollment(obj.getEnrollment());
			payment.setPaymentDate(obj.getPaymentDate());
			payment.setPaymentMethod(obj.getPaymentMethod());
			payment.setPaymentStatus(obj.getPaymentStatus());
			payment.setPaymentValue(obj.getPaymentValue());
			return repository.save(payment);	
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void delete (Long id) {
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
