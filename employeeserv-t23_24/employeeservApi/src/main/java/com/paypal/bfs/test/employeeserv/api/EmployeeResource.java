package com.paypal.bfs.test.employeeserv.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paypal.bfs.test.employeeserv.dto.CreateEmployeeResponseDTO;
import com.paypal.bfs.test.employeeserv.dto.GetEmployeeResponseDTO;
import com.paypal.bfs.test.employeeserv.model.Employee;

/**
 * Interface for employee resource operations.
 */
@RequestMapping("/v1/bfs/")
public interface EmployeeResource {

	/**
	 * Retrieves the {@link Employee} resource by id.
	 *
	 * @param id
	 *            employee id.
	 * @return {@link Employee} resource.
	 */
	@RequestMapping("employee/{id}")
	ResponseEntity<GetEmployeeResponseDTO> employeeGetById(@PathVariable("id") String id);

	@PostMapping(value = "employee", produces = { MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<CreateEmployeeResponseDTO> createEmployee(@RequestBody Employee employee);
	// ----------------------------------------------------------
	// TODO - add a new operation for creating employee resource.
	// ----------------------------------------------------------
}
