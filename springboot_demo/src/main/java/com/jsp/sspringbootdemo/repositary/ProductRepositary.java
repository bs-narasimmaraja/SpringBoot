package com.jsp.sspringbootdemo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springbootdemo.dto.Product;

public interface ProductRepositary extends JpaRepository<Product,Integer>{

}
