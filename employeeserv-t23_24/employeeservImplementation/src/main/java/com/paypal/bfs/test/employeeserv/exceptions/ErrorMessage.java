package com.paypal.bfs.test.employeeserv.exceptions;

public class ErrorMessage {
	private String message;
	private String code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public ErrorMessage(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
