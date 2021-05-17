package com.paypal.bfs.test.employeeserv.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.dto.CreateEmployeeResponseDTO;
import com.paypal.bfs.test.employeeserv.dto.GetEmployeeResponseDTO;
import com.paypal.bfs.test.employeeserv.exceptions.CreateEmployeeFailedException;
import com.paypal.bfs.test.employeeserv.exceptions.ErrorMessage;
import com.paypal.bfs.test.employeeserv.exceptions.NoEmployeeFoundException;
import com.paypal.bfs.test.employeeserv.model.Employee;
import com.paypal.bfs.test.employeeserv.repo.IEmployeeRepo;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {
	@Autowired
	private IEmployeeRepo employeeRepository;

	@Override
	public ResponseEntity<GetEmployeeResponseDTO> employeeGetById(String id) {
		Optional<Employee> employee = employeeRepository.findById(Integer.parseInt(id));
		try {
			return checkIfEmployeeExists(employee);
		} catch (NoEmployeeFoundException invalidEmployeeIDException) {
			GetEmployeeResponseDTO getEmployeeResponseDTO = new GetEmployeeResponseDTO();
			getEmployeeResponseDTO.setError(new ErrorMessage(invalidEmployeeIDException.getMessage(), invalidEmployeeIDException.getErrorCode()));
			return new ResponseEntity<>(getEmployeeResponseDTO, HttpStatus.BAD_REQUEST);
		}
	}

	private ResponseEntity<GetEmployeeResponseDTO> checkIfEmployeeExists(Optional<Employee> employee) throws NoEmployeeFoundException {
		if (employee.isPresent()) {
			GetEmployeeResponseDTO getEmployeeResponseDTO = new GetEmployeeResponseDTO();
			getEmployeeResponseDTO.setEmployee(employee.get());
			return new ResponseEntity<>(getEmployeeResponseDTO, HttpStatus.OK);
		}

		else
			throw new NoEmployeeFoundException("Invalid Employee ID", "INV_EMPID");
	}

	@Override
	public ResponseEntity<CreateEmployeeResponseDTO> createEmployee(Employee employeeRequestDTO) {
		try {
			checkIfEmployeeExist(employeeRequestDTO);
		} catch (CreateEmployeeFailedException createEmpFailedException) {
			CreateEmployeeResponseDTO createEmployeeResponseDTO = new CreateEmployeeResponseDTO();
			createEmployeeResponseDTO.setError(new ErrorMessage(createEmpFailedException.getMessage(), createEmpFailedException.getErrorCode()));
			return new ResponseEntity<>(createEmployeeResponseDTO, HttpStatus.BAD_REQUEST);
		}
		Employee employeeToSave = new Employee();
		employeeToSave.setId(employeeRequestDTO.getId());
		employeeToSave.setFirstName(employeeRequestDTO.getFirstName());
		employeeToSave.setLastName(employeeRequestDTO.getLastName());

		try {
			if (!isValidFormat("dd/MM/yyyy", employeeRequestDTO.getDateOfBirth()))
				return populateInvalidDateResponse();
			else
				employeeToSave.setDateOfBirth(employeeRequestDTO.getDateOfBirth());
		} catch (ParseException e) {
			return populateInvalidDateResponse();
		}

		employeeToSave.setAddress(employeeRequestDTO.getAddress());
		employeeRepository.save(employeeToSave);

		return new ResponseEntity<>(new CreateEmployeeResponseDTO(), HttpStatus.CREATED);
	}

	private void checkIfEmployeeExist(Employee employeeRequestDTO) throws CreateEmployeeFailedException {
		Optional<Employee> employee = employeeRepository.findById(employeeRequestDTO.getId());
		if (employee.isPresent()) {
			throw new CreateEmployeeFailedException("Employee ID: " + employeeRequestDTO.getId() + " already exists", "EMP_EXISTS");
		}
	}

	private ResponseEntity<CreateEmployeeResponseDTO> populateInvalidDateResponse() {
		CreateEmployeeResponseDTO createEmployeeResponseDTO = new CreateEmployeeResponseDTO();
		createEmployeeResponseDTO.setError(new ErrorMessage("Invalid Date Format. Allowed Date Format: dd/MM/yyyy", "INV_DOB"));
		return new ResponseEntity<>(createEmployeeResponseDTO, HttpStatus.BAD_REQUEST);
	}

	public static boolean isValidFormat(String format, String value) throws ParseException {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		date = sdf.parse(value);
		if (!value.equals(sdf.format(date))) {
			date = null;
		}

		return date != null;
	}

}
