package com.example.demo;

import java.util.*;
public class DuplicateChar 
{
	public static void main(String[] args) {
		String str="wnbckwbchwebchwbehweb hai";
		String str2="";
		char a[]=str.toCharArray();
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					char temp=a[j];
					a[j]=a[i];
					a[i]=temp;
				}
			}
		}
		for(int i=0;i<a.length;i++)
		{
			str2+=a[i];
			
		}
		System.out.println(str2);
	
		}
	}
	
	


