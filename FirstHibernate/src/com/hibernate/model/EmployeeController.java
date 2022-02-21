package com.hibernate.model;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeController {

	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		List<Employee> list = session.createQuery("from Employee").list();
		
		for(Employee e : list){
			System.out.println(e.getId() +" "+ e.getType() +" "+ e.getName());
		}
		
	}
}
