package com.hibernet.HibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateExmaple {
	public static void main(String[] args) {
		 
		 SessionFactory s=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		 
		 
		 //create Student
		 
		 Student std = new Student();
		 std.setStudentName("Rahul");
		 std.setCity("Jalgaon");
		 std.setDeleted("Y");
		   
		     Session openSession = s.openSession();
		     Transaction tx = openSession.beginTransaction();
		     
		     openSession.save(std);
		     tx.commit();
		     openSession.close();
	}
	
	

}
