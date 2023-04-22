package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class EmployeeImplementation {

	public static void main(String[] args) {
ArrayList<Employee> al=new ArrayList();
al.add(new Employee(1, "Surya", 22,"male","IT" , 2022, 10000.0));
al.add(new Employee(2, "Mahesh", 23,"male","security" , 2023, 20000.0));
al.add(new Employee(3, "Ravi", 24,"male","web" , 2000, 10000.0));
al.add(new Employee(4, "Prakash", 26,"male","finance" , 2026, 10000.0));
al.add(new Employee(5, "Josh", 27,"female","IT" , 2027, 10000.0));
al.add(new Employee(6, "Killer", 28,"female","HR" , 2028, 10000.0));
al.add(new Employee(7, "kick", 29,"female","admin" , 2029, 10000.0));
al.add(new Employee(8, "praveen", 30,"male","Learning" , 2100, 10000.0));

HashMap<String,Integer> hm=new HashMap();
HashSet<String> hs=new HashSet();
for(Employee e:al)
{
	String name=e.getGender();
	if(hm.containsKey(name))
	{
	hm.put(name, hm.get(name)+1);
	}
	else
	{
		hm.put(name, 1);
	}
}
for(Map.Entry<String, Integer>entry :hm.entrySet())
{
if(entry.getValue()>1)
{
	System.out.println(entry.getKey()+" "+entry.getValue());
}
}
for(Employee ee:al)
{
	hs.add(ee.getDepartment());
	
}
System.out.println(hs);
	}

}
