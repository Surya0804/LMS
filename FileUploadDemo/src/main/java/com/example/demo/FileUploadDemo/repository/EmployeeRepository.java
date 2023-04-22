package com.example.demo.FileUploadDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.FileUploadDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
