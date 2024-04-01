package com.jsp.sspringbootdemo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springbootdemo.dto.Student;

public interface StudentRepositary extends JpaRepository<Student,Integer>{
	
	List<Student> findbyName(String name);
	
	
	List<Student> findbyAge(int age);
	
}
