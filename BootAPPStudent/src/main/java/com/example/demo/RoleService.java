package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Role;
import com.example.demo.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role findByName(String name){
		return roleRepository.findByName(name);
	}
	
	public void saveRole(Role role){
		roleRepository.save(role);
	}
}
