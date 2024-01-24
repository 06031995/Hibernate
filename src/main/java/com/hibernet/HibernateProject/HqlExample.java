package com.hibernet.HibernateProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.onetwomany.Question;

public class HqlExample {

	public static void main(String[] args) {

		List<Student> stdlist = new ArrayList<Student>();
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = f.openSession();
        Transaction tx = s.beginTransaction();
		Student st = new Student();
		String query = "from Student where stdId=:stdId and deleted=:deleted";
		Query createQuery = s.createQuery(query);
		createQuery.setParameter("stdId", 1);
		createQuery.setParameter("deleted", "Y");
		List<Student> list = createQuery.list();
		st.setStlist(list);	
		System.out.println(st);
		
		//------------------------------------------------------//
		
		/* String query1 ="delete from Student where stdId=:stdId";
		 Query createQuery2 = s.createQuery(query1);
		 createQuery2.setParameter("stdId", 2);
		  int executeUpdate = createQuery2.executeUpdate();
		  System.out.println(executeUpdate);*/
		
		  String query1 ="update from Student set studentName=:name where stdId=:stdId";
		  Query createQuery2 = s.createQuery(query1);
		  createQuery2.setParameter("name", "Divya");
		  createQuery2.setParameter("stdId", 1);
		 
		  int executeUpdate = createQuery2.executeUpdate();
		  System.out.println(executeUpdate);
		  
		  //Execute Join Column
		  Question que = new Question();
		  String q = "select q.question,a.answer from Question as q inner join q.ans as a";
		   Query createQuery3 = s.createQuery(q);
		   List<Object[]> resultList = createQuery3.getResultList();
		  for(Object[] arr:resultList){
			  System.out.println(Arrays.toString(arr));
		  }
		  tx.commit();

	}

}
