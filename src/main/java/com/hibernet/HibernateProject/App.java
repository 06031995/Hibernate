package com.hibernet.HibernateProject;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("hii");
    	Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	//save Student
    	String date_s = " 2011-01-18 00:00:00.0"; 
    	Student std = new Student();
    	std.setStudentName("sdfs");
    	std.setCity("Jalgaon");
    	std.setDeleted("Y");
    	std.setCreatedDateTime(date_s);
    	std.setCreateddate(new Date());
    	session.save(std);
    	
    	tx.commit();
    	session.close();
    	
    }
}
