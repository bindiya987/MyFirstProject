package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication/*(scanBasePackages = { "com.example.service"})*/
/*@ComponentScan(basePackages = {"com.example.service"})*/
public class MyAppStudentApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	public static void main(String[] args) {
		SpringApplication.run(MyAppStudentApplication.class, args);
	}

	private static User createUser(String[] user) { 
		String username = user[0];  
		String password = user[1]; 
		return new User(username, password); 
	}

	private static Role createRole(String[] role) { 
		int id = Integer.parseInt(role[0]);
		String name = role[1];   
		return new Role(id, name); 
	}
	
	private static List<User> readUsersFromCSV(String fileName) throws IOException {
		
		List<User> users = new ArrayList<>(); 
		
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			 String line = br.readLine(); 
			 
			 while (line != null) {
				 String[] attributes = line.split(","); 
				 User user = createUser(attributes); 
				 users.add(user); 
				 line = br.readLine();
			 }
		}	
		return users;
	}
	
	private static List<Role> readRolesFromCSV(String fileName) throws IOException {
		
		List<Role> roles = new ArrayList<>(); 
		
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			 String line = br.readLine(); 
			 
			 while (line != null) {
				 String[] attributes = line.split(","); 
				 Role role = createRole(attributes); 
				 roles.add(role); 
				 line = br.readLine();
			 }
		}	
		return roles;
	}
	
	public void run(String... args) throws Exception {
		
		List<User> users = readUsersFromCSV("D:\\user.csv");
		List<Role> roles = readRolesFromCSV("D:\\role.csv");
		
		roles.stream().forEach(role -> roleService.saveRole(role));
		
		users.stream().forEach(user -> {
			user.getListOfRoles().add(roleService.findByName("ROLE_ADMIN"));
			userService.saveUser(user);
		});
	}
}

