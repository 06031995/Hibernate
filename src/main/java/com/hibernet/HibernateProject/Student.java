package com.hibernet.HibernateProject;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stdId;
	
	private String studentName;
	
	@Transient
	private List<Student> stlist;
	

	private String city;
	
	@Temporal(TemporalType.DATE)
	private Date createddate;
	
	private String deleted="N";

	
	@Column(name = "created_date_time",updatable=false)
	private String createdDateTime;
	
	@Transient
	private List question;

	


	public List getQuestion() {
		return question;
	}

	public void setQuestion(List question) {
		this.question = question;
	}

	public List<Student> getStlist() {
		return stlist;
	}

	public void setStlist(List<Student> stlist) {
		this.stlist = stlist;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Student(int stdId, String studentName, String city, String deleted) {
		super();
		this.stdId = stdId;
		this.studentName = studentName;
		this.city = city;
	
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", studentName=" + studentName + ", stlist=" + stlist + ", city=" + city
				+ ", createddate=" + createddate + ", deleted=" + deleted + ", createdDateTime=" + createdDateTime
				+ ", question=" + question + "]";
	}

	
	
	
	
}
