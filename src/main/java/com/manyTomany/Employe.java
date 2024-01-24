package com.manyTomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Employe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int emp_id;
	
	private String emp_name;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Project> project;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
