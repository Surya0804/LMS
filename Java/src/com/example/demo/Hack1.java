package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", cgpa=" + cgpa + "]";
	}
	
}
class Hack1 implements Comparator<Student>
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		ArrayList<Student> al=new ArrayList();
Hack1 h1=new Hack1();
		for(int i=0;i<size;i++)
		{
			int ID=sc.nextInt();
			String Name=sc.next();
			double CGPA=sc.nextDouble();
		al.add(new Student(ID, Name, CGPA));
		
	}
		Collections.sort(al,h1);
		for(Student st:al)
		{
			System.out.println(st.getFname());
		}
	}

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getFname().compareTo(o2.getFname());
	}
}