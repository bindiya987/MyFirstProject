package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	
	@ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH
        }, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
	        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> listOfRoles = new HashSet<>();

	public User(){
		
	}
	
	public User(String username, String password, Role... roles) {
		this.username = username;
        this.password = password;
        this.listOfRoles = new HashSet<>();
        for(int i = 0; i < roles.length;i++){
        	listOfRoles.add(roles[i]);
        }
    }
	
	public User(Role... roles){
		this.listOfRoles = new HashSet<>();
		for(int i = 0; i < roles.length;i++){
        	listOfRoles.add(roles[i]);
        }
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getListOfRoles() {
		return listOfRoles;
	}

	public void setListOfRoles(Set<Role> listOfRoles) {
		this.listOfRoles = listOfRoles;
	}
}
