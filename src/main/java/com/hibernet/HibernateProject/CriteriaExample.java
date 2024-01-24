package com.hibernet.HibernateProject;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter;
import org.hibernate.transform.AliasToBeanResultTransformer;

public class CriteriaExample {

	public static void main(String[] args) {

		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session s = f.openSession();

		/*try{
		  Criteria createCriteria = s.createCriteria(Student.class);
		  createCriteria.setFirstResult(0);
		   List<Student> list = createCriteria.list();
		   System.out.println(list);
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		Student std = new Student();
		Criteria c = s.createCriteria(Student.class);
		c.setFirstResult(0);
		c.setMaxResults(2);
		List<Student> list = c.list();
		System.out.println(list);
		std.setStlist(list);
		System.out.println(std);

		s.close();
		
		
		//-------------call SP----------------------//
		/*try {
			  NativeQuery addEntity = s.createSQLQuery("call getstudentById(:stdId,:studentName)");
			  addEntity.setParameter("stdId", 1);
			  addEntity.setParameter("studentName", "Rahul");
			  addEntity.addEntity(Student.class);
			  List<Student> list = addEntity.list();
			  System.out.println(list);
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
		

	}

}
