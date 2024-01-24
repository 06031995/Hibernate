package com.manyTomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToMany {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory fectory = cfg.buildSessionFactory();
		Session session =  fectory.openSession();
		Transaction tx= session.beginTransaction();
		
		Employe emp = new Employe();
		Employe emp1 = new Employe();
		
		emp.setEmp_name("Rahul");
		emp1.setEmp_name("Divya");
		
		Project pro = new Project();
		Project pro1 = new Project();
		pro.setProject_name("HMIS");
		pro1.setProject_name("T2T");
		
		List<Employe> emplist = new ArrayList<Employe>();
		emplist.add(emp);
		emplist.add(emp1);
		
		
		List<Project> prolist = new ArrayList();
		prolist.add(pro);
		prolist.add(pro1);
		
		emp.setProject(prolist);
		pro.setEmp(emplist);
		
		/*session.save(emp);
        session.save(pro);
        session.save(emp1);
        session.save(pro1);
		*/
		tx.commit();
		
		Employe  em=session.get(Employe.class, 1);
		System.out.println(em.getEmp_name());
		//System.out.println(em.getProject());
		
		

	}

}
