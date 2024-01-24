package com.hibernet.HibernateProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.TransactionRequiredException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class SqlExample {

	public static void main(String[] args) {
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s=f.openSession();
		Transaction tx = s.beginTransaction();
		
		
		//Student std = new Student();
		/*try{			
			String sql = "select * from student where deleted='Y'";
		    NativeQuery createSQLQuery = s.createSQLQuery(sql);
		    createSQLQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		    List<Student> list = createSQLQuery.list();
		    std.setStlist(list);
			System.out.println(std);
		}catch(Exception e){
			e.getMessage();
		}*/
		
		List<Student> stdlist = new ArrayList<Student>();
		try{
			String sql = "select * from student";
			 NativeQuery createSQLQuery = s.createSQLQuery(sql);
			 createSQLQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			 List<Map<String,Object>> list = createSQLQuery.list();
			 
			 for(Map<String,Object> row :list){
				 Student std = new Student();
				 std.setStudentName((String) row.get("studentName"));
				 std.setStdId((Integer) row.get("stdId"));
				 std.setDeleted((String) row.get("deleted"));
				
				// System.out.println(row.get("stdId"));
				 Integer a = (Integer) row.get("stdId");
				// int id = 1;
				
				 String sql1="select question from  question where que_id='"+a+"'";
				 NativeQuery createSQLQuery2 = s.createSQLQuery(sql1);
				 createSQLQuery2.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
				 List list2 = createSQLQuery2.getResultList();
				   
				 std.setQuestion(list2);
				 stdlist.add(std);
				 
			 }
			 System.out.println(stdlist);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		tx.commit();
		
		
	}

}
