package com.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.entity.Student;

public interface StudentMangementRepository extends JpaRepository<Student, Long> {

	
}
