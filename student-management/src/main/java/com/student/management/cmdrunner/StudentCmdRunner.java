package com.student.management.cmdrunner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.student.management.entity.Student;
import com.student.management.repository.StudentMangementRepository;

@Component
public class StudentCmdRunner implements CommandLineRunner {

	
	@Autowired
	private StudentMangementRepository repositoryS;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		repositoryS.save(new Student("Shubham", "Rajit", 26, LocalDate.now(), "12th"));
		repositoryS.save(new Student("Pravesh", "Dixit", 27, LocalDate.now(), "12th"));
		repositoryS.save(new Student("Brijesh", "Kumar", 25, LocalDate.now(), "12th"));
		
			
	}

}
