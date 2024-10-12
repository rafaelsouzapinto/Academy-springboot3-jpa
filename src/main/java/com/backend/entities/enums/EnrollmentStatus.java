package com.backend.entities.enums;

public enum EnrollmentStatus {
	ACTIVE(1),
	INACTIVE(2);
	
	private int code;
	
	private EnrollmentStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static EnrollmentStatus valueOf(int code) {
		for (EnrollmentStatus value : EnrollmentStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid PaymentStatus code");
	}
}
