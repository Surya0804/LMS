package com.example.demo;

public class Euler3 {

	public static void main(String[] args) {
		long a=0;
		long c=0;
		long d=0;
		int aa=0;
for(long i=1;i<=100;i++)
{
	a=i*i;
	c+=a;
	d+=i;
	
}
aa=(int) Math.pow(d, 2);
System.out.println(aa-c);
	}

}
