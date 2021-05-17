package com.paypal.bfs.test.employeeserv.exceptions;

public class NoEmployeeFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3302286161901863050L;
	private final String errorCode;

	public NoEmployeeFoundException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;

	}

	public String getErrorCode() {
		return errorCode;
	}
}
