package com.hibernet.HibernateProject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HqlPagination {

	public static void main(String[] args) {
		
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = f.openSession();
		
		Student std = new Student();
		 Query createQuery = s.createQuery(" from Student ");
		createQuery.setFirstResult(0);
		 createQuery.setMaxResults(3);
		 
		  List<Student> list = createQuery.list();
		std.setStlist(list);
		System.out.println(std);
		s.close();

	}

}
