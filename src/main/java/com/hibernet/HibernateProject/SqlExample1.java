package com.hibernet.HibernateProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SqlExample1 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		/*Student std = new Student();
		List<Student> stdlist = new ArrayList();
		   
		try{
			String sql = "select * from student";
			 NativeQuery createSQLQuery = session.createSQLQuery(sql);
			 createSQLQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			 List<Map<String,Object>> list = createSQLQuery.list();
			 
			 for(Map<String,Object> row : list){
				 Student st = new Student();
				 st.setStdId((Integer) row.get("stdId"));
				 st.setStudentName((String) row.get("studentName"));
				 stdlist.add(st);
			 }
			System.out.println(stdlist);
		}catch(Exception e){
			e.printStackTrace();
		}*/
		/*Student std = new Student();
		try{
			String sql = "select * from student";
			 NativeQuery createSQLQuery = session.createSQLQuery(sql);
			 createSQLQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			  List<Student> list = createSQLQuery.list();
			  std.setStlist(list);
			  System.out.println(std);
			  
			
		}catch(Exception e){
			e.printStackTrace();
			
		}*/
		
		try{
			 Criteria createCriteria = session.createCriteria(Student.class);
			 createCriteria.setFirstResult(0);
			 createCriteria.setMaxResults(2);
			  List<Student> list = createCriteria.list();
			  System.out.println(list);
		}catch(Exception e){
			e.getMessage();
		}
	}

}
