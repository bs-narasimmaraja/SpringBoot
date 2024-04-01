package com.jsp.springdemo.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring_demo.helper.ResponseStructure;
import com.jsp.springbootdemo.dto.Product;
import com.jsp.springbootdemo.dto.Student;
import com.jsp.springbootdemo.exception.NoStudentFoundException;
import com.jsp.sspringbootdemo.repositary.StudentRepositary;

@RestController
public class HomeController {
	@Autowired(required = true)
	StudentRepositary sr;
	@PostMapping("/Save")
	//@postmapping is used to handle post request
	public ResponseStructure<Student> saveStudent(@RequestBody Student s) {
		sr.save(s);
		ResponseStructure<Student> rs=new ResponseStructure<Student>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setData(s);
		rs.setMessage("data saved successfully");
		return rs;
		
}
	@GetMapping("/fetchbyId")
	public ResponseStructure<Student> fetchStudentById(@RequestParam("id") int id){
	Optional<Student> option=sr.findById(id);
	try {
	Student s=option.get();
	
	ResponseStructure<Student>  rs=new ResponseStructure<Student>();
	rs.setStatuscode(HttpStatus.FOUND.value());
	rs.setData(s);
	rs.setMessage("data found");
	
	return rs;
	}
	catch(NoSuchElementException e) {
		ResponseStructure<Student> rs=new ResponseStructure<Student>();
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setData(null);
		rs.setMessage("notfound");
	
	return rs;
	}
	}
	@GetMapping("/fetchDataByName")
	public ResponseStructure<List<Student>> fetchStudentbyName(@RequestParam("name") String name){
		List<Student> students=sr.findbyName(name);
		
		if(students.size()>0) {
			ResponseStructure<List<Student>> rs=new ResponseStructure<List<Student>>();
			rs.setStatuscode(HttpStatus.FOUND.value());
			rs.setData(students);
			rs.setMessage("data found");
			return rs;
		}
		else {
			ResponseStructure<List<Student>> rs=new ResponseStructure<List<Student>>();
			rs.setStatuscode(HttpStatus.NOT_FOUND.value());
			rs.setData(null);
			rs.setMessage("not found");

		
		return rs;
		}
	}
	@PutMapping("/updatestudent")
	public ResponseStructure<Student> updateStudent(@RequestBody Student s){
		sr.save(s);
		
		ResponseStructure<Student> rs=new ResponseStructure<Student>();
		rs.setStatuscode(HttpStatus.ACCEPTED.value());
		rs.setData(s);
		rs.setMessage("data updated successfully");
		
		return rs;
		
}
	@DeleteMapping("/deletestudent")
	public ResponseStructure<Student> deleteStudent(@RequestParam int id){
		Student s=sr.findById(id).get();
		
		sr.deleteById(id);
		
		ResponseStructure<Student> rs=new ResponseStructure<Student>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setData(s);
		rs.setMessage("data saved successfully");
		
		return rs;
		
	} 
	@GetMapping("/fetchstudentdetailsbyid")
	public ResponseStructure<Student> fetchStudentDetailsById(@RequestParam int id){
		Optional<Student> option=sr.findById(id);
		
		try {
			Student s=option.get();
			ResponseStructure<Student> rs=new ResponseStructure<Student>();
			rs.setStatuscode(HttpStatus.FOUND.value());
			rs.setData(s);
			rs.setMessage("data found");
			return rs;
		}
		catch(NoSuchElementException e) {
			throw new NoStudentFoundException("no student found ");
		}
		
	}
}
