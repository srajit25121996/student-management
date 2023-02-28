package com.student.management.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private long studentId;
	@Column
	private String studentFirstName;

	@Column
	private String studentLastName;

	@Column
	private int age;

	@Column
	private LocalDate dateOfAddmission;

	@Column
	private String currentStandard;

	
	public Student() {

	}

	public Student( String studentFirstName, String studentLastName, int age, LocalDate dateOfAddmission,
			String currentStandard) {
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.age = age;
		this.dateOfAddmission = dateOfAddmission;
		this.currentStandard = currentStandard;
		
	}

	

	public long getStudentId() {
		return studentId;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public int getAge() {
		return age;
	}

	public LocalDate getDateOfAddmission() {
		return dateOfAddmission;
	}

	public String getCurrentStandard() {
		return currentStandard;
	}

}
