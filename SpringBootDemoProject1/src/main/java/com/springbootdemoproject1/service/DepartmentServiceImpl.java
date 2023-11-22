package com.springbootdemoproject1.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemoproject1.entity.Department;
import com.springbootdemoproject1.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	//save operation
	@Override
	public Department saveDepartment(Department department) {
		return this.departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		
		return this.departmentRepository.findAll();
	}

	@Override
	public Department updateDepartment(Department updateDepartment, int departmentId) {
		Optional<Department> optionalDepartment=this.departmentRepository.findById(departmentId);
		
		if(optionalDepartment.isPresent()) {
			Department existingDepartment=optionalDepartment.get();
			existingDepartment.setDepartmentName(updateDepartment.getDepartmentName());
			existingDepartment.setDepartmentAddress(updateDepartment.getDepartmentAddress());
			existingDepartment.setDepartmentCode(updateDepartment.getDepartmentCode());
			
			return this.departmentRepository.save(existingDepartment);
		}
		else {
			return null;
		}
	}

	@Override
	public boolean deleteDepartment(int departmentId) {
		if(this.departmentRepository.existsById(departmentId)) {
			this.departmentRepository.deleteById(departmentId);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		return this.departmentRepository.findByDepartmentName(departmentName);
	}
	
}
