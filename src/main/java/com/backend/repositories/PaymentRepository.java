package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
