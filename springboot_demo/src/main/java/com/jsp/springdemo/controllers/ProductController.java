package com.jsp.springdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring_demo.helper.ResponseStructure;
import com.jsp.springbootdemo.dto.Product;
import com.jsp.sspringbootdemo.repositary.ProductRepositary;

@RestController
public class ProductController {
	@Autowired
	ProductRepositary pr;
	
	@PostMapping("/saveProduct")
	public ResponseStructure<Product> SaveStudent(@RequestBody Product p){
		return null;
		
	}
}
