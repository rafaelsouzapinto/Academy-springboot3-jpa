package com.backend.entities;

import java.time.Instant;
import java.util.Objects;

import com.backend.entities.enums.PaymentMethod;
import com.backend.entities.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
	private Integer paymentMethod;
	
	@OneToOne
	@MapsId
	private Enrollment enrollment;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	public Payment() {
	}
	public Payment(Long id, Instant paymentDate, Double paymentValue, PaymentStatus paymentStatus, PaymentMethod paymentMethod, Enrollment enrollment, Employee employee) {
		this.id = id;
		this.paymentDate = paymentDate;
		this.paymentValue = paymentValue;
		setPaymentStatus(paymentStatus);
		setPaymentMethod(paymentMethod);
		this.enrollment = enrollment;
		this.employee = employee;
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
	public PaymentStatus getPaymentStatus() {
		return PaymentStatus.valueOf(paymentStatus);
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		if (paymentStatus != null) {
			this.paymentStatus = paymentStatus.getCode();
		}
	}
	public PaymentMethod getPaymentMethod() {
		return PaymentMethod.valueOf(paymentMethod);
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		if (paymentMethod != null) {
			this.paymentMethod = paymentMethod.getCode();
		}
	}
	public Enrollment getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
