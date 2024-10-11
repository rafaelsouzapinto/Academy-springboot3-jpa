package com.backend.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant paymentDate;
	private Double paymentValue;
	private Integer paymentStatus;
	
	@OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
	private Enrollment enrollment;
	
	public Payment() {
	}
	public Payment(Long id, Instant paymentDate, Double paymentValue, Integer paymentStatus) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.paymentValue = paymentValue;
		this.paymentStatus = paymentStatus;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Instant paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Double getPaymentValue() {
		return paymentValue;
	}
	public void setPaymentValue(Double paymentValue) {
		this.paymentValue = paymentValue;
	}
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
}
