package com.paypal.bfs.test.employeeserv.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@Entity
@JsonInclude(Include.NON_DEFAULT)
public class Employee {
	/**
	 * employee id
	 * 
	 */
	@Id
	@JsonProperty("id")
	@JsonPropertyDescription("employee id")
	private Integer id;
	/**
	 * first name (Required)
	 * 
	 */
	@JsonProperty("first_name")
	@JsonPropertyDescription("first name")
	private String firstName;
	/**
	 * last name (Required)
	 * 
	 */
	@JsonProperty("last_name")
	@JsonPropertyDescription("last name")
	private String lastName;

	@JsonProperty("date_of_birth")
	@JsonPropertyDescription("date of birth")
	private String dateOfBirth;

	@OneToOne(cascade = CascadeType.ALL, targetEntity = Address.class, mappedBy = "employee", fetch = FetchType.EAGER)
	private Address address;

	@JsonProperty("date_of_birth")
	@JsonPropertyDescription("date of birth")
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	@JsonProperty("date_of_birth")
	@JsonPropertyDescription("date of birth")
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * employee id
	 * 
	 */
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	/**
	 * employee id
	 * 
	 */
	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * first name (Required)
	 * 
	 */
	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * first name (Required)
	 * 
	 */
	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * last name (Required)
	 * 
	 */
	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	/**
	 * last name (Required)
	 * 
	 */
	@JsonProperty("last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Employee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("firstName");
		sb.append('=');
		sb.append(((this.firstName == null) ? "<null>" : this.firstName));
		sb.append(',');
		sb.append("lastName");
		sb.append('=');
		sb.append(((this.lastName == null) ? "<null>" : this.lastName));
		sb.append(',');
		sb.append("dateOfBirth");
		sb.append('=');
		sb.append(((this.dateOfBirth == null) ? "<null>" : this.dateOfBirth));
		sb.append(',');
		sb.append("address");
		sb.append('=');
		sb.append(((this.address == null) ? "<null>" : this.address));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}
}
