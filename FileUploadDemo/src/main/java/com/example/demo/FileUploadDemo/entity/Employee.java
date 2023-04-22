package com.example.demo.FileUploadDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "emp_table")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int empId;
	@Column
private String name;
	@Lob
private byte[] image;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Employee(int empId, String name, byte[] image) {
		super();
		this.empId = empId;
		this.name = name;
		this.image = image;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
