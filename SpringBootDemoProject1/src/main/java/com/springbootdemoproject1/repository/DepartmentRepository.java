package com.springbootdemoproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdemoproject1.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{

}
