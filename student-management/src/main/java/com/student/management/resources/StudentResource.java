package com.student.management.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.student.management.entity.Student;
import com.student.management.service.StudentService;

@RestController
public class StudentResource {

	@Autowired
	private StudentService studentService;

	/*
	 * @Get list of all students
	 */
	@RequestMapping("/students")
	public List<Student> retrieveAllStudents() {
		List<Student> students = studentService.getListOfAllStudents();
		if (students.isEmpty())
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		return students;
	}

	/*
	 * @getStudentById
	 */
	@RequestMapping("/students/{id}")
	public Student retrieveStudentById(@PathVariable long id) {

		Student student = studentService.getStudentById(id);

		if (student == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Object with given " + id + " is not available.");

		return student;
	}

	/*
	 * @Add student
	 */
	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public ResponseEntity<Object> addNewStudent(@RequestBody Student st) {
		long studentId = studentService.addNewStudentToDb(st);
		URI location = ServletUriComponentsBuilder
				       .fromCurrentRequest()
				       .path("/{studentId}")
				       .buildAndExpand(studentId)
				       .toUri();
		return ResponseEntity.created(location).build();

	}

	/*
	 * @delete student
	 */ 
	@RequestMapping(value="/students/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStudentById(@PathVariable long id){
		studentService.deleteStudetnByGivenId(id);
		
		return ResponseEntity.noContent().build();
	}

}
