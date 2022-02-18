package com.demo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Controller {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Controller.class, args);
		
		System.out.println("welcome in boot....");
		Alien a = context.getBean(Alien.class);
		
		a.show();
		
		Alien a1 = context.getBean(Alien.class);
		
		a1.show();
		
	}
}
