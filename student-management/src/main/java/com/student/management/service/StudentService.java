package com.student.management.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.entity.Student;
import com.student.management.repository.StudentMangementRepository;
import com.student.management.resources.StudentResource;

@Service
public class StudentService {

	private Logger log = LoggerFactory.getLogger(StudentService.class);
	@Autowired
	private StudentMangementRepository repository;


	
	public List<Student> getListOfAllStudents() {

		List<Student> student = repository.findAll();
		// studentInfo.setStudentInfoList(studentList);

		if (student.isEmpty())
			log.info("Hellow list is empty");

		return student;
	}



	public Student getStudentById(long id) {
		
		Optional<Student> student = repository.findById(id);
		if(student.isEmpty())
			return null;
		
		return student.get();
	}



	public long addNewStudentToDb(Student st) {
		
	Student student = repository.save(st);
	
	return student.getStudentId();
	}
	/*
	 *Generating secure random number to send along with new add response 
	 */
	private String generateRandomId() {
		SecureRandom secureRandom = new SecureRandom();
		String randomId = new BigInteger(32, secureRandom).toString();
		return randomId;
	}



	public void deleteStudetnByGivenId(long id) {
		repository.deleteById(id);
	}

}
