package com.yashi.ems.dto;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequestDTO {
	@NotBlank(message="department name is required")
	private String departmentName;
	
	public DepartmentRequestDTO() {}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName=departmentName;
	}
	
	public String toString() {
		return "DepartmentREquestDTO :{ "+
				"Department Name: "+departmentName+" }";
	}
}