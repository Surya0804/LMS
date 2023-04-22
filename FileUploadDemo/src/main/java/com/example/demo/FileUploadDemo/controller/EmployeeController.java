package com.example.demo.FileUploadDemo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.FileUploadDemo.entity.Employee;
import com.example.demo.FileUploadDemo.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {
	@Autowired
	private EmployeeRepository empRepo;
	@PostMapping("/images")
	public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file,
			@RequestParam("name") String name) throws Exception
	{
		Employee emp=new Employee();
		emp.setName(name);
		emp.setImage(file.getBytes());
		empRepo.save(emp);
		return ResponseEntity.ok(emp);
	}
	@GetMapping("/getimages")
	public List<Employee> getData()
	{
		 return empRepo.findAll();
	}

}
