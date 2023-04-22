package com.example.demo;
import java.util.*;
public class Euler {

	public static void main(String[] args) {
int num=1000;
int c=0;
for(int i=1;i<num;i++)
{
	if(i%3==0||i%5==0)
	{
		c+=i;
	}
}
System.out.println(c);
	}

}
