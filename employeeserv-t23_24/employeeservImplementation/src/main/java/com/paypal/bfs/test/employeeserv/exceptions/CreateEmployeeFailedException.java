package com.paypal.bfs.test.employeeserv.exceptions;

public class CreateEmployeeFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8369556143199339264L;
	private final String errorCode;

	public CreateEmployeeFailedException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;

	}

	public String getErrorCode() {
		return errorCode;
	}
}
