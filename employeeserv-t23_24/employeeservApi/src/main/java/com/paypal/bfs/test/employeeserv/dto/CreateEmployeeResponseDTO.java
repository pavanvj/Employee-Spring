package com.paypal.bfs.test.employeeserv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.paypal.bfs.test.employeeserv.exceptions.ErrorMessage;

@JsonInclude(Include.NON_EMPTY)
public class CreateEmployeeResponseDTO {
	private ErrorMessage error;

	public ErrorMessage getError() {
		return error;
	}

	public void setError(ErrorMessage error) {
		this.error = error;
	}
}
