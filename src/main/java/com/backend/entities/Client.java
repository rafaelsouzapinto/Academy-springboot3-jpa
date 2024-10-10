package com.backend.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Instant accessionDate;
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name = "academy_plan_id")
	private AcademyPlan academyPlan;
	
	public Client() {
	}
	public Client(Long id, String name, Instant accessionDate, String phoneNumber, AcademyPlan academyPlan) {
		this.id = id;
		this.name = name;
		this.accessionDate = accessionDate;
		this.phoneNumber = phoneNumber;
		this.academyPlan = academyPlan;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Instant getAccessionDate() {
		return accessionDate;
	}
	public void setAccessionDate(Instant accessionDate) {
		this.accessionDate = accessionDate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public AcademyPlan getAcademyPlan() {
		return academyPlan;
	}
	public void setAcademyPlan(AcademyPlan academyPlan) {
		this.academyPlan = academyPlan;
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
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
}
