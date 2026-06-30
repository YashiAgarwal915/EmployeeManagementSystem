package com.yashi.ems.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.yashi.ems.dto.DepartmentRequestDTO;
import com.yashi.ems.dto.DepartmentResponseDTO;
import com.yashi.ems.entity.Department;
import com.yashi.ems.exception.ResourceNotFoundException;
import com.yashi.ems.repository.DepartmentRepository;
import com.yashi.ems.service.DepartmentService;

import jakarta.validation.Valid;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentRepository departmentRepository;
	public DepartmentServiceImpl(DepartmentRepository departmentRepository){
		this.departmentRepository=departmentRepository;
	}
	public Department mapToEntity(DepartmentRequestDTO departmentRequestDTO) {
		Department department=new Department();
		department.setDepartmentName(departmentRequestDTO.getDepartmentName());
		return department;
	}
	
	private DepartmentResponseDTO mapToResponseDTO(Department department) {
		DepartmentResponseDTO departmentResponseDTO=new DepartmentResponseDTO();
		departmentResponseDTO.setId(department.getId());
		departmentResponseDTO.setDepartmentName(department.getDepartmentName());
		return departmentResponseDTO;
	}
	@Override
	public DepartmentResponseDTO saveDepartment(DepartmentRequestDTO departmentRequestDTO) {
		Department department=mapToEntity(departmentRequestDTO);
		Department savedDepartment=departmentRepository.save(department);
		return mapToResponseDTO(savedDepartment);
	}
	@Override
	public Page<DepartmentResponseDTO> getAllDepartments(int page,int size,String sortBy,String direction) {
		Sort sort=direction.equalsIgnoreCase("desc")
				? Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
		Pageable pageable=PageRequest.of(page, size,sort);
		Page<Department> deptPage=departmentRepository.findAll(pageable);
		return deptPage.map(this::mapToResponseDTO);
	}
	@Override
	public DepartmentResponseDTO getDepartmentById(Integer id) {
		Department department =departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException ("Department not found with id: "+id));
		return mapToResponseDTO(department);
	}
	@Override
	public DepartmentResponseDTO updateDepartment(Integer id, DepartmentRequestDTO departmentRequestDTO) {
		Department existingDepartment=departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Department not found with id: "+id));
			existingDepartment.setDepartmentName(departmentRequestDTO.getDepartmentName());
			Department updatedDepartment=departmentRepository.save(existingDepartment);
			return mapToResponseDTO(updatedDepartment);
		}

	@Override
	public void deleteDepartment(@Valid @PathVariable("id") Integer id) {
		departmentRepository.deleteById(id);
		
	}
	@Override
	public List<DepartmentResponseDTO> searchDepartment(String keyword) {
		return departmentRepository.searchDepartment(keyword).stream().map(this::mapToResponseDTO).toList();
	}
}
