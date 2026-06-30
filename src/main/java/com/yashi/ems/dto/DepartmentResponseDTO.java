package com.yashi.ems.dto;

public class DepartmentResponseDTO {
	private Integer id;
	private String departmentName;
	
	public DepartmentResponseDTO() {}
	
	public Integer getId() {
		return id;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName=departmentName;
	}
	
	public String toString() {
		return "DepartmentResponseDTO: {"+
				" Id: "+id+" DepartmentName: "+departmentName+" }";
	}
	
	
}
