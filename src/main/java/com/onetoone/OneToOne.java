package com.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne {

	public static void main(String[] args) {
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory fectory = cfg.buildSessionFactory();
	Session session =  fectory.openSession();
	Transaction tx= session.beginTransaction();
	
	//Question
	Question que = new Question();
	que.setQuestion("What is Java?");
	
	Question que1 = new Question();
	que1.setQuestion("what is html");
	
	Answer ans = new Answer();
	ans.setAnswer("Java is Oopl");
	
	Answer ans1 = new Answer();
	ans1.setAnswer("hiper text markup");
	que.setAns(ans);
	que1.setAns(ans1);
	
	session.save(que);
	session.save(ans);
	session.save(que1);
	session.save(ans1);
	
	tx.commit();
	
	//fetch
	
	Question q=session.get(Question.class, 2);
	System.out.println(q.getQuestion()+"="+q.getAns().getAnswer());
	
	fectory.close();

	}

}
