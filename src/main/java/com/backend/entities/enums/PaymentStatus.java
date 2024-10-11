package com.backend.entities.enums;

public enum PaymentStatus {
	PAID(1),
	PENDING(2),
	CANCELED(3);

	private int code;
	
	private PaymentStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static PaymentStatus valueOf(int code) {
		for (PaymentStatus value : PaymentStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid PaymentStatus code");
	}
	
	
}
