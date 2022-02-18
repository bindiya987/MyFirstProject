package com.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String sayHi(){
		return "Hii";
	}
	
	@RequestMapping("/alien")
	public List<Alien> getAllAlien(){
		return Arrays.asList(
				new Alien(1,"bindiya","java"),
				new Alien(2,"avani","boot")
				);
	}
}
