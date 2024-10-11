package com.backend.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant start;
	private Instant end;
	private String status;
	
	public Enrollment() {
	}
	public Enrollment(Long id, Instant start, Instant end, String status) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getStart() {
		return start;
	}
	public void setStart(Instant start) {
		this.start = start;
	}
	public Instant getEnd() {
		return end;
	}
	public void setEnd(Instant end) {
		this.end = end;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		Enrollment other = (Enrollment) obj;
		return Objects.equals(id, other.id);
	}
}
