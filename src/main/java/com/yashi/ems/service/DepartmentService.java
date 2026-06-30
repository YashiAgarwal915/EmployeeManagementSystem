package com.yashi.ems.service;

import java.util.List;

import com.yashi.ems.dto.DepartmentRequestDTO;
import com.yashi.ems.dto.DepartmentResponseDTO;
import com.yashi.ems.entity.Department;

public interface DepartmentService {
	DepartmentResponseDTO saveDepartment(DepartmentRequestDTO departmentRequestDTO);
	List<DepartmentResponseDTO> getAllDepartments();
	DepartmentResponseDTO getDepartmentById(Integer id);
	DepartmentResponseDTO updateDepartment(Integer id, DepartmentRequestDTO departmentRequestDTO);
	void deleteDepartment(Integer id);
}
