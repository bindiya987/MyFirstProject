package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/")
	public String test(){
		System.out.println("hii");
		return "home";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "welcome";
	}
}
