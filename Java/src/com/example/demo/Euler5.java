package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class Euler5 {

	public static void main(String[] args) {
		long num=600851475143l;
long b=0;
	
		for(long i=2;i<=num;i++)
		{
			long c=0;
          
			for(long j=2;j<i;j++)
			{
				if(i%j==0)
				{
					c++;
				}
			}
			if(c==0)
			{
				if(num%i==0)
				{
	          System.out.println(i);
	          
	             
				}
			}
		
	
		}

       


	}

}
