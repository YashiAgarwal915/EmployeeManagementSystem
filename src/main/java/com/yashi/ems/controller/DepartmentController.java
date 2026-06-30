package com.yashi.ems.controller;

import java.util.List;

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

import com.yashi.ems.dto.DepartmentRequestDTO;
import com.yashi.ems.dto.DepartmentResponseDTO;
import com.yashi.ems.entity.Department;
import com.yashi.ems.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	private final DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService=departmentService;
	}
	
	@PostMapping
	public ResponseEntity<DepartmentResponseDTO>createDepartment(@Valid @RequestBody DepartmentRequestDTO departmentRequestDTO){
		DepartmentResponseDTO savedDepartment=departmentService.saveDepartment(departmentRequestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments(){
		List<DepartmentResponseDTO> list= departmentService.getAllDepartments();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable("id") Integer id) {
		DepartmentResponseDTO dept = departmentService.getDepartmentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(dept);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DepartmentResponseDTO> updateDepartment(@Valid @PathVariable("id") Integer id,@RequestBody DepartmentRequestDTO departmentRequestDTO) {
		DepartmentResponseDTO updatedDept= departmentService.updateDepartment(id, departmentRequestDTO);
		return ResponseEntity.status(HttpStatus.OK).body(updatedDept);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteDepartment(@PathVariable("id") Integer id) {
		departmentService.deleteDepartment(id);
		return ResponseEntity.noContent().build();
	}
}
