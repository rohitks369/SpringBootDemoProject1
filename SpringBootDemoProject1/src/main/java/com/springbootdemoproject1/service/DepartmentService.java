package com.springbootdemoproject1.service;

import java.util.List;

import com.springbootdemoproject1.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);
	
	List<Department> fetchDepartmentList();
	
	Department updateDepartment(Department updateDepartment, int departmentId);

	boolean deleteDepartment(int departmentId);

	Department fetchDepartmentByName(String departmentName);
}
