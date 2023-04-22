package com.example.demo;


class A
{
	void display()
	{
		System.out.println("hai");
	}
}
class B extends A
{
	void demo()
	{
		System.out.println("surya");
	}
}


public class Demo {
public static void main(String[] args) {
	A a=new A();
	a.display();
	a=new B();
	a.display();
	B b=new B();
	b.demo();
}
}
