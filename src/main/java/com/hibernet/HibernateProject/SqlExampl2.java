package com.hibernet.HibernateProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.sun.xml.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class SqlExampl2 {

	public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = factory.openSession();
	   /* Student st = new Student();
	    List<Student> list = new ArrayList<Student>();
	   try {
		
		   String sql = " select * from student";
		    Query createSQLQuery = session.createSQLQuery(sql);
		    createSQLQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		     list = createSQLQuery.list();
		    //st.setStlist(list);
		    System.out.println(list);
	} catch (Exception e) {
		e.printStackTrace();
	}*/
	
	
	
	   
	  /* try {
		   
		   String sql = "select * from student";
		   Query query=session.createSQLQuery(sql);
		   query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		   List<Map<String,Object>> list = query.list();
		   List< Student> std = new ArrayList();
		   Student st1 = new Student();
		   for(Map<String,Object> row : list){
			   Student st = new Student();
			    Integer a= (Integer) row.get("stdId");
			    st.setStdId(a);
			    st.setStudentName((String) row.get("studentName"));
			    st.setDeleted((String) row.get("deleted"));
			    std.add(st);
		   }
		  
		   System.out.println(std);
		   
		
	} catch (Exception e) {
       e.printStackTrace();
	}*/
	
	 try {
		   String s = "j";
		  Criteria createCriteria = session.createCriteria(Student.class);
		  createCriteria.setFirstResult(0);
		  createCriteria.setMaxResults(3);
		 // createCriteria.add(Restrictions.eq("stdId", 1));
		  createCriteria.add(Restrictions.like("city", s+"%"));
		  List<Student> list = createCriteria.list();
		  System.out.println(list);
		
	} catch (Exception e) {
        e.printStackTrace();
	 }
	
	}

}
