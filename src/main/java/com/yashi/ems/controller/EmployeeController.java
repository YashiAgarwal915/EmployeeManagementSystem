package com.yashi.ems.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yashi.ems.dto.EmployeeRequestDTO;
import com.yashi.ems.dto.EmployeeResponseDTO;
import com.yashi.ems.entity.Employee;
import com.yashi.ems.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	public EmployeeController(EmployeeService empService) {
		this.employeeService=empService;
	}
	
	@PostMapping
	public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
		EmployeeResponseDTO savedEmp= employeeService.saveEmployee(employeeRequestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEmp);
	}
	
	@GetMapping
	public ResponseEntity<Page<EmployeeResponseDTO>> getEmployees(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="5") int size,
			@RequestParam(defaultValue="id") String sortBy,@RequestParam(defaultValue="asc") String direction) {
		Page<EmployeeResponseDTO> employeePage= employeeService.getAllEmployees(page, size,sortBy,direction);
		return ResponseEntity.status(HttpStatus.OK).body(employeePage);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable("id") Integer id) {
		EmployeeResponseDTO emp= employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateEmployee(@Valid @PathVariable("id") Integer id, @RequestBody EmployeeRequestDTO employeeRequestDTO) {
		EmployeeResponseDTO  updatedEmp=employeeService.updateEmployee(id, employeeRequestDTO);
		return ResponseEntity.status(HttpStatus.OK).body(updatedEmp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEmployee(@Valid @PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<EmployeeResponseDTO>> searchEmployeeByName(@RequestParam String name){
		List<EmployeeResponseDTO> employees=employeeService.searchEmployeesByName(name);
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/email")
	public ResponseEntity<EmployeeResponseDTO> searchEmployeeByEmail(@RequestParam String email){
		EmployeeResponseDTO employee=employeeService.searchEmployeeByEmail(email);
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/departmentName")
	public ResponseEntity<List<EmployeeResponseDTO>> searchEmployeeByDepartmentName(@RequestParam String departmentName){
		List<EmployeeResponseDTO> employees=employeeService.searchEmployeesByDepartmentName(departmentName);
		return ResponseEntity.ok(employees);
	}

}
