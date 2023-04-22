package com.example.demo;
import java.util.*;
public class Euler2 {

	public static void main(String[] args) {
int a=0;
int b=1;
int c=1;
int d=0;
System.out.print(a+" "+b+" ");
for(int i=1;i<=4000000;i++)
{
	if(c%2==0)
	{
		d+=c;
	}
	if(c>4000000)
	{
		break;
	}
	a=b;
	b=c;
	System.out.print(c+" ");
	c=a+b;
}
System.out.println(d);
	}

}
