package com.springbootdemoproject1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemoproject1.entity.Department;
import com.springbootdemoproject1.service.DepartmentService;

import lombok.Getter;

//Annotations
@RestController
//Class
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	//save operation
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
		//Department departmentSave=departmentService.saveDepartment(department);
		Department departmentSave=this.departmentService.saveDepartment(department);
		return departmentSave;
	}
	
	//read operation
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		return this.departmentService.fetchDepartmentList();
	}
	
	//update operation
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@RequestBody Department updateDepartment,@PathVariable("id") int departmentId) {
		return this.departmentService.updateDepartment(updateDepartment,departmentId);
	}
	
	//delete operation
	@DeleteMapping("/departments/{id}")
	public boolean deleteDepartment(@PathVariable("id") int departmentId) {
		boolean deleted= this.departmentService.deleteDepartment(departmentId);
		return deleted;
	}
	
	//read operation
	@GetMapping("/departments/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		return this.departmentService.fetchDepartmentByName(departmentName);
	}
}
