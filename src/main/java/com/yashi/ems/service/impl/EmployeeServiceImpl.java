package com.yashi.ems.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yashi.ems.dto.EmployeeRequestDTO;
import com.yashi.ems.dto.EmployeeResponseDTO;
import com.yashi.ems.entity.Department;
import com.yashi.ems.entity.Employee;
import com.yashi.ems.exception.ResourceNotFoundException;
import com.yashi.ems.repository.DepartmentRepository;
import com.yashi.ems.repository.EmployeeRepository;
import com.yashi.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository) {
		this.employeeRepository=employeeRepository;
		this.departmentRepository=departmentRepository;
	}
	
	private Employee mapToEntity(EmployeeRequestDTO dto) {
		Employee employee=new Employee();
		employee.setName(dto.getName());
		employee.setEmail(dto.getEmail());
		employee.setSalary(dto.getSalary());
		Department department=departmentRepository.findById(dto.getDepartmentId()).orElseThrow(()->
								new ResourceNotFoundException("Department not found with id: "+dto.getDepartmentId()));
		employee.setDepartment(department);
		return employee;
	}
	
	public EmployeeResponseDTO mapToResponseDTO(Employee employee) {
		EmployeeResponseDTO dto=new EmployeeResponseDTO();
		dto.setId(employee.getId());
		dto.setName(employee.getName());
		dto.setEmail(employee.getEmail());
		dto.setSalary(employee.getSalary());
		dto.setDepartmentName(employee.getDepartment().getDepartmentName());
		return dto;
		}
	
	@Override
	public Page<EmployeeResponseDTO> getAllEmployees(int page,int size,String sortBy,String direction){
		Sort sort=direction.equalsIgnoreCase("desc")?Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
		Pageable pageable=PageRequest.of(page, size,sort);
		Page<Employee> employeePage=employeeRepository.findAll(pageable);
		return employeePage.map(this::mapToResponseDTO);

	}

	@Override
	public EmployeeResponseDTO getEmployeeById(Integer id) {
		Employee employee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: "+id));
		return mapToResponseDTO(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public EmployeeResponseDTO saveEmployee(EmployeeRequestDTO employeeRequestDTO) {
		Employee employee=mapToEntity(employeeRequestDTO);
		Employee savedEmployee=employeeRepository.save(employee);
		return mapToResponseDTO(savedEmployee);
	}

	@Override
	public EmployeeResponseDTO updateEmployee(Integer id, EmployeeRequestDTO employeeRequestDTO) {
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with id: "+id));
		existingEmployee.setName(employeeRequestDTO.getName());
		existingEmployee.setEmail(employeeRequestDTO.getEmail());
		existingEmployee.setSalary(employeeRequestDTO.getSalary());
		
		Department department=departmentRepository.findById(employeeRequestDTO.getDepartmentId()).orElseThrow(()->new ResourceNotFoundException("Department not found with id: "+employeeRequestDTO.getDepartmentId()));
		existingEmployee.setDepartment(department);
		Employee updatedEmployee=employeeRepository.save(existingEmployee);
		return mapToResponseDTO(updatedEmployee);
	}
}
