package com.student.management.entity;

import java.util.List;


public class StudentInfo {

	
	private List<Student> studentInfoList;

	public StudentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentInfo(List<Student> studentInfoList) {
		super();
		this.studentInfoList = studentInfoList;
	}

	public List<Student> getStudentInfoList() {
		return studentInfoList;
	}

	
	  public void setStudentInfoList(List<Student> studentInfoList) {
	  this.studentInfoList = studentInfoList; }
	 

	@Override
	public String toString() {
		return "StudentInfo [studentInfoList=" + studentInfoList + "]";
	}
	
	
	
}
