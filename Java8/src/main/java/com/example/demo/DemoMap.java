package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student{
	Integer id;
	String name;
	Integer age;
	List<String> phoneno;
	Student(Integer id,String name,Integer age,List<String> phoneno){
		this.id = id;
		this.name =name;
		this.age = age;
		this.phoneno = phoneno;
	}
}

public class DemoMap {

	public static void main(String[] args) {
	
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "hello1", 28, Arrays.asList("1234","2345")));
		students.add(new Student(2, "hello2", 30, Arrays.asList("4321","5123")));
		students.add(new Student(3, "hello3", 20, Arrays.asList("1243434","25450")));
		students.add(new Student(4, "hello4", 37, Arrays.asList("1132234","2345341")));
		
		List<Integer> ages = students.stream().map(i -> i.age).collect(Collectors.toList());
		
		ages.stream().forEach(i -> System.out.println(i));
		
		List<List<String>> phonenos = students.stream().map(i -> i.phoneno).collect(Collectors.toList());
		
		phonenos.stream().forEach(i->System.out.println(i));
		
		List<String> phonenos2 = students.stream().flatMap(i -> i.phoneno.stream()).collect(Collectors.toList());
		
		System.out.println(phonenos2);
	}
	
}
