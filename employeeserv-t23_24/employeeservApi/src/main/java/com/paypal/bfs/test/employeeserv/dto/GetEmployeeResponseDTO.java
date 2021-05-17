package com.paypal.bfs.test.employeeserv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.paypal.bfs.test.employeeserv.exceptions.ErrorMessage;
import com.paypal.bfs.test.employeeserv.model.Employee;

@JsonInclude(Include.NON_EMPTY)
public class GetEmployeeResponseDTO {
	private ErrorMessage error;

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ErrorMessage getError() {
		return error;
	}

	public void setError(ErrorMessage error) {
		this.error = error;
	}
}
