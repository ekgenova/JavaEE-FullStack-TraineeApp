package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String subjectName;
	private int subjectScore;
	
	public Subject() {
		
	}
	
	public Subject(String subjectName, int subjectScore) {
		this.subjectName = subjectName;
		this.subjectScore = subjectScore;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectScore() {
		return subjectScore;
	}

	public void setSubjectScore(int subjectScore) {
		this.subjectScore = subjectScore;
	}
}
