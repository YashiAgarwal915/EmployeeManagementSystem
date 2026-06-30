package com.yashi.ems.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yashi.ems.dto.DepartmentRequestDTO;
import com.yashi.ems.dto.DepartmentResponseDTO;
import com.yashi.ems.entity.Department;

public interface DepartmentService {
	DepartmentResponseDTO saveDepartment(DepartmentRequestDTO departmentRequestDTO);
	Page<DepartmentResponseDTO> getAllDepartments(int page,int size,String sortBy,String direction);
	DepartmentResponseDTO getDepartmentById(Integer id);
	DepartmentResponseDTO updateDepartment(Integer id, DepartmentRequestDTO departmentRequestDTO);
	void deleteDepartment(Integer id);
	List<DepartmentResponseDTO> searchDepartment(String keyword);
}
