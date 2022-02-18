package com.example.demo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private StudentService studentService;
	
	 @Autowired
	 private AuthenticationManager authenticationManager;
	
	 @PostMapping("/signin")
	 public ResponseEntity<String> authenticateUser(@RequestBody User user){
		 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				 user.getUsername(),user.getPassword()));

	     SecurityContextHolder.getContext().setAuthentication(authentication);
	     return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
	 }
	
	@PostMapping("/student")
	public void saveStudent(@RequestBody Student student){
		studentService.addStudent(student);
		User user = new User();
		user.setUsername(student.getUsername());
		user.setPassword(student.getPassword());
		user.getListOfRoles().add(roleService.findByName("ROLE_USER"));
		
		userService.saveUser(user);
	}
	
	@RequestMapping("/student/{id}")
	public Student getStudent(@PathVariable Integer id){
		return studentService.getStudent(id);
	}
}
