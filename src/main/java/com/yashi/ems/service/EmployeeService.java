package com.yashi.ems.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yashi.ems.dto.EmployeeRequestDTO;
import com.yashi.ems.dto.EmployeeResponseDTO;
import com.yashi.ems.entity.Employee;

public interface EmployeeService {
	
	EmployeeResponseDTO saveEmployee(EmployeeRequestDTO employeeRequestDTO);
	Page<EmployeeResponseDTO> getAllEmployees(int page,int size,String sortBy,String direction);
	EmployeeResponseDTO getEmployeeById(Integer id);
	EmployeeResponseDTO updateEmployee(Integer id, EmployeeRequestDTO employeeRequestDTO);
	void deleteEmployee(Integer id);

}
