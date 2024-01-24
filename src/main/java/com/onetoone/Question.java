package com.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int question_id;
	
	private String question;
	
	@OneToOne
	private Answer ans;


	public int getQuestion_id() {
		return question_id;
	}


	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public Answer getAns() {
		return ans;
	}


	public void setAns(Answer ans) {
		this.ans = ans;
	}


	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", question=" + question + ", ans=" + ans + "]";
	}

	
}
