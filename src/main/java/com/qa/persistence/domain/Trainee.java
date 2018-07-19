package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Trainee {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@NotNull
	@Size(min=2, max=50)
	private String firstName;
	@NotNull
	@Size(min=2, max=50)
	private String secondName;
	@JoinColumn(name = "trainee_id")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Subject> subjects;
		
	public Trainee() {
		
	}
	
	public Trainee(String firstName, String secondName, List<Subject> subjects) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.subjects = subjects;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
