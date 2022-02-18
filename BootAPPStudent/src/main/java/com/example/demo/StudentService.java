package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public void addStudent(Student student){
		System.out.println(student);
		studentRepository.save(student);
	}
	
	public Student getStudent(Integer id){
		
		Student student = studentRepository.findById(id).get();
		return student;
	}
}
