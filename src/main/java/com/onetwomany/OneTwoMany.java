package com.onetwomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneTwoMany {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory fectory = cfg.buildSessionFactory();
		Session session =  fectory.openSession();
		Transaction tx= session.beginTransaction();
		
		//Create Answer
		
		Question que = new Question();
		que.setQuestion("What is Java");
		
		Answer ans = new Answer();
		ans.setAnswer("Java is oopl");
		
		Answer ans1 = new Answer();
		ans1.setAnswer("Java is simple");
		
		Answer ans2 = new Answer();
		ans2.setAnswer("Java is plateform independant");
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(ans);
		list.add(ans1);
		list.add(ans2);
		
		que.setAns(list);
		
		session.save(que);
//		session.save(ans);
//		session.save(ans1);
//		session.save(ans2);
	
		tx.commit();
		
		Question q=session.get(Question.class, 1);
		System.out.println(q.getQuestion());
		
		for(Answer a:q.getAns()){
			System.out.println(a);
		}
	}

}
